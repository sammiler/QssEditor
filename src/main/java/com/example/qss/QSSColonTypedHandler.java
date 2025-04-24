package com.example.qss; // 确认你的包名

import com.intellij.application.options.CodeStyle;
import com.intellij.codeInsight.AutoPopupController;
import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.ScrollType;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;

import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.psi.codeStyle.CodeStyleSettings; // **已添加 CodeStyleSettings**
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
// import java.util.Arrays; // 如果需要可以取消注释
// import java.util.Collections; // 如果需要可以取消注释

public class QSSColonTypedHandler extends TypedHandlerDelegate {

    // *** 用于触发自动补全的字符 Set ***
    private static final Set<Character> AUTO_POPUP_CHARS = Set.of(
            ':', ',', '>', '.', '#', '*',
            '[', ']', '(', ')', '=', '~', '|'
    );

    // *** 处理 '{' 输入的方法 ***
    @Override
    public @NotNull Result beforeCharTyped(char c,
                                           @NotNull Project project,
                                           @NotNull Editor editor,
                                           @NotNull PsiFile file,
                                           @NotNull FileType fileType) {

        // 1. 检查是否是 QSS 文件以及输入的字符是否是 '{'
        if (!file.getLanguage().is(QSSLanguage.INSTANCE) || c != '{') {
            return Result.CONTINUE;
        }

        // 2. 获取文档和插入位置
        Document document = editor.getDocument();
        int offset = editor.getCaretModel().getOffset();

        // 3. 计算缩进 (使用更新后的辅助方法)
        String indentStep = getIndentStep(project, file);
        String currentLineIndent = getCurrentLineIndent(project, file, offset);
        String innerIndent = currentLineIndent + indentStep;
        String closingBraceIndent = currentLineIndent;

        // 4. 构建要插入的文本块
        final String textToInsert = "{\n" + innerIndent + "\n" + closingBraceIndent + "}";

        // 5. 使用 CommandProcessor 包装写入操作
        CommandProcessor.getInstance().executeCommand(project, () -> {
            ApplicationManager.getApplication().runWriteAction(() -> {
                // 插入文本块
                document.insertString(offset, textToInsert);

                // 6. 计算并移动光标到正确的位置
                int caretOffset = offset + 1 + 1 + innerIndent.length();
                editor.getCaretModel().moveToOffset(caretOffset);

                // 7. 确保光标可见
                editor.getScrollingModel().scrollToCaret(ScrollType.RELATIVE);

                // (可选) 8. 提交文档更改
                // PsiDocumentManager.getInstance(project).commitDocument(document);
            });
        }, "Insert QSS Block", null);

        // 10. 阻止默认的 '{' 字符插入
        return Result.STOP;
    }


    // *** 处理字符输入后触发补全的方法 ***
    @Override
    public @NotNull Result charTyped(char c, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file) {
        // 确保是 QSS 文件
        if (!(file.getLanguage().is(QSSLanguage.INSTANCE))) {
            return Result.CONTINUE;
        }

        // *** 直接检查输入的字符是否在 Set 中 ***
        if (AUTO_POPUP_CHARS.contains(c)) {
            // 手动触发补全
            AutoPopupController.getInstance(project).autoPopupMemberLookup(editor, null);
        }
        // *************************************

        // 返回 CONTINUE，允许其他 TypedHandlerDelegate 继续处理
        return Result.CONTINUE;
    }

    // *** 获取缩进的辅助方法 (已更新) ***
    /**
     * 获取代码风格设置中定义的单个缩进层级对应的字符串 (tab 或 空格)。
     * 使用 CodeStyle.getSettings(file) 替代废弃的方法。
     */
    private String getIndentStep(Project project, PsiFile file) {
        // *** 修改：使用 CodeStyle.getSettings(file) ***
        final CodeStyleSettings settings = CodeStyle.getSettings(file);
        CommonCodeStyleSettings commonSettings = settings.getCommonSettings(file.getLanguage());
        // ******************************************

        CommonCodeStyleSettings.IndentOptions indentOptions = commonSettings.getIndentOptions();
        if (indentOptions != null && indentOptions.USE_TAB_CHARACTER) {
            return "\t";
        } else if (indentOptions != null && indentOptions.INDENT_SIZE > 0) {
            return StringUtil.repeatSymbol(' ', indentOptions.INDENT_SIZE);
        }
        return "    "; // 回退默认值
    }

    /**
     * 获取指定偏移量所在行的当前缩进。
     */
    private String getCurrentLineIndent(Project project, PsiFile file, int offset) {
        // 确保 PSI 与文档同步，这对 CodeStyleManager 也很重要
        PsiDocumentManager.getInstance(project).commitAllDocuments();
        // CodeStyleManager.getLineIndent 内部会获取正确的设置
        String indent = CodeStyleManager.getInstance(project).getLineIndent(file, offset);
        return indent != null ? indent : "";
    }
}
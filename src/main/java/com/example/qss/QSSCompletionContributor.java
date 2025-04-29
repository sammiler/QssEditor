package com.example.qss;

import com.example.qss.psi.QSSPropertyList;
import com.example.qss.psi.QSSRule;
import com.example.qss.psi.QSSTypes;
import com.example.qss.util.QssPsiUtil;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class QSSCompletionContributor extends CompletionContributor {
    public QSSCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(QSSLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        PsiElement position = parameters.getPosition();

                        // 获取前一个可见的 leaf 元素
                        PsiElement prevLeaf = PsiTreeUtil.prevVisibleLeaf(position);
                        IElementType prevType = (prevLeaf != null) ? prevLeaf.getNode().getElementType() : null;
                        String prevText = (prevLeaf != null) ? prevLeaf.getText() : null;
                        // 根据上下文调用对应的补全函数
                        if (!QssPsiUtil.isInCodeBlock(position)) {
                            addSelectorCompletions(resultSet, position);
                        }else{
                            addBlockCompletions(resultSet, parameters, prevType);
                        }
                    }
                }
        );
    }
    private void addBlockCompletions(CompletionResultSet resultSet, CompletionParameters parameters, IElementType prevType) {

        // --- Handler for Properties (插入属性名后加 ": ") ---
        // (这个 Handler 保持不变，或者使用我上次优化后的版本)
        InsertHandler<LookupElement> propertyInsertHandler = (context, item) -> {
            Editor editor = context.getEditor();
            Document document = editor.getDocument();
            int tailOffset = context.getTailOffset();
            if (tailOffset >= document.getTextLength() || document.getCharsSequence().charAt(tailOffset) != ':') {
                document.insertString(tailOffset, ": ");
                editor.getCaretModel().moveToOffset(tailOffset + 2);
            } else if (tailOffset + 1 >= document.getTextLength() || document.getCharsSequence().charAt(tailOffset + 1) != ' ') {
                document.insertString(tailOffset + 1, " ");
                editor.getCaretModel().moveToOffset(tailOffset + 2);
            } else {
                editor.getCaretModel().moveToOffset(tailOffset + 2);
            }
        };


        // --- Handler for Values (改进了冒号检查逻辑) ---
        InsertHandler<LookupElement> valueInsertHandler = (context, item) -> {
            Editor editor = context.getEditor();
            Document document = editor.getDocument();
            int startOffset = context.getStartOffset(); // 补全开始的位置
            int tailOffset = context.getTailOffset();   // 补全项插入后的结束位置

            // 1. 检查并插入冒号和空格 ": " (改进逻辑)
            boolean needsColon = true;
            int checkOffset = startOffset - 1; // 开始检查的位置

            // 向前回溯，跳过所有空白符
            while (checkOffset >= 0 && Character.isWhitespace(document.getCharsSequence().charAt(checkOffset))) {
                checkOffset--;
            }

            // 检查回溯后找到的第一个非空白字符是否是冒号
            if (checkOffset >= 0 && document.getCharsSequence().charAt(checkOffset) == ':') {
                needsColon = false; // 找到了冒号，不需要再插入
                // 检查冒号和当前值之间是否需要插入空格
                if (startOffset > checkOffset + 1) {
                    // 如果冒号和值之间有其他字符(通常是空格，但也可能是误输入的其他字符)
                    // 这里可以根据需要决定是否强制插入/确保只有一个空格
                    // 简单起见，如果找到冒号，我们假设用户已经处理好了空格，或者IDE的格式化会处理
                } else if (startOffset == checkOffset + 1) {
                    // 冒号后面紧跟着值，插入一个空格
                    document.insertString(startOffset, " ");
                    tailOffset++; // 因为插入了空格，结束位置后移
                }
            }

            // 如果确实需要插入冒号 (向前回溯没有找到冒号)
            if (needsColon) {
                // 在补全项插入的位置（startOffset）之前插入 ": "
                document.insertString(startOffset, ": ");
                // 因为在值前面插入了2个字符，所以值的结束位置也要向后移动2
                tailOffset += 2;
                // 光标移动到新插入的冒号和空格之后，方便后续的值补全 (如果适用)
                // 注意：因为值已经插入，所以我们主要是调整 tailOffset
                // 光标最终会被移动到分号后，所以这里不需要移动光标
            }


            // 2. 在值的后面插入分号 ";" 并移动光标 (逻辑不变)
            if (tailOffset >= document.getTextLength() || document.getCharsSequence().charAt(tailOffset) != ';') {
                document.insertString(tailOffset, ";");
                editor.getCaretModel().moveToOffset(tailOffset + 1);
            } else {
                editor.getCaretModel().moveToOffset(tailOffset + 1);
            }
            // 可以选择插入 "; " 或 ";\n"
            // document.insertString(tailOffset, "; ");
            // editor.getCaretModel().moveToOffset(tailOffset + 2);
        };

        // --- 添加补全项 (逻辑不变) ---
        if (prevType == QSSTypes.LBRACE || prevType == QSSTypes.SEMICOLON) {
            QSSKeywords.getProperties().forEach(p ->
                    resultSet.addElement(LookupElementBuilder.create(p)
                            .withInsertHandler(propertyInsertHandler) // 属性用 property handler
                    ));
        }
        // 当是在 : 之后补全时，提供值建议 (或潜在的值位置)
        // 这里 prevType == QSSTypes.COLON 仍然是一个重要的触发条件
        // 但 valueInsertHandler 内部的检查会处理实际情况
        else if (shouldOfferValueCompletion(parameters.getPosition())) { // 使用更健壮的判断逻辑
            QSSKeywords.getValueKeywords().forEach(p ->
                    resultSet.addElement(LookupElementBuilder.create(p)
                            .withInsertHandler(valueInsertHandler) // 值用 value handler
                    ));
            // 添加其他值类型的补全...
        }
    }

    /**
     * 更健壮地判断当前位置是否适合提供 QSS 值的补全建议。
     * (这是一个示例，你需要根据你的 PSI 结构调整)
     */
    private boolean shouldOfferValueCompletion(PsiElement position) {
        // 方案1：检查前一个可见叶子节点是否是冒号
        PsiElement prevLeaf = PsiTreeUtil.prevVisibleLeaf(position);
        if (prevLeaf != null && prevLeaf.getNode().getElementType() == QSSTypes.COLON) {
            return true;
        }

        // 方案2：检查父元素结构 (更可靠)
        // 假设你的属性结构是 QSSProperty -> (QSSPropertyName, COLON, QSSValue)
        PsiElement parent = position.getParent();
        // 如果当前光标的父元素是 QSSValue (表示已经在输入值了)
        // 或者父元素是 QSSProperty，且光标在 COLON 之后
        // (你需要根据你的 PSI 结构编写具体的判断逻辑)
        // 例如:
        // if (parent instanceof QSSValueImpl) { // 假设你的值 PSI 元素实现类
        //     return true;
        // }
        // if (parent instanceof QSSPropertyImpl) { // 假设你的属性 PSI 元素实现类
        //     ASTNode colonNode = parent.getNode().findChildByType(QSSTypes.COLON);
        //     if (colonNode != null && position.getTextOffset() > colonNode.getStartOffset()) {
        //        return true;
        //     }
        // }

        // 简单的回退：如果 prevType 是 COLON，也认为可以提供值
        // (这行是为了兼容你之前的逻辑，但最好用上面的 PSI 判断)
        IElementType prevType = (prevLeaf != null) ? prevLeaf.getNode().getElementType() : null;
        if (prevType == QSSTypes.COLON) {
            return true;
        }


        // 默认不提供值补全
        return false;
    }
    /**
     * 补全 Selector 部分的建议
     */
    private void addSelectorCompletions(CompletionResultSet resultSet,PsiElement position) {

        PsiElement parent = position.getParent();
        if (parent != null)
        {
             IElementType type = parent.getNode().getElementType();
             if (type == QSSTypes.WIDGET_SELECTOR)
             {
                 QSSKeywords.getWidgets().forEach(w -> resultSet.addElement(LookupElementBuilder.create(w)));
                 resultSet.addElement(LookupElementBuilder.create("*"));
                 resultSet.addElement(LookupElementBuilder.create("."));
                 resultSet.addElement(LookupElementBuilder.create("#"));
             }
             else if (type == QSSTypes.PSEUDO_STATE)
             {
                 QSSKeywords.getPseudoStates().forEach(p -> resultSet.addElement(LookupElementBuilder.create(p)));
             }
             else if (type == QSSTypes.PSEUDO_ELEMENT)
             {
                 QSSKeywords.getSubControls().forEach(sc -> resultSet.addElement(LookupElementBuilder.create(sc)));
             }
             else if (type == QSSTypes.HASH_SELECTOR)
             {
                 resultSet.addElement(LookupElementBuilder.create("myClass"));
             }
             else if (type == QSSTypes.CLASS_SELECTOR)
             {
                 resultSet.addElement(LookupElementBuilder.create("myClass"));
             }
        }
    }

}
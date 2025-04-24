package com.example.qss.highlighting;


import com.example.qss.psi.*;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class QSSAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        // 检查当前访问的 PSI 元素是否是你的 widget_selector 规则对应的类型
        // 你需要找到 GrammarKit 为你的 widget_selector 规则实际生成的 PSI 接口/类名
        if (element instanceof QSSWidgetSelector) { // <--- 使用你的实际 PSI 类名
            // 创建一个“静默”的注解，只应用文本属性，不显示图标或波浪线
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(QSSSyntaxHighlighter.KEYWORD) // <--- 应用你定义好的 KEYWORD 高亮属性
                    .create();
        }
         else if (element instanceof QSSPropertyName)
        {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(QSSSyntaxHighlighter.PROPERTY_NAME) // <--- 应用你定义好的 KEYWORD 高亮属性
                    .create();
        }
         else if (element instanceof QSSPseudoState)
        {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(QSSSyntaxHighlighter.PSEUDO_NAME) // <--- 应用你定义好的 KEYWORD 高亮属性
                    .create();
        }

        // 你还可以在这里添加其他基于 PSI 的检查和高亮逻辑
        // 例如，检查属性名是否已知，检查颜色值是否有效等
    }
}
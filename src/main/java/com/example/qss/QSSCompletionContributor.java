package com.example.qss;

import com.example.qss.psi.QSSPropertyList;
import com.example.qss.psi.QSSRule;
import com.example.qss.psi.QSSTypes;
import com.example.qss.util.QssPsiUtil;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.ASTNode;
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
                            addBlockCompletions(resultSet, prevText, prevType);
                        }
                    }
                }
        );
    }
    private void addBlockCompletions(CompletionResultSet resultSet, String prevText, IElementType prevType)
    {
        if (prevType == QSSTypes.LBRACE || prevType == QSSTypes.SEMICOLON)
        {
            QSSKeywords.getProperties().forEach(p -> resultSet.addElement(LookupElementBuilder.create(p)));
        }
        else if (prevType == QSSTypes.COLON)
        {
            QSSKeywords.getValueKeywords().forEach(p -> resultSet.addElement(LookupElementBuilder.create(p)));
        }
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
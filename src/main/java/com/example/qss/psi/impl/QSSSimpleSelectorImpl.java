// This is a generated file. Not intended for manual editing.
package com.example.qss.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.example.qss.psi.QSSTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.example.qss.psi.*;

public class QSSSimpleSelectorImpl extends ASTWrapperPsiElement implements QSSSimpleSelector {

  public QSSSimpleSelectorImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull QSSVisitor visitor) {
    visitor.visitSimpleSelector(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof QSSVisitor) accept((QSSVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<QSSAttributeSelector> getAttributeSelectorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, QSSAttributeSelector.class);
  }

  @Override
  @NotNull
  public QSSBaseSelector getBaseSelector() {
    return findNotNullChildByClass(QSSBaseSelector.class);
  }

  @Override
  @NotNull
  public List<QSSClassSelector> getClassSelectorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, QSSClassSelector.class);
  }

  @Override
  @Nullable
  public QSSHashSelector getHashSelector() {
    return findChildByClass(QSSHashSelector.class);
  }

  @Override
  @NotNull
  public List<QSSPseudoElement> getPseudoElementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, QSSPseudoElement.class);
  }

  @Override
  @NotNull
  public List<QSSPseudoState> getPseudoStateList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, QSSPseudoState.class);
  }

}

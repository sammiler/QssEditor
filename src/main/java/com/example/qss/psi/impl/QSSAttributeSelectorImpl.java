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

public class QSSAttributeSelectorImpl extends ASTWrapperPsiElement implements QSSAttributeSelector {

  public QSSAttributeSelectorImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull QSSVisitor visitor) {
    visitor.visitAttributeSelector(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof QSSVisitor) accept((QSSVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public QSSAttributeOperator getAttributeOperator() {
    return findChildByClass(QSSAttributeOperator.class);
  }

}

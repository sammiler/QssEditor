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

public class QSSRuleImpl extends ASTWrapperPsiElement implements QSSRule {

  public QSSRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull QSSVisitor visitor) {
    visitor.visitRule(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof QSSVisitor) accept((QSSVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public QSSPropertyList getPropertyList() {
    return findChildByClass(QSSPropertyList.class);
  }

  @Override
  @NotNull
  public QSSSelectorList getSelectorList() {
    return findNotNullChildByClass(QSSSelectorList.class);
  }

}

// This is a generated file. Not intended for manual editing.
package com.example.qss.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface QSSSimpleSelector extends QSSPsiElement {

  @NotNull
  List<QSSAttributeSelector> getAttributeSelectorList();

  @NotNull
  QSSBaseSelector getBaseSelector();

  @NotNull
  List<QSSClassSelector> getClassSelectorList();

  @Nullable
  QSSHashSelector getHashSelector();

  @NotNull
  List<QSSPseudoElement> getPseudoElementList();

  @NotNull
  List<QSSPseudoState> getPseudoStateList();

}

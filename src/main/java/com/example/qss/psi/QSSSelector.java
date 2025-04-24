// This is a generated file. Not intended for manual editing.
package com.example.qss.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface QSSSelector extends QSSPsiElement {

  @NotNull
  List<QSSCombinator> getCombinatorList();

  @NotNull
  List<QSSSimpleSelector> getSimpleSelectorList();

}

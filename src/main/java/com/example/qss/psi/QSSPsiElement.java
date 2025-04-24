package com.example.qss.psi;

import com.intellij.psi.PsiElement;
// Add other imports if your QSSPsiElement interface includes more specific methods

// This is a base interface for all custom PSI elements in your QSS language.
// All Grammar-Kit generated PSI element interfaces (like QSSClassSelector, QSSRule etc.)
// will extend this interface if you specify 'implements = "com.example.qss.psi.QSSPsiElement"' in BNF header.
public interface QSSPsiElement extends PsiElement {
    // Add any common methods here that all your QSS PSI elements should have.
    // For now, extending PsiElement is sufficient.
}
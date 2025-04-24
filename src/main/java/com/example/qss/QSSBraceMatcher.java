package com.example.qss;

import com.example.qss.psi.QSSTypes; // Import your generated token types
import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class QSSBraceMatcher implements PairedBraceMatcher {

    // Define the pairs of braces/brackets/parentheses
    private static final BracePair[] PAIRS = new BracePair[]{
            // Curly braces {} - mark as structural (true) for potential auto-indentation on Enter
            new BracePair(QSSTypes.LBRACE, QSSTypes.RBRACE, true),
            // Parentheses () - usually not structural
            new BracePair(QSSTypes.LPAREN, QSSTypes.RPAREN, false),
            // Square brackets [] - usually not structural
            new BracePair(QSSTypes.LBRACKET, QSSTypes.RBRACKET, false)
    };

    @Override
    public BracePair @NotNull [] getPairs() {
        return PAIRS;
    }

    // Determines if an opening brace should be automatically inserted when typed
    // before a character of the given type. Often allows insertion before whitespace,
    // comments, or closing braces/parens/brackets.
    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        // Basic implementation: Allow inserting opening braces before whitespace,
        // comments, semicolons, commas, or closing braces/parens/brackets.
        // You might need to adjust this based on your language grammar.
        return contextType == null // End of file
                || com.intellij.psi.TokenType.WHITE_SPACE == contextType
                || contextType == QSSTypes.SEMICOLON
                || contextType == QSSTypes.COMMA
                || contextType == QSSTypes.RBRACE
                || contextType == QSSTypes.RPAREN
                || contextType == QSSTypes.RBRACKET
                // Also allow before comments if your lexer produces comment tokens
                || contextType == QSSTypes.BLOCK_COMMENT // Add line comment token if you have one
                // Allow if the contextType is part of the brace pairs closing tokens
                || isClosingBrace(contextType);
        // Potentially add other token types depending on QSS syntax rules
    }

    private boolean isClosingBrace(IElementType contextType){
        if (contextType == null) return false;
        for (BracePair pair : PAIRS) {
            if (pair.getRightBraceType() == contextType) {
                return true;
            }
        }
        return false;
    }

    // This method helps structure-aware navigation (like Ctrl+[ or Ctrl+])
    // It should return the starting offset of the code construct (e.g., rule block)
    // containing the given offset.
    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        // Find the PsiElement at the brace offset
        PsiElement braceElement = file.findElementAt(openingBraceOffset);
        if (braceElement == null) {
            return openingBraceOffset; // Default fallback
        }

        // Look for the parent element that represents the code block (e.g., QSSRule)
        // Adjust the PsiElement class (QSSRule.class) if your grammar uses a different
        // element type for the block enclosed by braces.
        com.example.qss.psi.QSSRule ruleElement = com.intellij.psi.util.PsiTreeUtil.getParentOfType(braceElement, com.example.qss.psi.QSSRule.class);

        if (ruleElement != null) {
            // Return the starting offset of the rule element
            return ruleElement.getTextRange().getStartOffset();
        }

        // Fallback if no specific parent block element is found
        return openingBraceOffset;
    }
}
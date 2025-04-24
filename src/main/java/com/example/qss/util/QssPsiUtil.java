package com.example.qss.util;

import com.example.qss.psi.QSSTypes;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.PsiComment;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull; // If position cannot be null

// Import your specific QSS token types if available and preferred for checking
// import your.plugin.qss.psi.QssTokenTypes; 

public class QssPsiUtil { // Or any utility class name you prefer


    // Indicates the method might return null
    public static boolean isInCodeBlock(@NotNull PsiElement position) {
        // Start searching from the leaf immediately before 'position'
        PsiElement currentElement = PsiTreeUtil.prevVisibleLeaf(position);

        while (currentElement != null) {

            // If we reach here, the currentElement is NOT whitespace or comment.
            // This is the "visible" leaf we were looking for.
            if ( currentElement.getNode().getElementType().equals(QSSTypes.RBRACE))
            {
                break;
            }
            if ( currentElement.getNode().getElementType().equals(QSSTypes.LBRACE))
            {
                return true;
            }

            currentElement = PsiTreeUtil.prevVisibleLeaf(currentElement);
           ; // Return the type and exit
        }

        return false;
    }

}
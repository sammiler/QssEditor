package com.example.qss.psi;

import com.example.qss.QSSLanguage; // Import your language instance
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

// Base class for IElementType instances representing TOKENS (terminals)
public class QSSTokenType extends IElementType {
    public QSSTokenType(@NotNull @NonNls String debugName) {
        super(debugName, QSSLanguage.INSTANCE);
    }

    // Optional: Override toString() for better debug output if needed
    @Override
    public String toString() {
        return super.toString();
    }
}
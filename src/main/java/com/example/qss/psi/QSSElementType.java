package com.example.qss.psi;

import com.example.qss.QSSLanguage; // Import your language instance
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

// Base class for IElementType instances representing RULES (non-terminals)
public class QSSElementType extends IElementType {
    public QSSElementType(@NotNull @NonNls String debugName) {
        super(debugName, QSSLanguage.INSTANCE);
    }
}
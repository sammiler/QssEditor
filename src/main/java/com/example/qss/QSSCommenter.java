package com.example.qss;

import com.intellij.lang.Commenter;
import org.jetbrains.annotations.Nullable;

public class QSSCommenter implements Commenter {

    // Prefix for line comments (QSS doesn't have standard single-line comments like //)
    // Return null if only block comments are supported by Ctrl+/
    @Nullable
    @Override
    public String getLineCommentPrefix() {
        return null; // Or "// " if you decide QSS should support line comments
    }

    // Prefix for block comments (/*)
    @Nullable
    @Override
    public String getBlockCommentPrefix() {
        return "/*";
    }

    // Suffix for block comments (*/)
    @Nullable
    @Override
    public String getBlockCommentSuffix() {
        return "*/";
    }

    // Prefix for commented block comments (for nested comments, often same as prefix)
    // Return null if nesting isn't supported or desired
    @Nullable
    @Override
    public String getCommentedBlockCommentPrefix() {
        // You might return null or handle nested comments if your lexer/parser supports them
        return "/*";
    }

    // Suffix for commented block comments (for nested comments, often same as suffix)
    @Nullable
    @Override
    public String getCommentedBlockCommentSuffix() {
        return "*/";
    }
}
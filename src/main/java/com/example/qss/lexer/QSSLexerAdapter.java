package com.example.qss.lexer;

import com.intellij.lexer.FlexAdapter;

public class QSSLexerAdapter extends FlexAdapter {
    public QSSLexerAdapter() {
        super(new QSSLexer(null));
    }
}
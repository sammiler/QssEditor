package com.example.qss;

import com.intellij.lang.Language;

public class QSSLanguage extends Language {
    public static final QSSLanguage INSTANCE = new QSSLanguage();

    private QSSLanguage() {
        super("QSS");
    }
}
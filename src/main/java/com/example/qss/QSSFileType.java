package com.example.qss;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class QSSFileType extends LanguageFileType {
    public static final QSSFileType INSTANCE = new QSSFileType();

    private QSSFileType() {
        super(QSSLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "QSS File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Qt Style Sheet file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "qss";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return QssIcons.FILE; // Use default icon or customize
    }
}
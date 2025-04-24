package com.example.qss.psi.impl; // Typically in the psi.impl package

import com.example.qss.QSSFileType; // Need to import your FileType
import com.example.qss.QSSLanguage; // Need to import your Language
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class QSSFileImpl extends PsiFileBase {
    public QSSFileImpl(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, QSSLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return QSSFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "QSS File";
    }
}
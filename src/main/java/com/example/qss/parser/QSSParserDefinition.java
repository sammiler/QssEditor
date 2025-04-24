package com.example.qss.parser;

import com.example.qss.QSSLanguage;
import com.example.qss.lexer.QSSLexerAdapter;
import com.example.qss.psi.QSSTypes;
import com.example.qss.psi.impl.QSSFileImpl;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

public class QSSParserDefinition implements ParserDefinition {
    public static final IFileElementType FILE = new IFileElementType(QSSLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new QSSLexerAdapter();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new QSSParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return TokenSet.create(TokenType.WHITE_SPACE);
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return TokenSet.create(QSSTypes.BLOCK_COMMENT);
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.create(QSSTypes.STRING);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return QSSTypes.Factory.createElement(node);
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new QSSFileImpl(viewProvider);
    }
}
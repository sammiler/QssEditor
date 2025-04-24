package com.example.qss.highlighting;

import com.example.qss.lexer.QSSLexerAdapter; // 引入你的 Lexer 适配器
import com.example.qss.psi.QSSTypes; // 引入你的 Token 类型
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class QSSSyntaxHighlighter extends SyntaxHighlighterBase {

    // 定义各种元素的文本属性 Key
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("QSS_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey KEYWORD = // 例如 Widget 名称，属性名
            createTextAttributesKey("QSS_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey IDENTIFIER = // 普通标识符，值
            createTextAttributesKey("QSS_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("QSS_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("QSS_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey BRACES =
            createTextAttributesKey("QSS_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey PARENTHESES =
            createTextAttributesKey("QSS_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey BRACKETS =
            createTextAttributesKey("QSS_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey OPERATORS = // 像 : :: , > 等
            createTextAttributesKey("QSS_OPERATORS", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("QSS_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey PROPERTY_NAME =
            createTextAttributesKey("QSS_PROPERTY_NAME", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey PSEUDO_NAME =
            createTextAttributesKey("QSS_PSEUDO_NAME", DefaultLanguageHighlighterColors.METADATA);

    private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<>();

    static {
        // 填充 ATTRIBUTES 映射
        fillMap(ATTRIBUTES, COMMENT, QSSTypes.BLOCK_COMMENT); // 使用你定义的 Block Comment 类型
        fillMap(ATTRIBUTES, BRACES, QSSTypes.LBRACE, QSSTypes.RBRACE);
        fillMap(ATTRIBUTES, PARENTHESES, QSSTypes.LPAREN, QSSTypes.RPAREN);
        fillMap(ATTRIBUTES, BRACKETS, QSSTypes.LBRACKET, QSSTypes.RBRACKET);
        fillMap(ATTRIBUTES, STRING, QSSTypes.STRING);
        fillMap(ATTRIBUTES, NUMBER, QSSTypes.NUMBER); // Color 也当作数字高亮
        fillMap(ATTRIBUTES, OPERATORS, QSSTypes.COLON, QSSTypes.DOUBLE_COLON, QSSTypes.SEMICOLON,
                QSSTypes.COMMA, QSSTypes.GT, QSSTypes.DOT, QSSTypes.ASTERISK,
                QSSTypes.EQUALS, QSSTypes.TILDE_EQUALS, QSSTypes.PIPE_EQUALS);

        // 你可以根据需要更细致地区分关键字等
        fillMap(ATTRIBUTES,IDENTIFIER , QSSTypes.IDENTIFIER);

        // 处理坏字符
        fillMap(ATTRIBUTES, BAD_CHARACTER, TokenType.BAD_CHARACTER);
    }


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new QSSLexerAdapter(); // 返回你的 Lexer
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        // pack 方法会根据 ATTRIBUTES 查找，找不到返回空数组
        return pack(ATTRIBUTES.get(tokenType));
    }
}
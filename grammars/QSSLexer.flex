package com.example.qss.lexer;

// Keeping your desired imports for QSSTypes
import com.example.qss.psi.QSSTypes;
import static com.example.qss.psi.QSSTypes.*; // Static import for direct token names

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType; // Needed for standard TokenType constants
import com.intellij.psi.tree.IElementType;import org.w3c.dom.css.RGBColor;

// Optional: static imports for standard TokenType if you prefer
// import static com.intellij.psi.TokenType.BAD_CHARACTER;
// import static com.intellij.psi.TokenType.WHITE_SPACE;


%%

%class QSSLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}

// Macro definitions based on comprehensive QSS analysis and QML comparison
// Standard Identifiers

IDENTIFIER = [a-zA-Z_][a-zA-Z0-9_-]*
RGB_COLOR=rgb(a)?\(\s*\d{1,3}\s*,\s*\d{1,3}\s*,\s*\d{1,3}(,\s*(\d*\.?\d+|\d{1,3}%))?\s*\)
HASH_ID = #[0-9a-zA-Z]+
QPROPERTY_IDENTIFIER = "qproperty-"[a-zA-Z_][a-zA-Z0-9_-]* // qproperty- prefixed identifiers

LENGTH = \d+(\.\d+)?(px|pt|em|%)
// Values
NUMBER = "-"?(\d+(\.\d*)?|\.\d+) // Numbers with optional sign and units
STRING = \"([^\"\\]|\\.)*\" | \'([^'\\]|\\.)*\' // Double or single quoted strings
URL = url\( ([^)\\]|\\.)* \) // url(...) function value

// Comments (Using QML's BLOCK_COMMENT Regex as requested)
BLOCK_COMMENT="/*" ( ([^"*"]|[\r\n])* ("*"+ [^"*""/"] )? )* ("*" | "*"+"/")?
// LINE_COMMENT is NOT supported in standard QSS, so it's removed.

// Whitespace (Using QML's explicit split for plain whitespace and newline)
PLAIN_WHITESPACE = [ \t\r\f]+ // Spaces, tabs, carriage return, form feed
NEWLINE = [\n]+ // Newline character

// Catch-all for any other character
ANY_CHAR = [^]


%%

// --- Rules in suggested order ---
// Priority order: fixed strings > complex patterns > specific identifiers > general patterns > error catch-all
// This order helps resolve ambiguities and prioritize common tokens for correct matching.

// 1. Standard whitespace and Comments (process early, Parser usually skips via ParserDefinition)
{PLAIN_WHITESPACE}      { return TokenType.WHITE_SPACE; } // Return standard WHITE_SPACE for plain whitespace
{NEWLINE}               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; } // Handle newlines specially, reset state, return standard WHITE_SPACE
{BLOCK_COMMENT}         { return BLOCK_COMMENT; } // Return token from QSSTypes (via static import)



// 2. Operator tokens (fixed strings, precise matches) - Return from QSSTypes (via static import)
"{"         { return LBRACE; }
"}"         { return RBRACE; }
";"         { return SEMICOLON; }
"::"        { return DOUBLE_COLON; }
":"         { return COLON; }
","         { return COMMA; }
">"         { return GT; }
"."         { return DOT; } // . prefix for class selectors
"*"         { return ASTERISK; } // Universal selector
"["         { return LBRACKET; } // Attribute selector start
"]"         { return RBRACKET; } // Attribute selector end
"("         { return LPAREN; } // Function arg list start
")"         { return RPAREN; } // Function arg list end
"="         { return EQUALS; } // In attribute selectors / qproperty values
"~="        { return TILDE_EQUALS; } // In attribute selectors
"|="        { return PIPE_EQUALS; } // In attribute selectors
"!"         { return  PRIORITY_MARKER;}
"#"         {   return  HASH;  }

{LENGTH}    { return LENGTH; }
// 3. Specific Identifiers (match before general IDENTIFIER)
// QPROPERTY_IDENTIFIER must come BEFORE general IDENTIFIER as it's more specific
{QPROPERTY_IDENTIFIER}  { return QPROPERTY_IDENTIFIER; } // Return token from QSSTypes
// WIDGET_IDENTIFIER must come BEFORE general IDENTIFIER as it's more specific

{RGB_COLOR}             { return RGB_COLOR; }  //return RGB COLOR
// 4. Complex but clear patterns (should not match single letters easily)
{STRING}                { return STRING; } // Return token from QSSTypes

{URL}                   { return URL; } // Return token from QSSTypes

{HASH_ID}               { return HASH_ID;}
// 5. General Identifier (Catches property names, value keywords, pseudo-state/sub-control names, etc.)
{IDENTIFIER} {
    // Return token from QSSTypes. Parser will distinguish usage based on rules/context.
    return IDENTIFIER;
}

// 6. Numbers
{NUMBER}                { return NUMBER; } // Return token from QSSTypes


// 7. Error token (catch anything else) - Return standard BAD_CHARACTER
{ANY_CHAR}              { return TokenType.BAD_CHARACTER; } // Use TokenType for standard BAD_CHARACTER
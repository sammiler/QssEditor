// This is a generated file. Not intended for manual editing.
package com.example.qss.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.example.qss.psi.impl.*;

public interface QSSTypes {

  IElementType ARGUMENT = new QSSElementType("ARGUMENT");
  IElementType ARGUMENT_LIST = new QSSElementType("ARGUMENT_LIST");
  IElementType ATTRIBUTE_OPERATOR = new QSSElementType("ATTRIBUTE_OPERATOR");
  IElementType ATTRIBUTE_SELECTOR = new QSSElementType("ATTRIBUTE_SELECTOR");
  IElementType BASE_SELECTOR = new QSSElementType("BASE_SELECTOR");
  IElementType CLASS_SELECTOR = new QSSElementType("CLASS_SELECTOR");
  IElementType COMBINATOR = new QSSElementType("COMBINATOR");
  IElementType HASH_SELECTOR = new QSSElementType("HASH_SELECTOR");
  IElementType PROPERTY = new QSSElementType("PROPERTY");
  IElementType PROPERTY_LIST = new QSSElementType("PROPERTY_LIST");
  IElementType PROPERTY_NAME = new QSSElementType("PROPERTY_NAME");
  IElementType PSEUDO_ELEMENT = new QSSElementType("PSEUDO_ELEMENT");
  IElementType PSEUDO_STATE = new QSSElementType("PSEUDO_STATE");
  IElementType RULE = new QSSElementType("RULE");
  IElementType SELECTOR = new QSSElementType("SELECTOR");
  IElementType SELECTOR_LIST = new QSSElementType("SELECTOR_LIST");
  IElementType SIMPLE_SELECTOR = new QSSElementType("SIMPLE_SELECTOR");
  IElementType SIMPLE_VALUE = new QSSElementType("SIMPLE_VALUE");
  IElementType UNEXPECTED_LIST_ITEM = new QSSElementType("UNEXPECTED_LIST_ITEM");
  IElementType UNIVERSAL_SELECTOR = new QSSElementType("UNIVERSAL_SELECTOR");
  IElementType VALUE = new QSSElementType("VALUE");
  IElementType VALUE_LIST = new QSSElementType("VALUE_LIST");
  IElementType WIDGET_SELECTOR = new QSSElementType("WIDGET_SELECTOR");

  IElementType ANY = new QSSTokenType("ANY");
  IElementType ASTERISK = new QSSTokenType("*");
  IElementType BLOCK_COMMENT = new QSSTokenType("BLOCK_COMMENT");
  IElementType COLON = new QSSTokenType(":");
  IElementType COMMA = new QSSTokenType(",");
  IElementType DOT = new QSSTokenType(".");
  IElementType DOUBLE_COLON = new QSSTokenType("::");
  IElementType EOF = new QSSTokenType("EOF");
  IElementType EQUALS = new QSSTokenType("=");
  IElementType GT = new QSSTokenType(">");
  IElementType HASH = new QSSTokenType("#");
  IElementType HASH_ID = new QSSTokenType("HASH_ID");
  IElementType IDENTIFIER = new QSSTokenType("IDENTIFIER");
  IElementType LBRACE = new QSSTokenType("{");
  IElementType LBRACKET = new QSSTokenType("[");
  IElementType LENGTH = new QSSTokenType("LENGTH");
  IElementType LPAREN = new QSSTokenType("(");
  IElementType NUMBER = new QSSTokenType("NUMBER");
  IElementType PIPE_EQUALS = new QSSTokenType("|=");
  IElementType PRIORITY_MARKER = new QSSTokenType("!");
  IElementType QPROPERTY_IDENTIFIER = new QSSTokenType("QPROPERTY_IDENTIFIER");
  IElementType RBRACE = new QSSTokenType("}");
  IElementType RBRACKET = new QSSTokenType("]");
  IElementType RGB_COLOR = new QSSTokenType("RGB_COLOR");
  IElementType RPAREN = new QSSTokenType(")");
  IElementType SEMICOLON = new QSSTokenType(";");
  IElementType STRING = new QSSTokenType("STRING");
  IElementType TILDE_EQUALS = new QSSTokenType("~=");
  IElementType URL = new QSSTokenType("URL");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGUMENT) {
        return new QSSArgumentImpl(node);
      }
      else if (type == ARGUMENT_LIST) {
        return new QSSArgumentListImpl(node);
      }
      else if (type == ATTRIBUTE_OPERATOR) {
        return new QSSAttributeOperatorImpl(node);
      }
      else if (type == ATTRIBUTE_SELECTOR) {
        return new QSSAttributeSelectorImpl(node);
      }
      else if (type == BASE_SELECTOR) {
        return new QSSBaseSelectorImpl(node);
      }
      else if (type == CLASS_SELECTOR) {
        return new QSSClassSelectorImpl(node);
      }
      else if (type == COMBINATOR) {
        return new QSSCombinatorImpl(node);
      }
      else if (type == HASH_SELECTOR) {
        return new QSSHashSelectorImpl(node);
      }
      else if (type == PROPERTY) {
        return new QSSPropertyImpl(node);
      }
      else if (type == PROPERTY_LIST) {
        return new QSSPropertyListImpl(node);
      }
      else if (type == PROPERTY_NAME) {
        return new QSSPropertyNameImpl(node);
      }
      else if (type == PSEUDO_ELEMENT) {
        return new QSSPseudoElementImpl(node);
      }
      else if (type == PSEUDO_STATE) {
        return new QSSPseudoStateImpl(node);
      }
      else if (type == RULE) {
        return new QSSRuleImpl(node);
      }
      else if (type == SELECTOR) {
        return new QSSSelectorImpl(node);
      }
      else if (type == SELECTOR_LIST) {
        return new QSSSelectorListImpl(node);
      }
      else if (type == SIMPLE_SELECTOR) {
        return new QSSSimpleSelectorImpl(node);
      }
      else if (type == SIMPLE_VALUE) {
        return new QSSSimpleValueImpl(node);
      }
      else if (type == UNEXPECTED_LIST_ITEM) {
        return new QSSUnexpectedListItemImpl(node);
      }
      else if (type == UNIVERSAL_SELECTOR) {
        return new QSSUniversalSelectorImpl(node);
      }
      else if (type == VALUE) {
        return new QSSValueImpl(node);
      }
      else if (type == VALUE_LIST) {
        return new QSSValueListImpl(node);
      }
      else if (type == WIDGET_SELECTOR) {
        return new QSSWidgetSelectorImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

// This is a generated file. Not intended for manual editing.
package com.example.qss.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.example.qss.psi.QSSTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class QSSParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return stylesheet(b, l + 1);
  }

  /* ********************************************************** */
  // simple_value  (COLON simple_value+ )?
  public static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = simple_value(b, l + 1);
    r = r && argument_1(b, l + 1);
    exit_section_(b, l, m, r, false, QSSParser::argument_recover);
    return r;
  }

  // (COLON simple_value+ )?
  private static boolean argument_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_1")) return false;
    argument_1_0(b, l + 1);
    return true;
  }

  // COLON simple_value+
  private static boolean argument_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && argument_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simple_value+
  private static boolean argument_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simple_value(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!simple_value(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argument_1_0_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // argument (COMMA argument)*
  public static boolean argument_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_LIST, "<argument list>");
    r = argument(b, l + 1);
    p = r; // pin = 1
    r = r && argument_list_1(b, l + 1);
    exit_section_(b, l, m, r, p, QSSParser::argument_list_recover);
    return r || p;
  }

  // (COMMA argument)*
  private static boolean argument_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argument_list_1", c)) break;
    }
    return true;
  }

  // COMMA argument
  private static boolean argument_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && argument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(COMMA | RPAREN | SEMICOLON | LBRACE  | EOF | COLON) ANY
  static boolean argument_list_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_recover")) return false;
    if (!nextTokenIs(b, ANY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = argument_list_recover_0(b, l + 1);
    r = r && consumeToken(b, ANY);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(COMMA | RPAREN | SEMICOLON | LBRACE  | EOF | COLON)
  private static boolean argument_list_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !argument_list_recover_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMA | RPAREN | SEMICOLON | LBRACE  | EOF | COLON
  private static boolean argument_list_recover_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_recover_0_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, LBRACE);
    if (!r) r = consumeToken(b, EOF);
    if (!r) r = consumeToken(b, COLON);
    return r;
  }

  /* ********************************************************** */
  // !(COMMA | RPAREN | EOF | COLON | SEMICOLON) ANY
  static boolean argument_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_recover")) return false;
    if (!nextTokenIs(b, ANY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = argument_recover_0(b, l + 1);
    r = r && consumeToken(b, ANY);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(COMMA | RPAREN | EOF | COLON | SEMICOLON)
  private static boolean argument_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !argument_recover_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMA | RPAREN | EOF | COLON | SEMICOLON
  private static boolean argument_recover_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_recover_0_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, EOF);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // EQUALS | TILDE_EQUALS | PIPE_EQUALS
  public static boolean attribute_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_operator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_OPERATOR, "<attribute operator>");
    r = consumeToken(b, EQUALS);
    if (!r) r = consumeToken(b, TILDE_EQUALS);
    if (!r) r = consumeToken(b, PIPE_EQUALS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LBRACKET attribute_selector_content RBRACKET
  public static boolean attribute_selector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_selector")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_SELECTOR, null);
    r = consumeToken(b, LBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, attribute_selector_content(b, l + 1));
    r = p && consumeToken(b, RBRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // IDENTIFIER (attribute_operator attribute_value_in_selector)?
  static boolean attribute_selector_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_selector_content")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && attribute_selector_content_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (attribute_operator attribute_value_in_selector)?
  private static boolean attribute_selector_content_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_selector_content_1")) return false;
    attribute_selector_content_1_0(b, l + 1);
    return true;
  }

  // attribute_operator attribute_value_in_selector
  private static boolean attribute_selector_content_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_selector_content_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = attribute_operator(b, l + 1);
    r = r && attribute_value_in_selector(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER | STRING
  static boolean attribute_value_in_selector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_value_in_selector")) return false;
    if (!nextTokenIs(b, "", IDENTIFIER, STRING)) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, STRING);
    return r;
  }

  /* ********************************************************** */
  // widget_selector | universal_selector
  public static boolean base_selector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_selector")) return false;
    if (!nextTokenIs(b, "<base selector>", ASTERISK, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BASE_SELECTOR, "<base selector>");
    r = widget_selector(b, l + 1);
    if (!r) r = universal_selector(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LBRACE property_list RBRACE
  static boolean brace_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_block")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, property_list(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // DOT IDENTIFIER
  public static boolean class_selector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_selector")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, CLASS_SELECTOR, r);
    return r;
  }

  /* ********************************************************** */
  // GT
  public static boolean combinator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "combinator")) return false;
    if (!nextTokenIs(b, GT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GT);
    exit_section_(b, m, COMBINATOR, r);
    return r;
  }

  /* ********************************************************** */
  // !( SEMICOLON | RBRACE | COLON | LBRACE | QPROPERTY_IDENTIFIER | IDENTIFIER) ANY
  static boolean error_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "error_element")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = error_element_0(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, ANY);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // !( SEMICOLON | RBRACE | COLON | LBRACE | QPROPERTY_IDENTIFIER | IDENTIFIER)
  private static boolean error_element_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "error_element_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !error_element_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON | RBRACE | COLON | LBRACE | QPROPERTY_IDENTIFIER | IDENTIFIER
  private static boolean error_element_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "error_element_0_0")) return false;
    boolean r;
    r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, LBRACE);
    if (!r) r = consumeToken(b, QPROPERTY_IDENTIFIER);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  /* ********************************************************** */
  // HASH_ID
  public static boolean hash_selector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hash_selector")) return false;
    if (!nextTokenIs(b, HASH_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HASH_ID);
    exit_section_(b, m, HASH_SELECTOR, r);
    return r;
  }

  /* ********************************************************** */
  // property_name
  static boolean partial_property(PsiBuilder b, int l) {
    return property_name(b, l + 1);
  }

  /* ********************************************************** */
  // (property_name COLON)? value_list  SEMICOLON
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    r = property_0(b, l + 1);
    r = r && value_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (property_name COLON)?
  private static boolean property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0")) return false;
    property_0_0(b, l + 1);
    return true;
  }

  // property_name COLON
  private static boolean property_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property_name(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // property_list_content*
  public static boolean property_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_list")) return false;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_LIST, "<property list>");
    while (true) {
      int c = current_position_(b);
      if (!property_list_content(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "property_list", c)) break;
    }
    exit_section_(b, l, m, true, false, QSSParser::property_list_recover);
    return true;
  }

  /* ********************************************************** */
  // property | partial_property | unexpected_list_item | error_element
  static boolean property_list_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_list_content")) return false;
    boolean r;
    r = property(b, l + 1);
    if (!r) r = partial_property(b, l + 1);
    if (!r) r = unexpected_list_item(b, l + 1);
    if (!r) r = error_element(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // !( EOF) ANY
  static boolean property_list_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_list_recover")) return false;
    if (!nextTokenIs(b, ANY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property_list_recover_0(b, l + 1);
    r = r && consumeToken(b, ANY);
    exit_section_(b, m, null, r);
    return r;
  }

  // !( EOF)
  private static boolean property_list_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_list_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, EOF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // QPROPERTY_IDENTIFIER | IDENTIFIER
  public static boolean property_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_name")) return false;
    if (!nextTokenIs(b, "<property name>", IDENTIFIER, QPROPERTY_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_NAME, "<property name>");
    r = consumeToken(b, QPROPERTY_IDENTIFIER);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_COLON IDENTIFIER
  public static boolean pseudo_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pseudo_element")) return false;
    if (!nextTokenIs(b, DOUBLE_COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOUBLE_COLON, IDENTIFIER);
    exit_section_(b, m, PSEUDO_ELEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // COLON (PRIORITY_MARKER)? IDENTIFIER
  public static boolean pseudo_state(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pseudo_state")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && pseudo_state_1(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, PSEUDO_STATE, r);
    return r;
  }

  // (PRIORITY_MARKER)?
  private static boolean pseudo_state_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pseudo_state_1")) return false;
    consumeToken(b, PRIORITY_MARKER);
    return true;
  }

  /* ********************************************************** */
  // selector_list brace_block
  public static boolean rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RULE, "<rule>");
    r = selector_list(b, l + 1);
    p = r; // pin = 1
    r = r && brace_block(b, l + 1);
    exit_section_(b, l, m, r, p, QSSParser::rule_recover);
    return r || p;
  }

  /* ********************************************************** */
  // !(IDENTIFIER | ASTERISK | BLOCK_COMMENT  |  COLON | SEMICOLON | EOF) ANY
  static boolean rule_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_recover")) return false;
    if (!nextTokenIs(b, ANY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rule_recover_0(b, l + 1);
    r = r && consumeToken(b, ANY);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(IDENTIFIER | ASTERISK | BLOCK_COMMENT  |  COLON | SEMICOLON | EOF)
  private static boolean rule_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !rule_recover_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER | ASTERISK | BLOCK_COMMENT  |  COLON | SEMICOLON | EOF
  private static boolean rule_recover_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_recover_0_0")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, ASTERISK);
    if (!r) r = consumeToken(b, BLOCK_COMMENT);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, EOF);
    return r;
  }

  /* ********************************************************** */
  // simple_selector ( selector_combinator_part )*
  public static boolean selector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selector")) return false;
    if (!nextTokenIs(b, "<selector>", ASTERISK, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SELECTOR, "<selector>");
    r = simple_selector(b, l + 1);
    p = r; // pin = 1
    r = r && selector_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( selector_combinator_part )*
  private static boolean selector_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selector_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!selector_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "selector_1", c)) break;
    }
    return true;
  }

  // ( selector_combinator_part )
  private static boolean selector_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selector_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = selector_combinator_part(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (combinator)? simple_selector
  static boolean selector_combinator_part(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selector_combinator_part")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = selector_combinator_part_0(b, l + 1);
    r = r && simple_selector(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (combinator)?
  private static boolean selector_combinator_part_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selector_combinator_part_0")) return false;
    selector_combinator_part_0_0(b, l + 1);
    return true;
  }

  // (combinator)
  private static boolean selector_combinator_part_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selector_combinator_part_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = combinator(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // selector (COMMA selector)*
  public static boolean selector_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selector_list")) return false;
    if (!nextTokenIs(b, "<selector list>", ASTERISK, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SELECTOR_LIST, "<selector list>");
    r = selector(b, l + 1);
    p = r; // pin = 1
    r = r && selector_list_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (COMMA selector)*
  private static boolean selector_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selector_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!selector_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "selector_list_1", c)) break;
    }
    return true;
  }

  // COMMA selector
  private static boolean selector_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selector_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && selector(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // base_selector (hash_selector)? (class_selector)* (pseudo_element | pseudo_state | attribute_selector)*
  public static boolean simple_selector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_selector")) return false;
    if (!nextTokenIs(b, "<simple selector>", ASTERISK, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_SELECTOR, "<simple selector>");
    r = base_selector(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, simple_selector_1(b, l + 1));
    r = p && report_error_(b, simple_selector_2(b, l + 1)) && r;
    r = p && simple_selector_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (hash_selector)?
  private static boolean simple_selector_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_selector_1")) return false;
    simple_selector_1_0(b, l + 1);
    return true;
  }

  // (hash_selector)
  private static boolean simple_selector_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_selector_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = hash_selector(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (class_selector)*
  private static boolean simple_selector_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_selector_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!simple_selector_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simple_selector_2", c)) break;
    }
    return true;
  }

  // (class_selector)
  private static boolean simple_selector_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_selector_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = class_selector(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (pseudo_element | pseudo_state | attribute_selector)*
  private static boolean simple_selector_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_selector_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!simple_selector_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simple_selector_3", c)) break;
    }
    return true;
  }

  // pseudo_element | pseudo_state | attribute_selector
  private static boolean simple_selector_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_selector_3_0")) return false;
    boolean r;
    r = pseudo_element(b, l + 1);
    if (!r) r = pseudo_state(b, l + 1);
    if (!r) r = attribute_selector(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // NUMBER | STRING | HASH_ID | URL | RGB_COLOR | LENGTH | IDENTIFIER
  public static boolean simple_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_VALUE, "<simple value>");
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, HASH_ID);
    if (!r) r = consumeToken(b, URL);
    if (!r) r = consumeToken(b, RGB_COLOR);
    if (!r) r = consumeToken(b, LENGTH);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (top_level_item)*
  static boolean stylesheet(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stylesheet")) return false;
    while (true) {
      int c = current_position_(b);
      if (!stylesheet_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "stylesheet", c)) break;
    }
    return true;
  }

  // (top_level_item)
  private static boolean stylesheet_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stylesheet_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = top_level_item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // rule | BLOCK_COMMENT
  static boolean top_level_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_level_item")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rule(b, l + 1);
    if (!r) r = consumeToken(b, BLOCK_COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(SEMICOLON | RBRACE | IDENTIFIER | QPROPERTY_IDENTIFIER) (NUMBER | STRING | HASH_ID | URL | ASTERISK | LBRACKET | LPAREN)
  public static boolean unexpected_list_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unexpected_list_item")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNEXPECTED_LIST_ITEM, "<unexpected list item>");
    r = unexpected_list_item_0(b, l + 1);
    p = r; // pin = 1
    r = r && unexpected_list_item_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // !(SEMICOLON | RBRACE | IDENTIFIER | QPROPERTY_IDENTIFIER)
  private static boolean unexpected_list_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unexpected_list_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !unexpected_list_item_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON | RBRACE | IDENTIFIER | QPROPERTY_IDENTIFIER
  private static boolean unexpected_list_item_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unexpected_list_item_0_0")) return false;
    boolean r;
    r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, QPROPERTY_IDENTIFIER);
    return r;
  }

  // NUMBER | STRING | HASH_ID | URL | ASTERISK | LBRACKET | LPAREN
  private static boolean unexpected_list_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unexpected_list_item_1")) return false;
    boolean r;
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, HASH_ID);
    if (!r) r = consumeToken(b, URL);
    if (!r) r = consumeToken(b, ASTERISK);
    if (!r) r = consumeToken(b, LBRACKET);
    if (!r) r = consumeToken(b, LPAREN);
    return r;
  }

  /* ********************************************************** */
  // ASTERISK
  public static boolean universal_selector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "universal_selector")) return false;
    if (!nextTokenIs(b, ASTERISK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASTERISK);
    exit_section_(b, m, UNIVERSAL_SELECTOR, r);
    return r;
  }

  /* ********************************************************** */
  // simple_value
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = simple_value(b, l + 1);
    exit_section_(b, l, m, r, false, QSSParser::value_recover);
    return r;
  }

  /* ********************************************************** */
  // value+ (COMMA value)*  (LPAREN argument_list? RPAREN)?
  public static boolean value_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_list")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VALUE_LIST, "<value list>");
    r = value_list_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, value_list_1(b, l + 1));
    r = p && value_list_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, QSSParser::value_list_recover);
    return r || p;
  }

  // value+
  private static boolean value_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!value(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "value_list_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA value)*
  private static boolean value_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!value_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "value_list_1", c)) break;
    }
    return true;
  }

  // COMMA value
  private static boolean value_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LPAREN argument_list? RPAREN)?
  private static boolean value_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_list_2")) return false;
    value_list_2_0(b, l + 1);
    return true;
  }

  // LPAREN argument_list? RPAREN
  private static boolean value_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_list_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && value_list_2_0_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // argument_list?
  private static boolean value_list_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_list_2_0_1")) return false;
    argument_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !(COMMA | SEMICOLON | RPAREN | EOF | COLON ) ANY
  static boolean value_list_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_list_recover")) return false;
    if (!nextTokenIs(b, ANY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value_list_recover_0(b, l + 1);
    r = r && consumeToken(b, ANY);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(COMMA | SEMICOLON | RPAREN | EOF | COLON )
  private static boolean value_list_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_list_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !value_list_recover_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMA | SEMICOLON | RPAREN | EOF | COLON
  private static boolean value_list_recover_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_list_recover_0_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, EOF);
    if (!r) r = consumeToken(b, COLON);
    return r;
  }

  /* ********************************************************** */
  // !(COMMA | SEMICOLON  | RPAREN | EOF | COLON) ANY
  static boolean value_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_recover")) return false;
    if (!nextTokenIs(b, ANY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value_recover_0(b, l + 1);
    r = r && consumeToken(b, ANY);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(COMMA | SEMICOLON  | RPAREN | EOF | COLON)
  private static boolean value_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !value_recover_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMA | SEMICOLON  | RPAREN | EOF | COLON
  private static boolean value_recover_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_recover_0_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, EOF);
    if (!r) r = consumeToken(b, COLON);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean widget_selector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "widget_selector")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, WIDGET_SELECTOR, r);
    return r;
  }

}

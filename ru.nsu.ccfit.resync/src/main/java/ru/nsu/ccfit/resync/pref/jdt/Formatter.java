package ru.nsu.ccfit.resync.pref.jdt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Formatter extends AbstractPreferenceProvider {

    private static final String BUNDLE = "org.eclipse.jdt.core";
    private static final String DELIMETER = "/";
    private static final String PREFIX = BUNDLE + DELIMETER;

    // @formatter:off
    private static final List<String> OPTIONS = Collections.unmodifiableList(Arrays.asList(
            PREFIX + "org.eclipse.jdt.core.formatter.comment.insert_new_line_before_root_tags",
            PREFIX + "org.eclipse.jdt.core.formatter.disabling_tag",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_annotation",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_type_parameters",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_brace_in_type_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_type_arguments",
            PREFIX + "org.eclipse.jdt.core.formatter.brace_position_for_anonymous_type_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_colon_in_case",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_brace_in_array_initializer",
            PREFIX + "org.eclipse.jdt.core.formatter.comment.new_lines_at_block_boundaries",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_in_empty_annotation_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_before_closing_brace_in_array_initializer",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_annotation",
            PREFIX + "org.eclipse.jdt.core.formatter.blank_lines_before_field",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_while",
            PREFIX + "org.eclipse.jdt.core.formatter.use_on_off_tags",
            PREFIX + "org.eclipse.jdt.core.formatter." 
                   + "insert_space_between_empty_parens_in_annotation_type_member_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_before_else_in_if_statement",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_prefix_operator",
            PREFIX + "org.eclipse.jdt.core.formatter.keep_else_statement_on_same_line",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_ellipsis",
            PREFIX + "org.eclipse.jdt.core.formatter.comment.insert_new_line_for_parameter",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_brace_in_annotation_type_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.indent_breaks_compare_to_cases",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_at_in_annotation",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_multiple_fields",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_expressions_in_array_initializer",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_conditional_expression",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_paren_in_for",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_binary_operator",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_question_in_wildcard",
            PREFIX + "org.eclipse.jdt.core.formatter.brace_position_for_array_initializer",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_between_empty_parens_in_enum_constant",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_before_finally_in_try_statement",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_after_annotation_on_local_variable",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_before_catch_in_try_statement",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_paren_in_while",
            PREFIX + "org.eclipse.jdt.core.formatter.blank_lines_after_package",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_type_parameters",
            PREFIX + "org.eclipse.jdt.core.formatter.continuation_indentation",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_postfix_operator",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_arguments_in_method_invocation",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_angle_bracket_in_type_arguments",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_superinterfaces",
            PREFIX + "org.eclipse.jdt.core.formatter.blank_lines_before_new_chunk",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_binary_operator",
            PREFIX + "org.eclipse.jdt.core.formatter.blank_lines_before_package",
            PREFIX + "org.eclipse.jdt.core.compiler.source",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_enum_constant_arguments",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_constructor_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.comment.format_line_comments",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_closing_angle_bracket_in_type_arguments",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_enum_declarations",
            PREFIX + "org.eclipse.jdt.core.formatter.join_wrapped_lines",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_brace_in_block",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_arguments_in_explicit_constructor_call",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_method_invocation_arguments",
            PREFIX + "org.eclipse.jdt.core.formatter.blank_lines_before_member_type",
            PREFIX + "org.eclipse.jdt.core.formatter.align_type_members_on_columns",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_enum_constant",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_for",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_brace_in_method_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_selector_in_method_invocation",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_switch",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_unary_operator",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_colon_in_case",
            PREFIX + "org.eclipse.jdt.core.formatter.comment.indent_parameter_description",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_method_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_switch",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_brace_in_enum_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_angle_bracket_in_type_parameters",
            PREFIX + "org.eclipse.jdt.core.formatter.comment.clear_blank_lines_in_block_comment",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_in_empty_type_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.lineSplit",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_paren_in_if",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_between_brackets_in_array_type_reference",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_parenthesized_expression",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_explicitconstructorcall_arguments",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_brace_in_constructor_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.blank_lines_before_first_class_body_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_after_annotation_on_method",
            PREFIX + "org.eclipse.jdt.core.formatter.indentation.size",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_between_empty_parens_in_method_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.enabling_tag",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_paren_in_enum_constant",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_superclass_in_type_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_assignment",
            PREFIX + "org.eclipse.jdt.core.compiler.problem.assertIdentifier",
            PREFIX + "org.eclipse.jdt.core.formatter.tabulation.char",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_constructor_declaration_parameters",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_semicolon_in_try_resources",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_prefix_operator",
            PREFIX + "org.eclipse.jdt.core.formatter.indent_statements_compare_to_body",
            PREFIX + "org.eclipse.jdt.core.formatter.blank_lines_before_method",
            PREFIX + "org.eclipse.jdt.core.formatter.wrap_outer_expressions_when_nested",
            PREFIX + "org.eclipse.jdt.core.formatter.format_guardian_clause_on_one_line",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_colon_in_for",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_cast",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_parameters_in_constructor_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_colon_in_labeled_statement",
            PREFIX + "org.eclipse.jdt.core.formatter.brace_position_for_annotation_type_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_in_empty_method_body",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_method_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_method_invocation",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_try",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_bracket_in_array_allocation_expression",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_brace_in_enum_constant",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_annotation",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_at_in_annotation_type_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_method_declaration_throws",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_if",
            PREFIX + "org.eclipse.jdt.core.formatter.brace_position_for_switch",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_method_declaration_throws",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_parenthesized_expression_in_return",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_paren_in_annotation",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_question_in_conditional",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_question_in_wildcard",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_try",
            PREFIX + "org.eclipse.jdt.core.formatter." 
                   + "insert_space_before_closing_bracket_in_array_allocation_expression",
            PREFIX + "org.eclipse.jdt.core.formatter.comment.preserve_white_space_between_code_and_line_comments",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_parenthesized_expression_in_throw",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_type_arguments",
            PREFIX + "org.eclipse.jdt.core.compiler.problem.enumIdentifier",
            PREFIX + "org.eclipse.jdt.core.formatter.indent_switchstatements_compare_to_switch",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_ellipsis",
            PREFIX + "org.eclipse.jdt.core.formatter.brace_position_for_block",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_for_inits",
            PREFIX + "org.eclipse.jdt.core.formatter.brace_position_for_method_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.compact_else_if",
            PREFIX + "org.eclipse.jdt.core.formatter.wrap_before_or_operator_multicatch",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_array_initializer",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_for_increments",
            PREFIX + "org.eclipse.jdt.core.formatter.format_line_comment_starting_on_first_column",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_bracket_in_array_reference",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_after_annotation_on_field",
            PREFIX + "org.eclipse.jdt.core.formatter.brace_position_for_enum_constant",
            PREFIX + "org.eclipse.jdt.core.formatter.comment.indent_root_tags",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_enum_declarations",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_union_type_in_multicatch",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_explicitconstructorcall_arguments",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_brace_in_switch",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_method_declaration_parameters",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_superinterfaces",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_allocation_expression",
            PREFIX + "org.eclipse.jdt.core.formatter.tabulation.size",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_bracket_in_array_type_reference",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_after_opening_brace_in_array_initializer",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_closing_brace_in_block",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_bracket_in_array_reference",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_in_empty_enum_constant",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_angle_bracket_in_type_arguments",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_paren_in_constructor_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_constructor_declaration_throws",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_if",
            PREFIX + "org.eclipse.jdt.core.formatter.comment.clear_blank_lines_in_javadoc_comment",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_throws_clause_in_constructor_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_assignment_operator",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_assignment_operator",
            PREFIX + "org.eclipse.jdt.core.formatter.indent_empty_lines",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_synchronized",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_closing_paren_in_cast",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_method_declaration_parameters",
            PREFIX + "org.eclipse.jdt.core.formatter.brace_position_for_block_in_case",
            PREFIX + "org.eclipse.jdt.core.formatter.number_of_empty_lines_to_preserve",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_paren_in_method_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_catch",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_constructor_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_paren_in_method_invocation",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_bracket_in_array_reference",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_arguments_in_qualified_allocation_expression",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_and_in_type_parameter",
            PREFIX + "org.eclipse.jdt.core.compiler.compliance",
            PREFIX + "org.eclipse.jdt.core.formatter.continuation_indentation_for_array_initializer",
            PREFIX + "org.eclipse.jdt.core.formatter." 
                   + "insert_space_between_empty_brackets_in_array_allocation_expression",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_at_in_annotation_type_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_arguments_in_allocation_expression",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_cast",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_unary_operator",
            PREFIX + "org.eclipse.jdt.core.formatter." 
                   + "insert_space_before_closing_angle_bracket_in_parameterized_type_reference",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_brace_in_anonymous_type_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.keep_empty_array_initializer_on_one_line",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_in_empty_enum_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.keep_imple_if_on_one_line",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_constructor_declaration_parameters",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_closing_angle_bracket_in_type_parameters",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_at_end_of_file_if_missing",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_colon_in_for",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_colon_in_labeled_statement",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_parameterized_type_reference",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_superinterfaces_in_type_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_binary_expression",
            PREFIX + "org.eclipse.jdt.core.formatter.brace_position_for_enum_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_after_annotation_on_type",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_while",
            PREFIX + "org.eclipse.jdt.core.compiler.codegen.inlineJsrBytecode",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_paren_in_try",
            PREFIX + "org.eclipse.jdt.core.formatter.put_empty_statement_on_new_line",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_after_label",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_after_annotation_on_parameter",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_angle_bracket_in_type_parameters",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_between_empty_parens_in_method_invocation",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_before_while_in_do_statement",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_arguments_in_enum_constant",
            PREFIX + "org.eclipse.jdt.core.formatter.comment.format_javadoc_comments",
            PREFIX + "org.eclipse.jdt.core.formatter.comment.line_length",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_after_annotation_on_package",
            PREFIX + "org.eclipse.jdt.core.formatter.blank_lines_between_import_groups",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_enum_constant_arguments",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_semicolon",
            PREFIX + "org.eclipse.jdt.core.formatter.brace_position_for_constructor_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.number_of_blank_lines_at_beginning_of_method_body",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_colon_in_conditional",
            PREFIX + "org.eclipse.jdt.core.formatter.indent_body_declarations_compare_to_type_header",
            PREFIX + "org.eclipse.jdt.core.formatter." 
                   + "insert_space_before_opening_paren_in_annotation_type_member_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.wrap_before_binary_operator",
            PREFIX + "org.eclipse.jdt.core.formatter.indent_body_declarations_compare_to_enum_declaration_header",
            PREFIX + "org.eclipse.jdt.core.formatter.blank_lines_between_type_declarations",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_synchronized",
            PREFIX + "org.eclipse.jdt.core.formatter.indent_statements_compare_to_block",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_superinterfaces_in_enum_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.join_lines_in_comments",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_question_in_conditional",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_multiple_field_declarations",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_compact_if",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_for_inits",
            PREFIX + "org.eclipse.jdt.core.formatter.indent_switchstatements_compare_to_cases",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_array_initializer",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_colon_in_default",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_and_in_type_parameter",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_between_empty_parens_in_constructor_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.blank_lines_before_imports",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_colon_in_assert",
            PREFIX + "org.eclipse.jdt.core.formatter.comment.format_html",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_throws_clause_in_method_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_angle_bracket_in_type_parameters",
            PREFIX + "org.eclipse.jdt.core.formatter." 
                   + "insert_space_before_opening_bracket_in_array_allocation_expression",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_in_empty_anonymous_type_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_colon_in_conditional",
            PREFIX + "org.eclipse.jdt.core.formatter." 
                   + "insert_space_after_opening_angle_bracket_in_parameterized_type_reference",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_for",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_postfix_operator",
            PREFIX + "org.eclipse.jdt.core.formatter.comment.format_source_code",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_paren_in_synchronized",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_allocation_expression",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_constructor_declaration_throws",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_parameters_in_method_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_brace_in_array_initializer",
            PREFIX + "org.eclipse.jdt.core.compiler.codegen.targetPlatform",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_resources_in_try",
            PREFIX + "org.eclipse.jdt.core.formatter.use_tabs_only_for_leading_indentations",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_arguments_in_annotation",
            PREFIX + "org.eclipse.jdt.core.formatter.comment.format_header",
            PREFIX + "org.eclipse.jdt.core.formatter.comment.format_block_comments",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_enum_constant",
            PREFIX + "org.eclipse.jdt.core.formatter.alignment_for_enum_constants",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_new_line_in_empty_block",
            PREFIX + "org.eclipse.jdt.core.formatter.indent_body_declarations_compare_to_annotation_declaration_header",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_parenthesized_expression",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_paren_in_parenthesized_expression",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_catch",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_multiple_local_declarations",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_paren_in_switch",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_comma_in_for_increments",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_method_invocation",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_colon_in_assert",
            PREFIX + "org.eclipse.jdt.core.formatter.brace_position_for_type_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_brace_in_array_initializer",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_between_empty_braces_in_array_initializer",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_method_declaration",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_semicolon_in_for",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_paren_in_catch",
            PREFIX + "org.eclipse.jdt.core.formatter." 
                   + "insert_space_before_opening_angle_bracket_in_parameterized_type_reference",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_multiple_field_declarations",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_annotation",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_parameterized_type_reference",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_method_invocation_arguments",
            PREFIX + "org.eclipse.jdt.core.formatter.comment.new_lines_at_javadoc_boundaries",
            PREFIX + "org.eclipse.jdt.core.formatter.blank_lines_after_imports",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_comma_in_multiple_local_declarations",
            PREFIX + "org.eclipse.jdt.core.formatter.indent_body_declarations_compare_to_enum_constant_header",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_after_semicolon_in_for",
            PREFIX + "org.eclipse.jdt.core.formatter.never_indent_line_comments_on_first_column",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_semicolon_in_try_resources",
            PREFIX + "org.eclipse.jdt.core.formatter.insert_space_before_opening_angle_bracket_in_type_arguments",
            PREFIX + "org.eclipse.jdt.core.formatter.never_indent_block_comments_on_first_column",
            PREFIX + "org.eclipse.jdt.core.formatter.keep_then_statement_on_same_line"
            )); 
    // @formatter:on

    @Override
    protected Iterable<String> getOptions() {
        return OPTIONS;
    }

    @Override
    protected String getPrefix() {
        return PREFIX;
    }

    @Override
    protected String getBundle() {
        return BUNDLE;
    }

}

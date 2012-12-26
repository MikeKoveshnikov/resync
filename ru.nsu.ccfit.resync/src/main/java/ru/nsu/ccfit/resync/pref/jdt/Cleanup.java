package ru.nsu.ccfit.resync.pref.jdt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cleanup extends AbstractPreferenceProvider {

    private static final String BUNDLE = "org.eclipse.jdt.ui";
    private static final String DELIMETER = "/";
    private static final String PREFIX = BUNDLE + DELIMETER;

    // @formatter:off
    private static final List<String> OPTIONS = Collections.unmodifiableList(Arrays.asList(
            PREFIX + "cleanup.format_source_code",
            PREFIX + "cleanup.add_missing_annotations",
            PREFIX + "cleanup.use_this_for_non_static_method_access_only_if_necessary",
            PREFIX + "cleanup.remove_unused_private_types",
            PREFIX + "cleanup.qualify_static_member_accesses_through_instances_with_declaring_class",
            PREFIX + "cleanup.qualify_static_method_accesses_with_declaring_class",
            PREFIX + "cleanup.add_generated_serial_version_id",
            PREFIX + "cleanup.make_variable_declarations_final",
            PREFIX + "cleanup.add_missing_methods",
            PREFIX + "cleanup.always_use_this_for_non_static_field_access",
            PREFIX + "cleanup.remove_trailing_whitespaces_ignore_empty",
            PREFIX + "cleanup.correct_indentation",
            PREFIX + "cleanup.never_use_parentheses_in_expressions",
            PREFIX + "cleanup.add_serial_version_id",
            PREFIX + "cleanup.remove_unused_private_methods",
            PREFIX + "cleanup.use_this_for_non_static_field_access",
            PREFIX + "cleanup.use_blocks_only_for_return_and_throw",
            PREFIX + "cleanup.remove_unused_private_members",
            PREFIX + "cleanup.add_missing_override_annotations_interface_methods",
            PREFIX + "cleanup.remove_trailing_whitespaces_all",
            PREFIX + "cleanup.make_type_abstract_if_missing_method",
            PREFIX + "cleanup.always_use_this_for_non_static_method_access",
            PREFIX + "cleanup.remove_unnecessary_nls_tags",
            PREFIX + "cleanup.format_source_code_changes_only",
            PREFIX + "cleanup.qualify_static_field_accesses_with_declaring_class",
            PREFIX + "cleanup.add_missing_nls_tags",
            PREFIX + "cleanup.use_this_for_non_static_field_access_only_if_necessary",
            PREFIX + "cleanup.qualify_static_member_accesses_through_subtypes_with_declaring_class",
            PREFIX + "cleanup.remove_unnecessary_casts",
            PREFIX + "cleanup.qualify_static_member_accesses_with_declaring_class",
            PREFIX + "cleanup.use_parentheses_in_expressions",
            PREFIX + "cleanup.remove_unused_private_fields",
            PREFIX + "cleanup.make_parameters_final",
            PREFIX + "cleanup.remove_trailing_whitespaces",
            PREFIX + "cleanup.remove_unused_imports",
            PREFIX + "cleanup.organize_imports",
            PREFIX + "cleanup.sort_members",
            PREFIX + "cleanup.remove_private_constructors",
            PREFIX + "cleanup.convert_to_enhanced_for_loop",
            PREFIX + "cleanup.always_use_blocks",
            PREFIX + "cleanup.never_use_blocks",
            PREFIX + "cleanup.always_use_parentheses_in_expressions",
            PREFIX + "cleanup.use_this_for_non_static_method_access",
            PREFIX + "cleanup.remove_unused_local_variables",
            PREFIX + "cleanup.make_private_fields_final",
            PREFIX + "cleanup.add_missing_deprecated_annotations",
            PREFIX + "cleanup.add_default_serial_version_id",
            PREFIX + "cleanup.sort_members_all",
            PREFIX + "cleanup.use_blocks",
            PREFIX + "cleanup.add_missing_override_annotations",
            PREFIX + "cleanup.make_local_variable_final"
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

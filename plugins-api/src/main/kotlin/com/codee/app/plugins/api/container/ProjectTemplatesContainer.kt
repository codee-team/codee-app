package com.codee.app.plugins.api.container

import com.codee.app.plugins.api.PluginApi
import com.codee.app.resources.locale.strings.LocalizedString
import kotlinx.coroutines.flow.SharedFlow

/**
 * Project Templates Container.
 * Contains projects categories (that in their side, consist of templates).
 */
public interface ProjectTemplatesContainer {
    public val categories: SharedFlow<ProjectsCategory>
}

public interface ProjectsCategory : PluginApi {
    /**
     * Project templates inside category.
     * Plugins that registers category should provide api (if needed) to extend it (by making it `mutable` or by
     * additional method).
     */
    public val templates: List<ProjectsCategory>
}

/**
 * Project template info.
 * @param name - localized name of template.
 * @param description - localized description of template.
 * @param fields - fields that should be specified by user.
 */
public class ProjectTemplate(
    public val name: LocalizedString,
    public val description: LocalizedString,
    public val fields: List<Field>
)

public sealed interface Field {
    public sealed interface Input : Field {
        public val hint: LocalizedString
        public class TextInput(override val hint: LocalizedString) : Input
        public class NumberInput(override val hint: LocalizedString) : Input
    }
    public class Switch(public val text: LocalizedString) : Field
}
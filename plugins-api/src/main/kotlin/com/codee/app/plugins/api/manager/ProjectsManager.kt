package com.codee.app.plugins.api.manager

import com.codee.app.plugins.results.ValidateResult
import com.codee.app.resources.locale.strings.LocalizedString
import kotlinx.coroutines.flow.SharedFlow

public interface ProjectsManager {
    /**
     * All registered projects categories.
     * @return [SharedFlow] with [ProjectCategory]
     */
    public val categories: SharedFlow<ProjectCategory>

    /**
     * Registers projects category.
     * @param category - category with project templates.
     */
    public fun registerCategory(category: ProjectCategory)
}

public interface ProjectCategory {
    /**
     * Project templates.
     * @return [List] of [Template]s.
     */
    public val templates: List<Template>

    /**
     * Registers project template.
     * @param template - template info.
     */
    public fun registerTemplate(template: Template)
}

public class Template(
    public val name: LocalizedString,
    public val description: LocalizedString
) {
    private val _fields = mutableListOf<Field>()

    public val fields: List<Field> get() = _fields.toList()

    /**
     * Adds field to template.
     * @param field - field information & validation.
     */
    public fun addField(field: Field) {
        _fields.add(field)
    }
}



/**
 * Adds field to template.
 * @param hint - field hint.
 * @param validation - validation process.
 */
public fun Template.addField(hint: LocalizedString, validation: (String) -> ValidateResult) {
    addField(object : Field(hint) {
        override fun validate(input: String): ValidateResult {
            return validation(input)
        }
    })
}

public abstract class Field (
    public val hint: LocalizedString
) {
    /**
     * Checks [input] for correctness.
     * @param input - text that user put.
     * @return [Boolean]
     */
    public abstract fun validate(input: String): ValidateResult
}
package com.codee.plugins.api.localization

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

public fun <T> localizable(
    default: T, builder: LocalizableBuilder<T>.() -> Unit
): Localizable<T> = LocalizableBuilder<T>().apply(builder).toLocalizable(default)

public fun <T> localizableDelegate(
    default: T,
    builder: LocalizableBuilder<T>.() -> Unit
): ReadOnlyProperty<Any?, Localizable<T>> {
    val localizable = localizable(default, builder)
    return ReadOnlyProperty { _, _ ->
        return@ReadOnlyProperty localizable
    }
}

public open class LocalizableBuilder<T> {
    private val variants: MutableList<Localized<T>> = mutableListOf()

    /**
     * Creates localized variant for property.
     * Example:
     * ```kotlin
     * val project by localized(default = "Project") {
     *      "Проєкт" to Locale.UKRAINIAN
     * }
     * ```
     */
    public infix fun T.to(locale: Locale) {
        variants += Localized(locale.languageCode, this)
    }

    internal fun toLocalizable(default: T) = Localizable(default, variants)
}
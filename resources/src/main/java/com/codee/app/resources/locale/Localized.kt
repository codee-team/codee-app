package com.codee.app.resources.locale

import kotlin.properties.ReadOnlyProperty

public typealias LocalizedString = Localized<String>

/**
 * Class-wrapper for localization [T].
 * @param default - default localized object.
 * @param variants - localized variants.
 */
public class Localized<T>(
    public val default: T,
    public val variants: Map<Locale, T>
)

public fun <T> Localized<T>.mapLocalized(locale: Locale): T =
    variants[locale] ?: default

/**
 * Builder for [Localized].
 * @param default - default localized object.
 */
public fun <T> localized(default: T, builder: LocalizedBuilder<T>.() -> Unit): ReadOnlyProperty<Any?, T> {
    val localized = Localized(default, LocalizedBuilder<T>().apply(builder).variants)
    return ReadOnlyProperty { _, _ ->
        return@ReadOnlyProperty localized.mapLocalized(currentLocale)
    }
}

public class LocalizedBuilder<T> internal constructor() {
    internal val variants: MutableMap<Locale, T> = mutableMapOf()

    public infix fun Locale.to(variant: T) {
        variants[this] = variant
    }

}
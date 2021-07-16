package com.codee.app.resources.locale

import kotlin.properties.ReadOnlyProperty

/**
 * Class-wrapper for localization [T].
 * @param default - default localized object.
 */
public data class Localized<T> internal constructor(
    public val default: T,
    private val _variants: MutableMap<Locale, T> = mutableMapOf()
) {

    public constructor(default: T) : this(default, mutableMapOf())

    public val variants: Map<Locale, T> get() = _variants.toMap()

    public fun appendVariant(locale: Locale, value: T) {
        _variants[locale] = value
    }

    public infix fun T.to(locale: Locale): Unit =
        appendVariant(locale, this)
}

public operator fun <T> Localized<T>.get(locale: Locale): T =
    variants[locale] ?: default

/**
 * Builder for [Localized].
 * @param default - default localized object.
 */
public fun <T> localized(
    default: T,
    builder: Localized<T>.() -> Unit
): ReadOnlyProperty<Any?, Localized<T>> {
    val localized = Localized(default).apply(builder)
    return ReadOnlyProperty { _, _ ->
        return@ReadOnlyProperty localized
    }
}
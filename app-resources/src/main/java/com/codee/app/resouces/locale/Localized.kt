package com.codee.app.resouces.locale

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

/**
 * Builder for [Localized].
 * @param default - default localized object.
 */
public fun <T> localized(default: T, builder: LocalizedBuilder<T>.() -> Unit): Localized<T> {
    return Localized(default, LocalizedBuilder<T>().apply(builder).variants)
}

public class LocalizedBuilder<T> internal constructor() {
    internal val variants: MutableMap<Locale, T> = mutableMapOf()

    public infix fun Locale.to(variant: T) {
        variants[this] = variant
    }

}
package com.codee.plugins.api.localization

/**
 * Uses for objects that localizable to provide your own translation.
 * @param variants - localized for specific language objects.
 */
public open class Localizable<V>(public val default: V, public val variants: Collection<Localized<V>>)
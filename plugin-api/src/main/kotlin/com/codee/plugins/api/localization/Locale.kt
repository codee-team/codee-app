package com.codee.plugins.api.localization

public data class Locale(public val languageCode: String) {
    public companion object
}

public fun localeOf(languageCode: String): Locale = Locale(languageCode)

public val Locale.Companion.RUSSIAN: Locale get() = Locale("ru")
public val Locale.Companion.ENGLISH: Locale get() = Locale("en")
public val Locale.Companion.UKRAINIAN: Locale get() = Locale("uk")
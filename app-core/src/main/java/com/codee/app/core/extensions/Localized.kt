package com.codee.app.core.extensions

import androidx.core.os.ConfigurationCompat
import com.codee.app.core.ContextDI.context
import com.codee.app.resources.locale.Localized
import com.codee.app.resources.locale.get

fun <T> Localized<T>.localize(): T {
    val locale = ConfigurationCompat
        .getLocales(context.resources.configuration)[0]
        .toCodeeLocale()

    val variants = variants.toList()

    val withLanguageCode = variants
        .filter { (k) -> k.languageCode == locale.languageCode }

    val withCountryCode = withLanguageCode
        .firstOrNull { (k) -> k.countryCode == locale.countryCode }

    return (withCountryCode ?: withLanguageCode.firstOrNull())?.second ?: default
}
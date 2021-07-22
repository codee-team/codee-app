package com.codee.app.core.extensions

import androidx.core.os.ConfigurationCompat
import com.codee.app.core.ContextDI.context
import com.codee.app.resources.locale.Locale
import com.codee.app.resources.locale.Localized


/**
 * First it checks for full equality (languageCode and countryCode), then if there is no such a
 * string, it searches for string with the same languageCode but without countryCode specified.
 * Then the it tries to get just any string with the languageCode
 *
 * It repeats with all available locales and finally uses default variant as fallback
 */
fun <T> Localized<T>.localize(): T {
    // getLocales returns custom class, not list
    val locales = mutableListOf<Locale>().apply {
        val list = ConfigurationCompat.getLocales(context.resources.configuration)
        for (i in 1..list.size())
            add(list[i].toCodeeLocale())
    }

    for (locale in locales) {
        val languageCodeMatches = variants
            .filter { (k) -> k.languageCode == locale.languageCode }
        val countryCodeMatches = languageCodeMatches
            .filter { (k) -> k.countryCode == locale.countryCode }

        val result = countryCodeMatches.values.firstOrNull()
            ?: languageCodeMatches.filter { (k) -> k.countryCode == null }.values.firstOrNull()
            ?: languageCodeMatches.values.firstOrNull()

        if (result != null)
            return result
    }

    return default
}

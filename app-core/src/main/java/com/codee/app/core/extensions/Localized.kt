package com.codee.app.core.extensions

import androidx.core.os.ConfigurationCompat
import com.codee.app.core.ContextDI.context
import com.codee.app.resources.locale.Localized
import com.codee.app.resources.locale.get

fun <T> Localized<T>.localize(): T {
    val locale = ConfigurationCompat.getLocales(context.resources.configuration)[0]
        .toCodeeLocale()
    val vars = variants.toList()
    return if(vars.any { it.first.languageCode == locale.languageCode }) {
        if(vars.any { it.first.countryCode == locale.countryCode })
            vars.first { it.first == locale }.second
        vars.first { it.first.languageCode == locale.languageCode }.second
    } else default
}
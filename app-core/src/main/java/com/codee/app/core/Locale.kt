package com.codee.app.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.os.ConfigurationCompat
import com.codee.app.resources.locale.Locale
import com.codee.app.resources.locale.strings.AppStrings

/**
 * Default localized codee strings.
 */
object CodeeStrings : AppStrings()

/**
 * Codee localized strings.
 */
val appStrings @Composable get() = remember {
    mutableStateOf<AppStrings>(CodeeStrings)
}

/**
 * Gets user locale and maps it to [Locale].
 */
val userLocale: Locale
    get() {
    val locale = ConfigurationCompat.getLocales(appContext.resources.configuration)[0]
    return Locale(
        locale.country.takeUnless { it.isNullOrBlank() },
        locale.language ?: "en"
    )
}


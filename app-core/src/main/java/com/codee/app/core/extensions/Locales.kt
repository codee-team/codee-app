package com.codee.app.core.extensions

import com.codee.app.resources.locale.Locale
import java.util.Locale as JavaLocale

internal fun JavaLocale.toCodeeLocale(): Locale = Locale(country, language)
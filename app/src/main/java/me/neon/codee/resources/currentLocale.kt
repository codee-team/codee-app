package me.neon.codee.resources

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import me.neon.codee.core.locale.AbstractLocale
import me.neon.codee.core.locale.EnglishLocale

/**
 * Current app locale.
 */
val currentLocale: MutableState<AbstractLocale> = mutableStateOf(EnglishLocale)
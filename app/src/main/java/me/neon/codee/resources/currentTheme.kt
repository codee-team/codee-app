package me.neon.codee.resources

import androidx.compose.material.Colors
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import me.neon.codee.core.theme.AbstractTheme
import me.neon.codee.core.theme.LightTheme

/**
 * Current application theme.
 */
val currentTheme: MutableState<Colors> = mutableStateOf(LightTheme().toColors())

internal fun AbstractTheme.toColors() = Colors(
    primary = primary,
    primaryVariant = primaryVariant,
    secondary = secondary,
    secondaryVariant = secondaryVariant,
    onPrimary = onPrimary,
    onSecondary = onSecondary
)
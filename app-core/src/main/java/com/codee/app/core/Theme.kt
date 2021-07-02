package com.codee.app.core

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.codee.app.resources.Color
import com.codee.app.resources.Hex
import com.codee.app.resources.RGB
import com.codee.app.resources.theme.DarkThemeColors
import com.codee.app.resources.theme.LightThemeColors
import com.codee.app.resources.theme.ThemeColors
import android.graphics.Color as AndroidColor
import androidx.compose.ui.graphics.Color as ComposeColor

/**
 * Light theme colors.
 */
val lightThemeColors = mutableStateOf(LightThemeColors().toComposeColors())

/**
 * Dark theme colors.
 */
val darkThemeColors = mutableStateOf(DarkThemeColors().toComposeColors())

private fun ThemeColors.toComposeColors() = Colors(
    primary.toComposeColor(),
    primaryVariant.toComposeColor(),
    secondary.toComposeColor(),
    secondaryVariant.toComposeColor(),
    background.toComposeColor(),
    surface.toComposeColor(),
    error.toComposeColor(),
    onPrimary.toComposeColor(),
    onSecondary.toComposeColor(),
    onBackground.toComposeColor(),
    onSurface.toComposeColor(),
    onError.toComposeColor(),
    this is LightThemeColors
)

private fun Color.toComposeColor() = when (this) {
    is Hex -> ComposeColor(AndroidColor.parseColor(hex))
    is RGB -> ComposeColor(AndroidColor.rgb(red, green, blue))
}

/**
 * Compose representation of codee theme.
 */
@Composable
fun CodeeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) = MaterialTheme(
    colors = if (darkTheme) remember { darkThemeColors }.value
    else remember { lightThemeColors.value },
    content = content
)
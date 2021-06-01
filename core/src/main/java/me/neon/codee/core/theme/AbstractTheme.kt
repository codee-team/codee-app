package me.neon.codee.core.theme

import androidx.compose.ui.graphics.Color

interface AbstractTheme {

    /**
     * Display name of theme.
     */
    val themeName: String

    val primary: Color
    val primaryVariant: Color
    val secondary: Color
    val secondaryVariant: Color
    val onPrimary: Color
    val onSecondary: Color
}
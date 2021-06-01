package me.neon.codee.core.theme

import androidx.compose.ui.graphics.Color

/**
 * Default light implementation of [AbstractTheme].
 */
open class LightTheme(override val themeName: String = "Light") : AbstractTheme {
    override val primary: Color = Color.White
    override val primaryVariant: Color = Color.LightGray
    override val secondary: Color = Color.Gray
    override val secondaryVariant: Color = Color.DarkGray
    override val onPrimary: Color = Color.Black
    override val onSecondary: Color = Color.White
}
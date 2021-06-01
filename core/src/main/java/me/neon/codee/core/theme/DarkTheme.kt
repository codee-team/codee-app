package me.neon.codee.core.theme

import androidx.compose.ui.graphics.Color

/**
 * Default dark implementation of [AbstractTheme].
 */
open class DarkTheme(override val themeName: String = "Dark") : AbstractTheme {
    override val primary: Color = Color(32, 32, 34, 255)
    override val primaryVariant: Color = Color(32, 32, 34, 255)
    override val secondary: Color = Color.DarkGray
    override val secondaryVariant: Color = Color.Gray
    override val onPrimary: Color = Color.White
    override val onSecondary: Color = Color.White
}
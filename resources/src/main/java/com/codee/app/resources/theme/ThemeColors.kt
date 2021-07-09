package com.codee.app.resources.theme

import com.codee.app.resources.Color

/**
 * Codee theme colors.
 * @see androidx.compose.material.Colors
 */
public sealed interface ThemeColors {
    public val primary: Color
    public val primaryVariant: Color
    public val onPrimary: Color
    public val secondary: Color
    public val secondaryVariant: Color
    public val onSecondary: Color
    public val surface: Color
    public val onSurface: Color
    public val background: Color
    public val onBackground: Color
    public val error: Color
    public val onError: Color
}
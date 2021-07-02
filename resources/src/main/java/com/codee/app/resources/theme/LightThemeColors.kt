package com.codee.app.resources.theme

import com.codee.app.resources.Color
import com.codee.app.resources.Hex


public open class LightThemeColors : ThemeColors {
    override val primary: Color = Color.WHITE
    override val primaryVariant: Color = Hex("#cccccc")
    override val onPrimary: Color = Color.BLACK
    override val secondary: Color = Color.WHITE
    override val secondaryVariant: Color = Hex("#cccccc")
    override val onSecondary: Color = Color.BLACK
    override val surface: Color = Color.WHITE
    override val onSurface: Color = Color.BLACK
    override val background: Color = Color.WHITE
    override val onBackground: Color = Color.BLACK
    override val error: Color = Color.RED
    override val onError: Color = Color.WHITE
}
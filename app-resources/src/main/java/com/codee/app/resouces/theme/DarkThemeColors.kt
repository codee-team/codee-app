package com.codee.app.resouces.theme

import com.codee.app.resouces.Color
import com.codee.app.resouces.Hex

public open class DarkThemeColors : ThemeColors {
    override val primary: Color get() = Hex("#272727")
    override val primaryVariant: Color get() = Hex("#cccccc")
    override val onPrimary: Color get() = Color.WHITE
    override val secondary: Color get() = Color.RED
    override val secondaryVariant: Color get() = Hex("#cccccc")
    override val onSecondary: Color get() = background
    override val surface: Color get() = Hex("#121212")
    override val onSurface: Color get() = Color.WHITE
    override val background: Color get() = Hex("#121212")
    override val onBackground: Color get() = Color.WHITE
    override val error: Color get() = Color.RED
    override val onError: Color get() = background
}
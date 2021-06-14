package com.codee.core.themes

import com.codee.plugins.api.themes.DarkThemeColors
import com.codee.plugins.api.themes.Theme
import com.codee.plugins.api.themes.ThemeColors

data class DarkTheme(
    override val name: String = "Dark",
    override val colors: ThemeColors = DarkThemeColors()
) : Theme(name, colors)
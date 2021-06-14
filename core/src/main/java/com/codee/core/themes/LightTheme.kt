package com.codee.core.themes

import com.codee.plugins.api.themes.LightThemeColors
import com.codee.plugins.api.themes.Theme
import com.codee.plugins.api.themes.ThemeColors

data class LightTheme(
    override val name: String = "Light",
    override val colors: ThemeColors = LightThemeColors()
) : Theme(name, colors)
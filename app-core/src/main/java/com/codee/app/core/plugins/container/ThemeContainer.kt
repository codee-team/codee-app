package com.codee.app.core.plugins.container

import com.codee.app.resources.theme.DarkThemeColors
import com.codee.app.resources.theme.LightThemeColors
import com.codee.app.plugins.api.container.ThemeContainer as IThemeContainer

object ThemeContainer : IThemeContainer {
    override var currentLightThemeColors: LightThemeColors = LightThemeColors()
    override var currentDarkThemeColors: DarkThemeColors = DarkThemeColors()
}
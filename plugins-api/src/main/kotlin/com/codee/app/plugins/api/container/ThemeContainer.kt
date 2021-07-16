package com.codee.app.plugins.api.container

import com.codee.app.resources.theme.DarkThemeColors
import com.codee.app.resources.theme.LightThemeColors

public interface ThemeContainer {
    /**
     * Current light theme colors.
     */
    public var currentLightThemeColors: LightThemeColors

    /**
     * Current dark theme colors.
     */
    public var currentDarkThemeColors: DarkThemeColors
}
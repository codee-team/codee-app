package com.codee.app.plugins.api.manager

import com.codee.app.resources.theme.DarkThemeColors
import com.codee.app.resources.theme.LightThemeColors

public interface ThemeManager {
    /**
     * Current light theme colors.
     */
    public var currentLightThemeColors: LightThemeColors

    /**
     * Current dark theme colors.
     */
    public var currentDarkThemeColors: DarkThemeColors
}
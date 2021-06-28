package com.codee.application.plugins

import com.codee.application.theme.DarkThemeColors
import com.codee.application.theme.LightThemeColors

public interface ThemeController {
    /**
     * Current light theme colors.
     */
    public var currentLightTheme: LightThemeColors

    /**
     * Current dark theme colors.
     */
    public var currentDarkTheme: DarkThemeColors
}
package com.codee.app.plugins

import com.codee.app.resouces.theme.DarkThemeColors
import com.codee.app.resouces.theme.LightThemeColors

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
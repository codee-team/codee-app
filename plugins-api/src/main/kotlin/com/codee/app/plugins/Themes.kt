package com.codee.app.plugins

import com.codee.app.resources.theme.*

public interface Themes {
    /**
     * Current light theme colors.
     */
    public var currentLightTheme: LightThemeColors

    /**
     * Current dark theme colors.
     */
    public var currentDarkTheme: DarkThemeColors
}
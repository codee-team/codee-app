package com.codee.plugins.api

import com.codee.plugins.api.themes.DarkThemeColors
import com.codee.plugins.api.themes.LightThemeColors
import com.codee.plugins.api.themes.ThemeColors

public interface Themes {
    /**
     * Applies theme [colors] to app in forced way.
     * @param colors - theme colors.
     */
    public fun setTheme(colors: ThemeColors)

    /**
     * Sets dark theme for application (will be applied if user
     * has chosen dark theme or it picked up by system).
     * @param colors - dark theme colors.
     */
    public fun setDarkTheme(colors: DarkThemeColors)

    /**
     * Sets light theme for application (will be applied if user has
     * chosen light theme or it picked up by system).
     * @param colors - light theme colors.
     */
    public fun setLightTheme(colors: LightThemeColors)
}
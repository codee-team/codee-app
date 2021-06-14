package com.codee.core.handlers.theme

import com.codee.plugins.api.themes.ThemeColors

interface NewThemeHandler {
    /**
     * When theme changed.
     */
    fun onThemeChanged(colors: ThemeColors)
}
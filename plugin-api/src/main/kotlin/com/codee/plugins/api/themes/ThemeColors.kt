package com.codee.plugins.api.themes

public sealed interface ThemeColors {
    /**
     * Primary color of the app in HEX format.
     */
    public val primary: String
    /**
     * Secondary color of the app in HEX format.
     */
    public val secondary: String
    /**
     * Color onto primary color in HEX format.
     */
    public val onPrimary: String
    /**
     * Color onto secondary color in HEX format.
     */
    public val onSecondary: String
}
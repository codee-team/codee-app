package com.codee.plugins.api

import com.codee.plugins.api.annotations.PermissionRequired
import com.codee.plugins.api.permissions.RemoveOtherThemesPermission
import com.codee.plugins.api.themes.Theme
import com.codee.plugins.api.themes.ThemeColors

public interface Themes {
    /**
     * @return [List] of [ThemeColors] with all registered in app themes.
     */
    public val all: List<Theme>

    /**
     * Adds theme.
     * @param name - name of theme.
     * @param themeColors - theme colors.
     * @return [Boolean] is added or not.
     */
    public fun addTheme(name: String, themeColors: ThemeColors): Boolean

    /**
     * Removes theme by [name].
     * @param name - name of theme.
     * @return [Boolean] is removed or not.
     */
    @PermissionRequired(RemoveOtherThemesPermission::class)
    public fun removeTheme(name: String): Boolean
}
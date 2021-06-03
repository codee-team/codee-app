package com.codee.core.plugins

import android.content.Context
import com.codee.core.plugins.language.Strings
import com.codee.core.plugins.permissions.Permission
import com.codee.core.plugins.theme.Theme

interface PluginsCommunicator {
    /**
     * Application context.
     */
    val context: Context

    /**
     * On language changed in forced way.
     */
    val onLanguageChange: OnLanguageChangeListener

    /**
     * On theme changed in forced way.
     */
    val onThemeChange: OnThemeChangeListener

    /**
     * When plugin called permission
     */
    val onPluginPermissionRequest: PluginPermissionRequestListener
}

interface OnLanguageChangeListener {
    fun onChange(strings: Strings)
}

interface OnThemeChangeListener {
    fun onChange(theme: Theme)
}

interface PluginPermissionRequestListener {
    /**
     * When plugin called permission.
     * @param plugin - plugin that called.
     * @param permission - permission that called.
     * @return [Boolean] is permitted or not.
     */
    suspend fun onRequest(plugin: Plugin, permission: Permission): Boolean
}
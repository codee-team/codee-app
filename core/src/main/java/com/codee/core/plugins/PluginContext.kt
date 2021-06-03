package com.codee.core.plugins

import com.codee.core.application
import com.codee.core.plugins.api.plugins
import com.codee.core.plugins.permissions.Permission
import com.codee.core.plugins.utils.PluginFile
import java.io.File

/**
 * Stores plugin tokens (to access Codee API).
 */
data class PluginContext internal constructor(
    internal val token: String,
    internal val pluginId: String
) {
    private val granterPermissionsSource: MutableList<Permission> = mutableListOf()

    /**
     * Permissions that have been granted by the user to the plugin.
     * @return [List] of [Permission] with all granted permissions.
     */
    val grantedPermissions: List<Permission> get() = granterPermissionsSource.toList()

    /**
     * Calls the user to permit the permission.
     * @param permission - permission to permit.
     * @return [Boolean] is user permitted or not.
     */
    suspend fun requestPermission(permission: Permission): Boolean {
        return application.onPluginPermissionRequest.onRequest(plugin, permission).also {
            if (it) granterPermissionsSource += permission
        }
    }

}

/**
 * Finds plugin by [PluginContext.pluginId].
 * @return [Plugin].
 */
val PluginContext.plugin: Plugin get() = plugins.first { it.uuid == pluginId }

/**
 * Says is plugin has a [permission].
 * @param permission - permissions that should be.
 * @return [Boolean] is permission contains or not.
 */
fun PluginContext.hasPermission(permission: Permission): Boolean =
    grantedPermissions.contains(permission)

/**
 * @return [PluginFile] with dedicated folder for plugin.
 */
val PluginContext.pluginFolder: PluginFile
    get() = PluginFile(
        File(application.context.filesDir, "/plugins/$pluginId"), this
    )
package me.neon.codee.core.plugins

import me.neon.codee.core.application
import me.neon.codee.core.plugins.api.plugins
import me.neon.codee.core.plugins.permissions.Permission
import me.neon.codee.core.plugins.utils.PluginFile
import java.io.File

/**
 * Stores plugin tokens (to access Codee API).
 */
data class PluginContext internal constructor(
    internal val token: String,
    internal val pluginId: String
) {
    private val issuedPermitsSource: MutableList<Permission> = mutableListOf()

    /**
     * Permissions that have been granted by the user to the plugin.
     * @return [List] of [Permission] with all granted permissions.
     */
    val issuedPermits: List<Permission> get() = issuedPermitsSource.toList()

    /**
     * Calls the user to permit the permission.
     * @param permission - permission to permit.
     * @return [Boolean] is user permitted or not.
     */
    suspend fun requestPermission(permission: Permission): Boolean {
        val plugin = plugins.first { it.uuid == pluginId }
        return application.onPluginPermissionRequest.onRequest(plugin, permission).also {
            if(it) issuedPermitsSource += permission
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
    issuedPermits.contains(permission)

/**
 * @return [PluginFile] with dedicated folder for plugin.
 */
val PluginContext.pluginFolder: PluginFile
    get() = PluginFile(
        File(application.context.filesDir, "/plugins/$pluginId"), this
    )
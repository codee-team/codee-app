package me.neon.codee.core.plugins.api

import me.neon.codee.core.annotations.OnlyPermittedCalls
import me.neon.codee.core.plugins.Plugin
import me.neon.codee.core.plugins.PluginContext
import me.neon.codee.core.plugins.hasPermission
import me.neon.codee.core.plugins.permissions.RemovePluginsPermission
import randomString

private val pluginsSource: MutableList<Plugin> = mutableListOf()
internal val PLUGIN_CONTEXTS: MutableList<PluginContext> = mutableListOf()

/**
 * List of all registered plugins on last session.
 * @return [List] of [Plugin]s with all loaded plugins.
 */
val plugins: List<Plugin> = pluginsSource.toList()

/**
 * Registers new plugin.
 * @param [plugin] - plugin info.
 * @return [Result] with [PluginContext] if success or with
 * some kind of [Exception] if there was error.
 */
fun registerPlugin(plugin: Plugin): Result<PluginContext> {
    if (plugins.any { it.uuid == plugin.uuid })
        return Result.failure(PluginWithSuchIdExistsException(plugin.uuid))
    pluginsSource.add(plugin)
    val token = PluginContext(randomString(32), plugin.uuid)
    PLUGIN_CONTEXTS.add(token)
    return Result.success(token)
}

/**
 * Removes plugin by [id].
 * Attention: to call this, you have to provide
 * [me.neon.codee.core.plugins.permissions.RemovePluginsPermission] permission.
 * @param id - plugin id from [plugins].
 * @return [Boolean] is plugin removed or not.
 */
@OnlyPermittedCalls
fun PluginContext.removePlugin(id: String): Boolean {
    if (!hasPermission(RemovePluginsPermission) && pluginId != id)
        return false
    return pluginsSource.removeAll { it.uuid == id }
}

/**
 * Throws if plugin with such id already exists.
 * @param id - plugin uuid.
 */
class PluginWithSuchIdExistsException internal constructor(id: String) :
    Exception("Plugin with id $id already loaded.")
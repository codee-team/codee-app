package me.neon.codee.core.plugins.api

import me.neon.codee.core.annotations.OnlyPermittedCalls
import me.neon.codee.core.plugins.Plugin
import me.neon.codee.core.plugins.PluginContext
import me.neon.codee.core.plugins.hasPermission
import me.neon.codee.core.plugins.permissions.RemoveThemesPermission
import me.neon.codee.core.plugins.theme.DarkTheme
import me.neon.codee.core.plugins.theme.LightTheme
import me.neon.codee.core.plugins.theme.Theme

private val themesSource: MutableList<ThemeContainer> = mutableListOf(
    ThemeContainer("Light", LightTheme(), null),
    ThemeContainer("Dark", DarkTheme(), null)
)

/**
 * All loaded themes.
 * @return [List] of [Theme]s with all registered themes.
 */
val themes: List<ThemeContainer> get() = themesSource.toList()

/**
 * Registers new theme.
 * @param name - name of theme.
 * @param theme - theme colors.
 * @return [Result] with [Unit].
 */
fun PluginContext.registerTheme(name: String, theme: Theme) : Result<Unit> {
    val plugin = plugins.firstOrNull { it.uuid == pluginId }
        ?: return Result.failure(NoSuchElementException("No plugin with id $pluginId registered."))
    if(themes.any { it.name == name })
        return Result.failure(ThemeAlreadyExistsException(name))
    return if(themesSource.add(ThemeContainer(name, theme, plugin)))
        Result.success(Unit)
    else Result.failure(IllegalStateException("Plugin with id $pluginId wasn't added. Seems like internal error."))
}

/**
 * Removes theme from registered.
 * Attention: [me.neon.codee.core.plugins.permissions.RemoveThemesPermission] required to remove themes.
 * @param name - name of theme.
 * @return [Boolean] is removed or not.
 */
@OnlyPermittedCalls
fun PluginContext.removeTheme(name: String): Boolean {
    if(!hasPermission(RemoveThemesPermission))
        return false
    return themesSource.removeAll { it.name == name }
}

data class ThemeContainer internal constructor(
    val name: String,
    val theme: Theme,
    val owner: Plugin?
)

class ThemeAlreadyExistsException internal constructor(
    val name: String
) : Exception("Theme for name $name already exists.")
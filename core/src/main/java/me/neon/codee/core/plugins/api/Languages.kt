package me.neon.codee.core.plugins.api

import me.neon.codee.core.plugins.Plugin
import me.neon.codee.core.plugins.PluginContext
import me.neon.codee.core.plugins.language.DefaultStrings
import me.neon.codee.core.plugins.language.Strings

private val stringsSource: MutableList<LocalizedStrings> = mutableListOf(
    LocalizedStrings(
        DefaultStrings, "en", null
    )
)

/**
 * @return [List] of [Strings] with all localized strings.
 */
val strings: List<LocalizedStrings> get() = stringsSource.toList()

/**
 * Registers new localized strings.
 * @param languageCode - language code (e.x: uk, ru, en).
 * @param strings - localized strings.
 * @param context - plugin's token.
 * @return [Boolean] is added or not.
 */
fun PluginContext.registerStrings(languageCode: String, strings: Strings): Boolean {
    return stringsSource.add(
        LocalizedStrings(
            strings, languageCode, plugins.first { it.uuid == pluginId }
        )
    )
}

data class LocalizedStrings internal constructor(
    val strings: Strings,
    val languageCode: String,
    val owner: Plugin?
)
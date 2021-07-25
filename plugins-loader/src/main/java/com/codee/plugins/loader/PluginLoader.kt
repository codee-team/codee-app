package com.codee.plugins.loader

import com.codee.app.core.plugins.ManifestScope
import com.codee.app.core.plugins.PluginScope
import kotlin.script.experimental.api.ResultWithDiagnostics

interface PluginLoader {
    /**
     * Loads plugin.
     * @param manifestScope - scope with manifest settings.
     * @param pluginScope - scope with plugin api.
     */
    suspend fun load(
        manifestScope: ManifestScope,
        pluginScope: PluginScope
    ): ResultWithDiagnostics<Unit>
}
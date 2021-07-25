package com.codee.plugins.loader

import com.codee.app.core.plugins.ManifestScope
import com.codee.app.core.plugins.PluginScope
import kotlin.script.experimental.api.ResultWithDiagnostics
import kotlin.script.experimental.api.ScriptDiagnostic
import kotlin.script.experimental.jvm.util.isError

class SimplePluginLoader(
    private val manifestBlock: ManifestScope.() -> Unit,
    private val pluginBlock: PluginScope.() -> Unit
) : PluginLoader {
    override suspend fun load(
        manifestScope: ManifestScope,
        pluginScope: PluginScope
    ): ResultWithDiagnostics<Unit> {
        try {
            val manifestLoader = SimpleManifestScopeLoader(manifestBlock, manifestScope)
            val manifestResult = manifestLoader.load()
            if(manifestResult.isError())
                return ResultWithDiagnostics.Failure(manifestResult.reports)
            val pluginResult = SimplePluginScopeLoader(pluginScope, pluginBlock).load()
            return ResultWithDiagnostics.Success(Unit,manifestResult.reports + pluginResult.reports)
        } catch (e: Exception) {
            return ResultWithDiagnostics.Failure(listOf(
                ScriptDiagnostic(-1, e.toString(), exception = e)
            ))
        }
    }
}
package com.codee.plugins.loader

import com.codee.app.core.plugins.PluginMetadata
import com.codee.app.core.plugins.PluginScope
import kotlin.script.experimental.api.ResultWithDiagnostics
import kotlin.script.experimental.api.ScriptDiagnostic

class SimplePluginScopeLoader(
    override val scope: PluginScope,
    private val block: PluginScope.() -> Unit
) : PluginScopeLoader<Unit> {
    override suspend fun load(): ResultWithDiagnostics<Unit> = try {
        block(scope)
        ResultWithDiagnostics.Success(Unit)
    } catch (e: Exception) {
        ResultWithDiagnostics.Failure(listOf(
            ScriptDiagnostic(code = -1, e.toString(), exception = e)
        ))
    }
}
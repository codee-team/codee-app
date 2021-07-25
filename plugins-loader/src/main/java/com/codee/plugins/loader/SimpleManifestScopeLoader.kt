package com.codee.plugins.loader

import com.codee.app.core.plugins.ManifestScope
import kotlin.script.experimental.api.ResultWithDiagnostics
import kotlin.script.experimental.api.ScriptDiagnostic

class SimpleManifestScopeLoader(private val block: ManifestScope.() -> Unit, override val scope: ManifestScope = ManifestScope()) : ManifestScopeLoader<Unit> {

    override suspend fun load(): ResultWithDiagnostics<Unit> = try {
        block(scope)
        ResultWithDiagnostics.Success(Unit)
    } catch (e: Exception) {
        ResultWithDiagnostics.Failure(listOf(
            ScriptDiagnostic(-1, e.toString(), exception = e)
        ))
    }

}
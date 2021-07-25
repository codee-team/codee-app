package com.codee.plugins.loader

import com.codee.app.core.plugins.Dependency
import com.codee.app.core.plugins.ManifestScope
import com.codee.plugins.scripts.ManifestScriptConfiguration
import com.codee.plugins.scripts.ManifestScriptDefinition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import kotlin.script.experimental.api.EvaluationResult
import kotlin.script.experimental.api.ResultWithDiagnostics
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost

class ScriptManifestScopeLoader(override val scope: ManifestScope, private val file: File) :
    ManifestScopeLoader<EvaluationResult> {
    private val jvmHost = BasicJvmScriptingHost()
    private val compilationConfiguration = ManifestScriptDefinition()
    private val evaluationConfiguration = ManifestScriptConfiguration(scope)

    val dependencies: Collection<Dependency> get() = scope.declaredDependencies

    override suspend fun load(): ResultWithDiagnostics<EvaluationResult> =
        withContext(Dispatchers.Default) {
            return@withContext jvmHost.eval(
                file.toScriptSource(),
                compilationConfiguration,
                evaluationConfiguration
            )
        }
}
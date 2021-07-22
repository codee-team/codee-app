package com.codee.plugins.loader

import com.codee.app.plugins.api.MetadataScope
import com.codee.plugins.scripts.ManifestScriptConfiguration
import com.codee.plugins.scripts.ManifestScriptDefinition
import java.io.File
import kotlin.script.experimental.api.EvaluationResult
import kotlin.script.experimental.api.ResultWithDiagnostics
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost

class MetadataScriptLoader(scope: MetadataScope) : FileScriptLoader {
    private val jvmHost = BasicJvmScriptingHost()
    private val compilationConfiguration = ManifestScriptDefinition()
    private val evaluationConfiguration = ManifestScriptConfiguration(scope)

    override suspend fun eval(scriptFile: File): ResultWithDiagnostics<EvaluationResult> {
        return jvmHost.eval(
            scriptFile.toScriptSource(),
            compilationConfiguration,
            evaluationConfiguration
        )
    }
}
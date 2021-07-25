package com.codee.plugins.loader

import com.codee.app.plugins.api.PluginScope
import com.codee.plugins.scripts.PluginScriptConfiguration
import com.codee.plugins.scripts.PluginScriptDefinition
import java.io.File
import kotlin.script.experimental.api.EvaluationResult
import kotlin.script.experimental.api.ResultWithDiagnostics
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost

class ScriptPluginScopeLoader(
    override val scope: PluginScope,
    private val file: File,
    classpath: List<File>
) : PluginScopeLoader<EvaluationResult> {
    private val jvmHost = BasicJvmScriptingHost()
    private val compilationConfiguration = PluginScriptDefinition(classpath)
    private val evaluationConfiguration = PluginScriptConfiguration(scope)

    override suspend fun load(): ResultWithDiagnostics<EvaluationResult> {
        return jvmHost.eval(
            file.toScriptSource(),
            compilationConfiguration,
            evaluationConfiguration
        )
    }
}
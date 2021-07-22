package com.codee.plugins.loader

import com.codee.app.plugins.api.PluginScope
import com.codee.plugins.scripts.PluginScriptConfiguration
import com.codee.plugins.scripts.PluginScriptDefinition
import java.io.File
import kotlin.script.experimental.api.EvaluationResult
import kotlin.script.experimental.api.ResultWithDiagnostics
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost

class PluginScriptLoader(scope: PluginScope, classpath: Collection<File>) : FileScriptLoader {

    private val jvmHost = BasicJvmScriptingHost()
    private val compilationConfiguration = PluginScriptDefinition(classpath)
    private val evaluationConfiguration = PluginScriptConfiguration(scope)

    override suspend fun eval(scriptFile: File): ResultWithDiagnostics<EvaluationResult> {
        return jvmHost.eval(scriptFile.toScriptSource(), compilationConfiguration, evaluationConfiguration)
    }
}
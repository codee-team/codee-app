package com.codee.plugins.scripts

import com.codee.app.plugins.api.PluginScope
import com.codee.plugins.internal.classpathFrom
import java.io.File
import kotlin.script.experimental.annotations.KotlinScript
import kotlin.script.experimental.api.*
import kotlin.script.experimental.jvm.dependenciesFromClassContext
import kotlin.script.experimental.jvm.jvm
import kotlin.script.experimental.jvm.updateClasspath

@KotlinScript(
    fileExtension = "plugin.kts",
    compilationConfiguration = PluginScriptDefinition::class,
    evaluationConfiguration = PluginScriptConfiguration::class
)
abstract class PluginScript

class PluginScriptDefinition(classpath: Collection<File>) : ScriptCompilationConfiguration({
    defaultImports("com.codee.plugins.api.*")
    implicitReceivers(PluginScope::class)
    jvm {
        dependenciesFromClassContext(PluginScript::class, wholeClasspath = true)
    }
    updateClasspath(classpathFrom(PluginScope::class) + classpath)
})

class PluginScriptConfiguration(pluginScope: PluginScope) : ScriptEvaluationConfiguration({
    scriptsInstancesSharing(true)
    implicitReceivers(pluginScope)
})
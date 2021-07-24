package com.codee.plugins.scripts

import com.codee.app.plugins.api.DependenciesScope
import com.codee.app.plugins.api.ManifestScope
import com.codee.plugins.internal.classpathFrom
import kotlin.script.experimental.annotations.KotlinScript
import kotlin.script.experimental.api.*
import kotlin.script.experimental.jvm.dependenciesFromClassContext
import kotlin.script.experimental.jvm.jvm
import kotlin.script.experimental.jvm.updateClasspath

@KotlinScript(
    fileExtension = "manifest.kts",
    compilationConfiguration = ManifestScriptDefinition::class,
    evaluationConfiguration = ManifestScriptConfiguration::class
)
abstract class ManifestScript

class ManifestScriptDefinition : ScriptCompilationConfiguration({
    defaultImports("com.codee.plugins.api.*")
    implicitReceivers(ManifestScope::class)
    jvm {
        dependenciesFromClassContext(ManifestScript::class, wholeClasspath = true)
    }
    updateClasspath(classpathFrom(ManifestScope::class, DependenciesScope::class))
})

class ManifestScriptConfiguration(manifestScope: ManifestScope) : ScriptEvaluationConfiguration({
    scriptsInstancesSharing(true)
    implicitReceivers(manifestScope)
})
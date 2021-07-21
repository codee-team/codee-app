package com.codee.plugins.scripts

import com.codee.app.plugins.api.DependenciesScope
import com.codee.app.plugins.api.MetadataScope
import com.codee.plugins.internal.classpathFrom
import kotlin.script.experimental.annotations.KotlinScript
import kotlin.script.experimental.api.*
import kotlin.script.experimental.jvm.dependenciesFromClassContext
import kotlin.script.experimental.jvm.jvm
import kotlin.script.experimental.jvm.updateClasspath

@KotlinScript(
    fileExtension = "codee.kts",
    compilationConfiguration = ManifestScriptDefinition::class,
    evaluationConfiguration = ManifestScriptConfiguration::class
)
abstract class ManifestScript

class ManifestScriptDefinition : ScriptCompilationConfiguration({
    defaultImports("com.codee.plugins.api.*")
    implicitReceivers(MetadataScope::class)
    jvm {
        dependenciesFromClassContext(ManifestScript::class, wholeClasspath = true)
    }
    updateClasspath(classpathFrom(MetadataScope::class, DependenciesScope::class))
})

class ManifestScriptConfiguration(metadataScope: MetadataScope) : ScriptEvaluationConfiguration({
    scriptsInstancesSharing(true)
    implicitReceivers(metadataScope)
})
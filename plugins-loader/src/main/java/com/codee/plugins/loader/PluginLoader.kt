package com.codee.plugins.loader

import com.codee.app.plugins.api.MetadataScope
import com.codee.app.plugins.api.PluginScope
import java.io.File
import kotlin.script.experimental.api.ResultWithDiagnostics
import kotlin.script.experimental.api.ScriptDiagnostic
import kotlin.script.experimental.jvm.util.isError

class PluginLoader {
    /**
     * Loads plugin files.
     * @param folder - plugin source folder.
     * In [folder] must be `main.manifest.kts` and `main.plugin.kts` files:
     * - `main.manifest.kts` launching for first to declare info about plugin name, version
     * and compatibility.
     * - `main.plugin.kts`: script where we got `PluginScope` as receiver that runs after
     * `main.manifest.kts` and adds some logic to codee.
     *
     * @param manifestScope - manifest scope for plugin.
     * @param pluginScope - plugin scope for plugin.
     *
     * @return [ResultWithDiagnostics] of [Unit].
     */
    suspend fun load(
        folder: File,
        manifestScope: MetadataScope,
        pluginScope: PluginScope
    ): ResultWithDiagnostics<Unit> {
        val manifestFile = File(folder, "main.manifest.kts")
        val pluginFile = File(folder, "main.plugin.kts")

        if (!manifestFile.exists())
            return ResultWithDiagnostics.Failure(
                listOf(
                    ScriptDiagnostic(
                        MANIFEST_FILE_DOES_NOT_EXIST, "Manifest file does not exist."
                    )
                )
            )

        if (!pluginFile.exists())
            return ResultWithDiagnostics.Failure(
                listOf(
                    ScriptDiagnostic(PLUGIN_FILE_DOES_NOT_EXIST, "Plugin file does not exist.")
                )
            )

        val metadataResult = MetadataScriptLoader(manifestScope).eval(manifestFile)
        val pluginResult = if (!metadataResult.isError())
            PluginScriptLoader(pluginScope).eval(pluginFile)
        else ResultWithDiagnostics.Failure(
            listOf(
                ScriptDiagnostic(NOT_LAUNCHED, "Plugin wasn't launched due to error in metadata.")
            )
        )

        val reports = metadataResult.reports + pluginResult.reports

        return if (metadataResult.isError() || pluginResult.isError())
            ResultWithDiagnostics.Failure(reports)
        else ResultWithDiagnostics.Success(Unit, reports)
    }

    companion object Error {
        const val NOT_LAUNCHED = 100
        const val MANIFEST_FILE_DOES_NOT_EXIST = 101
        const val PLUGIN_FILE_DOES_NOT_EXIST = 102
    }

}
package com.codee.plugins.loader

import java.io.File
import kotlin.script.experimental.api.EvaluationResult
import kotlin.script.experimental.api.ResultWithDiagnostics

interface FileScriptLoader {
    /**
     * Evaluates [scriptFile] file.
     * @param scriptFile - file with script.
     */
    suspend fun eval(scriptFile: File): ResultWithDiagnostics<EvaluationResult>
}
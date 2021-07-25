package com.codee.plugins.loader

import kotlin.script.experimental.api.ResultWithDiagnostics

interface Loader<T> {
    suspend fun load(): ResultWithDiagnostics<T>
}
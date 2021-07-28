package com.codee.app.core.plugins.files

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import com.codee.app.plugins.api.files.EmptyStorageElement as IEmptyStorageElement

class EmptyStorageElement(private val origin: File, private val rootDirectory: File) :
    IEmptyStorageElement {
    override suspend fun mkdir(): ChildDirectoryStorageElement = withContext(Dispatchers.IO) {
        origin.mkdir()
        return@withContext ChildDirectoryStorageElement(origin, rootDirectory)
    }

    override suspend fun createNewFile(): FileStorageElement = withContext(Dispatchers.IO) {
        origin.createNewFile()
        return@withContext FileStorageElement(origin, rootDirectory)
    }

    override val name: String
        get() = origin.name

    override val path: String
        get() = origin.path.replace(rootDirectory.path, "")

}
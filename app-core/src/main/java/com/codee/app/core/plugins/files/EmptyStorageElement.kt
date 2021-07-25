package com.codee.app.core.plugins.files

import java.io.File
import com.codee.app.plugins.api.files.EmptyStorageElement as IEmptyStorageElement

class EmptyStorageElement(private val origin: File, private val rootDirectory: File) :
    IEmptyStorageElement {
    override suspend fun mkdir(): ChildDirectoryStorageElement {
        origin.mkdir()
        return ChildDirectoryStorageElement(origin, rootDirectory)
    }

    override suspend fun createNewFile(): FileStorageElement {
        origin.createNewFile()
        return FileStorageElement(origin, rootDirectory)
    }

}
package com.codee.app.core.plugins.files

import com.codee.app.plugins.api.files.StorageElement
import java.io.File
import com.codee.app.plugins.api.files.DirectoryStorageElement.RootDirectoryStorageElement as IRootDirectoryStorageElement

class RootDirectoryStorageElement(private val origin: File) : IRootDirectoryStorageElement {
    override fun get(name: String): StorageElement {
        val file = File(origin, name)
        if (file.absolutePath.startsWith(origin.absolutePath)) {
            return if (!file.exists())
                EmptyStorageElement(file, origin)
            else if (file.isFile)
                FileStorageElement(file, origin)
            else ChildDirectoryStorageElement(origin, file)
        } else throw SecurityException("Unable to get file at ${file.absolutePath}, you don't have such permission.")
    }
}
package com.codee.app.core.plugins.files

import com.codee.app.plugins.api.files.DirectoryStorageElement
import com.codee.app.plugins.api.files.StorageElement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import com.codee.app.plugins.api.files.DirectoryStorageElement.ChildDirectoryStorageElement as IChildDirectoryStorageElement

class ChildDirectoryStorageElement(private val rootDirectory: File, private val origin: File) :
    IChildDirectoryStorageElement {
    override val parent: DirectoryStorageElement
        get() = if (origin.parentFile!!.absolutePath == rootDirectory.absolutePath)
            RootDirectoryStorageElement(origin.parentFile!!)
        else ChildDirectoryStorageElement(rootDirectory, origin)

    override suspend fun delete(): Unit = withContext(Dispatchers.IO) {
        origin.delete()
    }

    override fun get(name: String): StorageElement {
        val file = File(origin, name)
        if (file.absolutePath.startsWith(origin.absolutePath)) {
            return if (!file.exists())
                EmptyStorageElement(file, origin)
            else if (file.isFile)
                FileStorageElement(file, rootDirectory)
            else ChildDirectoryStorageElement(origin, file)
        } else throw SecurityException("Unable to get file at ${file.absolutePath}, you don't have such permission.")
    }

}
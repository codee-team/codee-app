package com.codee.app.core.plugins.files

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import com.codee.app.plugins.api.files.FileStorageElement as IFileStorageElement

class FileStorageElement internal constructor(
    private val origin: File,
    private val rootDirectory: File
) : IFileStorageElement {
    override suspend fun read(): ByteArray = withContext(Dispatchers.IO) {
        return@withContext origin.readBytes()
    }

    override suspend fun write(bytes: ByteArray) = withContext(Dispatchers.IO) {
        origin.writeBytes(bytes)
    }

    override suspend fun delete(): EmptyStorageElement = withContext(Dispatchers.IO) {
        origin.delete()
        return@withContext EmptyStorageElement(origin, rootDirectory)
    }

    override val name: String
        get() = origin.name

    override val path: String
        get() = origin.path.replace(rootDirectory.path, "")
}
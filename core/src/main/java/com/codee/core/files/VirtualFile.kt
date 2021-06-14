package com.codee.core.files

import com.codee.plugins.api.files.VirtualFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

class VirtualFile(
    rootPath: String,
    current: File
) : VirtualFile, FSEntity(rootPath, current) {
    override suspend fun writeBytes(bytes: ByteArray) =
        withContext(Dispatchers.IO) {
            current.writeBytes(bytes)
        }

    override suspend fun readBytes(): ByteArray = withContext(Dispatchers.IO) {
        current.readBytes()
    }

    override suspend fun delete(): Unit = withContext(Dispatchers.IO) {
        current.delete()
    }
}
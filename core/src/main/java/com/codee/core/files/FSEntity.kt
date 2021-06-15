package com.codee.core.files

import com.codee.plugins.api.files.EmptyFSEntity
import com.codee.plugins.api.files.VirtualDirectory
import com.codee.plugins.api.files.VirtualFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

open class FSEntity(
    internal val rootPath: String,
    internal val current: File = File(rootPath)
) : EmptyFSEntity {
    override suspend fun mkdir(): VirtualDirectory = withContext(Dispatchers.IO) {
        return@withContext if(checkAccess(current.absolutePath)) {
            current.mkdir()
            VirtualParentableDirectory(rootPath, current)
        } else VirtualRootDirectory(rootPath, current)
    }

    override suspend fun mkdirs(): VirtualDirectory = withContext(Dispatchers.IO) {
        return@withContext if(checkAccess(current.absolutePath)) {
            current.mkdirs()
            VirtualParentableDirectory(rootPath, current)
        } else VirtualRootDirectory(rootPath, current)
    }

    override suspend fun createNewFile(): VirtualFile = withContext(Dispatchers.IO) {
        return@withContext if(checkAccess(current.absolutePath)) {
            current.createNewFile()
            VirtualFile(rootPath, current)
        } else throw IllegalStateException("Unable to create file at path ${current.absolutePath}")
    }
}

internal fun FSEntity.checkAccess(name: String): Boolean =
    File(current, name).absolutePath != rootPath
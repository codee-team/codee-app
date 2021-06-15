package com.codee.core.files

import com.codee.plugins.api.files.VirtualRootDirectory
import java.io.File

open class VirtualRootDirectory(
    rootPath: String,
    current: File
) : VirtualRootDirectory, FSEntity(rootPath, current) {
    override fun get(name: String): com.codee.plugins.api.files.FSEntity {
        val file = File(current, rootPath)
        return if(file.isDirectory)
            return VirtualParentableDirectory(rootPath, current)
        else VirtualFile(rootPath, current)
    }
}
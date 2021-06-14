package com.codee.core.files

import com.codee.plugins.api.files.VirtualDirectory
import com.codee.plugins.api.files.VirtualParentableDirectory
import java.io.File

class VirtualParentableDirectory(
    rootPath: String,
    current: File
) : VirtualParentableDirectory, VirtualRootDirectory(rootPath, current) {
    override val parent: VirtualDirectory
        get() {
            return if(checkAccess(current.parentFile!!.absolutePath))
                VirtualParentableDirectory(rootPath, current.parentFile!!)
            else VirtualRootDirectory(rootPath, current.parentFile!!)
        }
}


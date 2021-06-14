package com.codee.plugins.api.files

public interface VirtualParentableDirectory : VirtualRootDirectory {

    /**
     * @return parent [VirtualDirectory].
     */
    public val parent: VirtualDirectory
}
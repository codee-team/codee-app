package com.codee.plugins.api.files

/**
 * The root of any file / directory.
 */
public sealed interface FSEntity {
    /**
     * Makes folder in current path.
     * @return [VirtualParentableDirectory].
     */
    public suspend fun mkdir(): VirtualDirectory

    /**
     * Creates folders up to current path.
     */
    public suspend fun mkdirs(): VirtualDirectory

    /**
     * Creates file at current path.
     */
    public suspend fun createNewFile(): VirtualFile
}
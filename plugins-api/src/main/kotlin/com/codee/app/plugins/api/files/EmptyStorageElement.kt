package com.codee.app.plugins.api.files

public interface EmptyStorageElement : StorageElement {
    /**
     * Makes directory at current path.
     */
    public suspend fun mkdir(): DirectoryStorageElement.ChildDirectoryStorageElement

    /**
     * Makes new file at current path.
     */
    public suspend fun createNewFile(): FileStorageElement
}
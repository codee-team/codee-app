package com.codee.app.plugins.api.files

public sealed interface StorageElement {
    /**
     * Storage element name.
     */
    public val name: String

    /**
     * Storage element path starts from [DirectoryStorageElement.RootDirectoryStorageElement].
     */
    public val path: String
}
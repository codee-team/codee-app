package com.codee.app.plugins.api.files

public sealed interface DirectoryStorageElement : StorageElement {
    /**
     * Gets [StorageElement] at current path + [name].
     * @return [StorageElement].
     */
    public operator fun get(name: String): StorageElement

    /**
     * Root directory that cannot go back.
     */
    public interface RootDirectoryStorageElement : DirectoryStorageElement

    /**
     * Root directory that cannot go back.
     */
    public interface ChildDirectoryStorageElement : DirectoryStorageElement {
        public val parent: DirectoryStorageElement

        /**
         * Removes directory at current path.
         */
        public suspend fun delete()
    }
}

public fun DirectoryStorageElement.getDirectoryOrNull(name: String): DirectoryStorageElement? =
    this[name] as? DirectoryStorageElement

public fun DirectoryStorageElement.getFileOrNull(name: String): StorageElement? =
    this[name].takeIf { it is FileStorageElement }
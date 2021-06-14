package com.codee.plugins.api.files

public interface VirtualFile : FSEntity {
    /**
     * Writes bytes to file.
     * @param bytes - bytes to write.
     */
    public suspend fun writeBytes(bytes: ByteArray)

    /**
     * Reads bytes from file.
     * @return [ByteArray]
     */
    public suspend fun readBytes(): ByteArray

    /**
     * Removes file.
     */
    public suspend fun delete()

}
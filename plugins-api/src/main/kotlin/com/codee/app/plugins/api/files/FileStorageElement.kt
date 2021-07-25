package com.codee.app.plugins.api.files

import java.nio.charset.Charset

public interface FileStorageElement : StorageElement {
    /**
     * Reads content from file.
     * @return [ByteArray] of file content.
     */
    public suspend fun read(): ByteArray

    /**
     * Writes [bytes] to file.
     * @return [ByteArray] of file content.
     */
    public suspend fun write(bytes: ByteArray)

    public suspend fun delete(): EmptyStorageElement
}

public suspend fun FileStorageElement.readText(charset: Charset = Charsets.UTF_8): String = String(read(), charset)

public suspend fun FileStorageElement.writeText(text: String, charset: Charset = Charsets.UTF_8) {
    write(text.toByteArray(charset))
}
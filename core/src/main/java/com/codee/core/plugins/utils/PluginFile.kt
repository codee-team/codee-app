package com.codee.core.plugins.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.codee.core.plugins.PluginContext
import com.codee.core.plugins.pluginFolder
import java.io.File

class PluginFile internal constructor(internal val file: File, private val context: PluginContext) {

    /**
     * Gets list of files in directory.
     * @return [Result] with list of files or with exception.
     */
    suspend fun files(): Result<List<PluginFile>> = withContext(Dispatchers.IO) {
        if (!checkAccess(file, context))
            return@withContext Result.failure(
                NoPermissionToAccessFile(
                    context.pluginId,
                    file.absolutePath
                )
            )

        if (!file.isDirectory)
            return@withContext Result.failure(NotDirectoryException(file.absolutePath))

        val files = file.listFiles()?.toList()?.map {
            return@map PluginFile(file, context)
        } ?: emptyList()

        return@withContext Result.success(files)
    }

    /**
     * @return [Boolean] is directory or not.
     */
    val isDirectory: Boolean get() = file.isDirectory

    /**
     * @return [Boolean] is file or not.
     */
    val isFile: Boolean get() = file.isFile

    /**
     * Reads string from file.
     * @return content of file as [String].
     */
    suspend fun readString(): Result<String> = readBytes().map { String(it) }

    /**
     * Reads bytes from file.
     * @return content of file as [ByteArray].
     */
    @Suppress("MemberVisibilityCanBePrivate")
    suspend fun readBytes(): Result<ByteArray> = withContext(Dispatchers.IO) {
        if (!checkAccess(file, context))
            return@withContext Result.failure(
                NoPermissionToAccessFile(
                    context.pluginId,
                    file.absolutePath
                )
            )
        if (!file.isFile)
            return@withContext Result.failure(NotFileException(file.absolutePath))
        Result.success(file.readBytes())
    }

    /**
     * Writes bytes to file.
     * @param bytes - bytes that will be written.
     */
    suspend fun writeString(string: String): Result<Unit> = writeBytes(string.toByteArray())

    /**
     * Writes bytes to file.
     * @param bytes - bytes that will be written.
     */
    @Suppress("MemberVisibilityCanBePrivate")
    suspend fun writeBytes(bytes: ByteArray): Result<Unit> = withContext(Dispatchers.IO) {
        if (!checkAccess(file, context))
            return@withContext Result.failure(
                NoPermissionToAccessFile(
                    context.pluginId,
                    file.absolutePath
                )
            )
        if (!file.isFile)
            return@withContext Result.failure(NotFileException(file.absolutePath))
        Result.success(file.writeBytes(bytes))
    }

    /**
     * Creates new folder by [name].
     * @param name - folder name.
     * @return [PluginFile] with new folder.
     */
    suspend fun createFolder(name: String): Result<PluginFile> = withContext(Dispatchers.IO) {
        if (!checkAccess(file, context))
            return@withContext Result.failure(
                NoPermissionToAccessFile(
                    context.pluginId,
                    file.absolutePath
                )
            )
        val folder = File(file, name)
        folder.mkdir()
        return@withContext Result.success(PluginFile(folder, context))
    }

}

internal fun checkAccess(file: File, context: PluginContext): Boolean {
    return file.absolutePath.startsWith(context.pluginFolder.file.absolutePath)
}

class NotDirectoryException internal constructor(path: String) :
    Exception("File is not an directory at path $path.")

class NotFileException internal constructor(path: String) :
    Exception("File at path $path is not an file.")

@Suppress("MemberVisibilityCanBePrivate", "CanBeParameter")
class NoPermissionToAccessFile(identify: String, val path: String) :
    Exception("Plugin with identify $identify does not have permission to access folder at path $path.")
package me.neon.codee.core.project.templates

import android.graphics.Bitmap
import java.io.File

interface ProjectTemplate {
    /**
     * Name of this project's type.
     */
    val name: String

    /**
     * Icon of this project's type.
     */
    val icon: Bitmap?

    /**
     * Description of this project's type.
     */
    val description: String

    /**
     * Used to create the primary structure of project / files.
     */
    fun setupSources(rootDir: File)

}
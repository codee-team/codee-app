package me.neon.codee.core.project

import android.graphics.Bitmap
import me.neon.codee.core.project.templates.ProjectTemplate
import java.io.File

interface AbstractProjectType {

    /**
     * Name of the project.
     */
    val name: String

    /**
     * Display icon of for this type of projects.
     */
    val icon: Bitmap?

    /**
     * All project templates for this type of projects.
     */
    val templates: Set<ProjectTemplate>
}
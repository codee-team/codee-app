package me.neon.codee.core.plugins.language

interface Strings {
    val appName: String
    val titleProjects: String
    val messageNoProjects: String
    val titleCreate: String
    val titleCreateProject: String
}

/**
 * Application default localized strings.
 */
open class EnglishStrings : Strings {
    final override val appName: String = "Codee"
    override val titleProjects: String = "Projects"
    override val messageNoProjects: String = "You haven't created any projects yet!"
    override val titleCreate: String = "Create"
    override val titleCreateProject: String = "Create project"
}

/**
 * Default application strings.
 */
object DefaultStrings : EnglishStrings()
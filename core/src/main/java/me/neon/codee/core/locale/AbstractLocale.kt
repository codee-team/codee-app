package me.neon.codee.core.locale

/**
 * The root of any locale in the app.
 */
abstract class AbstractLocale {

    /**
     * Language code (e.x: en, uk, ru).
     */
    abstract val languageCode: String

    /**
     * Application name.
     */
    val appName: String = "Codee"

    /**
     * 'Create project' title.
     */
    abstract val titleCreateProject: String

    abstract val titleNoProjects: String

    abstract val titleCreate: String

    abstract val titleProjectName: String

    abstract val titleProjectType: String

    abstract val titleTemplate: String

    abstract val titleTemplates: String

}
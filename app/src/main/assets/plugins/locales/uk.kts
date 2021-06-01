@file:DependsOn(":core")

import me.neon.codee.core.locale.AbstractLocale
import me.neon.codee.core.locale.registerLocale
import kotlin.script.experimental.dependencies.DependsOn

object UkrainianLocale : AbstractLocale() {
    override val languageCode: String = "uk"
    override val titleCreateProject: String = "Створити проєкт"
    override val titleNoProjects: String = "Немає проєктів."
    override val titleCreate: String = "Створити"
    override val titleProjectName: String = "Ім'я проекту"
    override val titleProjectType: String = "Тип проєкту."
    override val titleTemplate: String = "Шаблон"
    override val titleTemplates: String = "Шаблони"
}

registerLocale(UkrainianLocale)
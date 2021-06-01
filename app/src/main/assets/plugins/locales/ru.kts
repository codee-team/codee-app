@file:DependsOn(":core")

import me.neon.codee.core.locale.AbstractLocale
import me.neon.codee.core.locale.registerLocale
import kotlin.script.experimental.dependencies.DependsOn

object RussianLocale : AbstractLocale() {
    override val languageCode: String = "ru"
    override val titleCreateProject: String = "Создать проект"
    override val titleNoProjects: String = "Нет проектов."
    override val titleCreate: String = "Создать"
    override val titleProjectName: String = "Имя проекта"
    override val titleProjectType: String = "Тип проекта."
    override val titleTemplate: String = "Шаблон"
    override val titleTemplates: String = "Шаблоны"
}

registerLocale(RussianLocale)
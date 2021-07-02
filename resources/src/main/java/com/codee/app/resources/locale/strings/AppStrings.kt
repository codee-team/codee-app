package com.codee.app.resources.locale.strings

import com.codee.app.resources.locale.Locale
import com.codee.app.resources.locale.localized

public abstract class AppStrings {
    public open val projects: String by localized("Projects") {
            Locale.en to "Projects"
            Locale.ru to "Проекты"
            Locale.uk to "Проєкти"
        }
    public open val project: String by localized("Project") {
            Locale.en to "Project"
            Locale.ru to "Проект"
            Locale.uk to "Проєкт"
        }
    public open val createProject: String by localized("Create project") {
            Locale.en to "Create project"
            Locale.ru to "Проект"
            Locale.uk to "Проєкт"
        }
}
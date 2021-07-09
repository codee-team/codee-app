package com.codee.app.resources.locale.strings

import com.codee.app.resources.locale.Locale
import com.codee.app.resources.locale.localized

public abstract class AppStrings {
    public open val projects: LocalizedString by localized("Projects") {
        "Projects" to Locale.en
        "Проєкти" to Locale.uk
        "Проекты" to Locale.ru
    }
    public open val project: LocalizedString by localized("Project") {
        "Project" to Locale.en
        "Проект" to Locale.ru
        "Проєкт" to Locale.uk
    }
    public open val createProject: LocalizedString by localized("Create project") {
        "Create project" to Locale.en
        "Проєкт" to Locale.uk
        "Проект" to Locale.ru
    }
}
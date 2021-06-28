package com.codee.app.resouces.locale.strings

import com.codee.app.resouces.locale.Locale
import com.codee.app.resouces.locale.localized

public interface AppStrings {
    public val projects: LocalizedString
        get() = localized("Projects") {
            Locale.en to "Projects"
            Locale.ru to "Проекты"
            Locale.uk to "Проєкти"
        }
    public val project: LocalizedString
        get() = localized("Project") {
            Locale.en to "Project"
            Locale.ru to "Проект"
            Locale.uk to "Проєкт"
        }
    public val createProject: LocalizedString
        get() = localized("Create project") {
            Locale.en to "Create project"
            Locale.ru to "Проект"
            Locale.uk to "Проєкт"
        }
}
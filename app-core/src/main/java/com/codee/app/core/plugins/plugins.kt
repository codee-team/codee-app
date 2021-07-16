package com.codee.app.core.plugins

import com.codee.app.core.CodeeStrings
import com.codee.app.core.delegates.oneTimeSet
import com.codee.app.core.extensions.darkThemeColors
import com.codee.app.core.extensions.lightThemeColors
import com.codee.app.core.extensions.toComposeColors
import com.codee.app.plugins.api.Plugin
import com.codee.app.plugins.api.PluginApi
import com.codee.app.plugins.api.PluginLocalization
import com.codee.app.plugins.api.container.*
import com.codee.app.plugins.api.container.PluginApiContainer
import com.codee.app.plugins.api.container.PluginLocalizationContainer
import com.codee.app.plugins.api.container.ThemeContainer
import com.codee.app.plugins.api.objects.PluginMetadata
import com.codee.app.resources.locale.Locale
import com.codee.app.resources.theme.DarkThemeColors
import com.codee.app.resources.theme.LightThemeColors
import kotlinx.coroutines.flow.MutableSharedFlow
import com.codee.app.plugins.api.container.ProjectTemplatesContainer
import com.codee.app.resources.locale.strings.AppStrings

class Plugin : Plugin {
    override var metadata: PluginMetadata by oneTimeSet()
    override val app: AppContainer = AppManager
    override val apis: PluginApiContainer = PluginApiContainer
    override val localizations: PluginLocalizationContainer = PluginLocalizationContainer
    override val templates: ProjectTemplatesContainer = ProjectTemplatesContainer
}

private object ProjectTemplatesContainer : ProjectTemplatesContainer {
    override val categories: MutableSharedFlow<ProjectsCategory> = MutableSharedFlow()
    override fun <T : ProjectsCategory> register(instance: T) {
        categories.tryEmit(instance)
    }
}

private object PluginApiContainer : PluginApiContainer {
    override val apis: MutableSharedFlow<PluginApi> = MutableSharedFlow()

    override fun <T : PluginApi> register(instance: T): Boolean {
        return if (apis.replayCache.any {
                it.compatibilitySettings.currentVersion ==
                        instance.compatibilitySettings.currentVersion
            })
            true
        else apis.tryEmit(instance)
    }

}

private object PluginLocalizationContainer : PluginLocalizationContainer {
    override val localizations: MutableSharedFlow<PluginLocalization> = MutableSharedFlow()

    override fun <T : PluginLocalization> register(instance: T): Boolean {
        return if (localizations.replayCache.any {
                it.compatibilitySettings.currentVersion ==
                        instance.compatibilitySettings.currentVersion
            })
            true
        else localizations.tryEmit(instance)
    }
}

private object AppManager : AppContainer {
    override val versionName: String = "1.0"
    override val versionCode: Int = 1
    override val locale: Locale = Locale.en
    override val strings: AppStrings = CodeeStrings
    override val themes: ThemeContainer = ThemeContainer
}

private object ThemeContainer : ThemeContainer {
    override var currentLightThemeColors: LightThemeColors = LightThemeColors()
        set(value) {
            lightThemeColors.value = value.toComposeColors()
            field = value
        }
    override var currentDarkThemeColors: DarkThemeColors = DarkThemeColors()
        set(value) {
            darkThemeColors.value = value.toComposeColors()
            field = value
        }
}
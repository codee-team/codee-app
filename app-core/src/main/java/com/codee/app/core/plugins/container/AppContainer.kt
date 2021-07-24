package com.codee.app.core.plugins.container

import androidx.core.os.ConfigurationCompat
import com.codee.app.core.CodeeStrings
import com.codee.app.core.ContextDI
import com.codee.app.core.extensions.toCodeeLocale
import com.codee.app.plugins.api.container.ThemeContainer
import com.codee.app.resources.locale.Locale
import com.codee.app.resources.locale.strings.AppStrings
import com.codee.app.plugins.api.container.AppContainer as IAppContainer

object AppContainer : IAppContainer {
    override val versionName: String = "1.0.0"
    override val versionCode: Int = 1
    override val locale: Locale =
        ConfigurationCompat.getLocales(ContextDI.context.resources.configuration)[0].toCodeeLocale()
    override val strings: AppStrings = CodeeStrings
    override val themes: ThemeContainer = ThemeContainer
}
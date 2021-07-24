package com.codee.app.plugins.api.container

import com.codee.app.resources.locale.Locale
import com.codee.app.resources.locale.strings.AppStrings

public interface AppContainer {
    /**
     * Version name of application.
     */
    public val versionName: String

    /**
     * Version code of application.
     */
    public val versionCode: Int

    /**
     * Current application locale.
     */
    public val locale: Locale

    /**
     * Current application strings.
     */
    public val strings: AppStrings

    /**
     * Application theme manager.
     */
    public val themes: ThemeContainer
}
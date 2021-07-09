package com.codee.app.plugins.api.manager

import com.codee.app.resources.locale.Locale

public interface AppManager {
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
     * Application theme manager.
     */
    public val themeManager: ThemeManager
}
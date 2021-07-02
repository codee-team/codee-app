package com.codee.app.plugins.manager

import com.codee.app.resouces.locale.LocalizedString

public interface AppManager {
    /**
     * App version.
     * @return [Int] with version code of app.
     */
    public val versionCode: Int

    /**
     * App version name.
     * @return [String] with version name of app.
     */
    public val versionName: String

    /**
     * App messenger manager.
     */
    public val messenger: AppMessenger
}

public interface AppMessenger {
    /**
     * Shows [message] in app.
     * @param message - message to show.
     */
    public fun showMessage(message: LocalizedString)
}
package com.codee.core

import android.content.Context
import com.codee.core.handlers.strings.NewStringsAppliedHandler
import com.codee.core.handlers.theme.NewThemeHandler

/**
 * Application communicator to listen updates.
 */
interface ApplicationProvider : NewStringsAppliedHandler, NewThemeHandler {
    /**
     * Application context.
     * @return [Context].
     */
    val context: Context
}

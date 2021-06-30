package com.codee.app.core

import android.content.Context
import androidx.core.content.res.ResourcesCompat
import androidx.core.os.ConfigurationCompat
import com.codee.app.resouces.locale.Locale
import kotlin.properties.Delegates

/**
 * Application context.
 * Initializes on application start.
 */
var appContext: Context by Delegates.notNull()

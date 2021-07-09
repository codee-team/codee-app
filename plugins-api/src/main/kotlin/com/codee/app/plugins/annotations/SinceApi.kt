package com.codee.app.plugins.annotations

/**
 * Says that the API appeared after the version
 * that was specified in the minimum (that is, there is
 * no API on the old versions, that is, the new API).
 */
@RequiresOptIn("API version check required.", level = RequiresOptIn.Level.WARNING)
@Retention(AnnotationRetention.SOURCE)
public annotation class SinceApi(public val version: Int)
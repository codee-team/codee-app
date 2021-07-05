package com.codee.app.plugins.annotations

@RequiresOptIn("Internal only api.", level = RequiresOptIn.Level.ERROR)
@Retention(AnnotationRetention.SOURCE)
public annotation class InternalOnly
package com.codee.plugins.api.annotations

import com.codee.plugins.api.permissions.Permission
import kotlin.reflect.KClass

/**
 * Marks that method required permission.
 * @param permission - permission that required.
 */
@RequiresOptIn(
    message = "To use this method you need to have permission.",
    level = RequiresOptIn.Level.WARNING
)
@Retention(AnnotationRetention.SOURCE)
public annotation class PermissionRequired(val permission: KClass<out Permission>)

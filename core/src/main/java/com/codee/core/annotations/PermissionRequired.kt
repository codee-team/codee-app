package com.codee.core.annotations

import com.codee.core.plugins.permissions.Permission
import kotlin.reflect.KClass

/**
 * Marks API as only for permitted calls.
 */
@RequiresOptIn
@Retention(AnnotationRetention.SOURCE)
annotation class PermissionRequired(val permission: KClass<out Permission>)
package com.codee.plugins.api

import com.codee.plugins.api.permissions.Permission

public interface Permissions {
    /**
     * Granted permission for plugin.
     * @return [List] of [Permission] with plugin permissions.
     */
    public val granted: List<Permission>

    /**
     * Asks for [permission] from the user.
     * @param permission - permission to ask.
     * @return [Boolean] is permitted or not.
     */
    public suspend fun request(permission: Permission): Boolean
}
package com.codee.core.plugins.permissions

class PermissionException(pluginName: String, message: String) :
    Exception("Plugin with name $pluginName called only permitted API without permission. Details: $message")
package com.codee.app.plugins.exceptions

/**
 * Throws when the registration of an API conflicts
 * with an API already registered with the same type.
 */
public class PluginTypeConflictException(simpleName: String)
    : Exception("Impossible to register $simpleName, $simpleName already registered.")
package com.codee.app.core.exceptions

data class IncompatibleException(
    val declaredMinVersion: Int,
    val declaredMaxVersion: Int,
    val version: Int
) : Exception("Impossible to run due to version incompatibility. " +
        "Accepted version: $declaredMinVersion - $declaredMaxVersion, current version - version")
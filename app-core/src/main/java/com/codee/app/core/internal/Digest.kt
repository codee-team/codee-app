package com.codee.app.core.internal

import java.math.BigInteger
import java.security.MessageDigest

internal fun String.toMD5(): String {
    val md = MessageDigest.getInstance("MD5")
    val bigInt = BigInteger(1, md.digest(toByteArray(Charsets.UTF_8)))
    return String.format("%032x", bigInt)
}
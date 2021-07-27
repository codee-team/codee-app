@file:Suppress("unused")

object ApplicationConfig {
    const val PACKAGE = "com.codee"

    const val APPLICATION_VERSION_INT = 1
    const val APPLICATION_VERSION_NAME = "1.0.1"

    const val MIN_SDK_VERSION = 24 // temporary workaround due to error while desugarizing
    const val TARGET_SDK_VERSION = 30
    const val BUILD_TOOLS_VERSION = "30.0.3"
}

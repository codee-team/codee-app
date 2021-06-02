package me.neon.codee.core

import me.neon.codee.core.plugins.PluginsCommunicator

/**
 * Codee app context.
 */
internal var applicationSource: PluginsCommunicator? = null
internal val application: PluginsCommunicator
    get() = applicationSource
        ?: error("Application isn't initialized yet.")

/**
 * Sets application to [application].
 * Shouldn't be called from plugins or somewhere else.
 */
fun initializeApplication(communicator: PluginsCommunicator) {
    if (applicationSource == null) {
        applicationSource = communicator
    } else throw IllegalStateException("You can't reinitialize application.")
}
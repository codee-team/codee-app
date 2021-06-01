package me.neon.codee.core.project

private val projectTypesSource: MutableSet<AbstractProjectType> = mutableSetOf()

val projectTypes: Set<AbstractProjectType> = mutableSetOf()

/**
 * Registers project type.
 * @param type - implemented [AbstractProjectType] with info about type.
 * @return [Boolean] is added or not.
 */
fun registerProjectType(type: AbstractProjectType) = projectTypesSource.add(type)
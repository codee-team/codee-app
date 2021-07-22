package com.codee.plugins.scripts.dependency.resolvers.metadata

/**
 * The maven resolver metadata.
 * @param repositories - repositories to search.
 * @param dependency - dependency coordinates.
 */
data class MavenResolverMetadata(val repositories: List<String>, val dependency: String) :
    ExternalResolverMetadata
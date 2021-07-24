package com.codee.plugins.scripts.dependency.resolvers

import com.codee.plugins.scripts.dependency.resolvers.metadata.ExternalResolverMetadata
import java.io.File
import kotlin.script.experimental.api.ResultWithDiagnostics

interface DependencyResolver<M : ExternalResolverMetadata> {
    /**
     * Resolves [metadata].
     * @param metadata - metadata to resolve.
     */
    suspend fun resolve(metadata: M): ResultWithDiagnostics<Collection<File>>
}
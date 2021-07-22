package com.codee.plugins.scripts.dependency.resolvers

import com.codee.plugins.scripts.dependency.resolvers.metadata.MavenResolverMetadata
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import kotlin.script.experimental.api.ResultWithDiagnostics
import kotlin.script.experimental.dependencies.addRepository
import kotlin.script.experimental.dependencies.maven.MavenDependenciesResolver

class MavenDependencyResolver : DependencyResolver<MavenResolverMetadata> {
    override suspend fun resolve(metadata: MavenResolverMetadata): ResultWithDiagnostics<Collection<File>> =
        withContext(Dispatchers.IO) {
            val mavenResolver = MavenDependenciesResolver().apply {
                metadata.repositories.forEach { addRepository(it) }
            }
            return@withContext mavenResolver.resolve(metadata.dependency)
        }
}
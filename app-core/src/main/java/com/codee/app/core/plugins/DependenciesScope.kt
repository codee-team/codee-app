package com.codee.app.core.plugins

import com.codee.app.plugins.api.DependencyRepositoriesScope as IDependencyRepositoriesScope
import com.codee.app.plugins.api.DependenciesScope as IDependenciesScope
import com.codee.app.plugins.api.DependencyScope as IDependencyScope

class DependenciesScope : IDependenciesScope {

    internal val dependencies: MutableList<Dependency> = mutableListOf()

    override fun implementation(
        coordinates: String,
        block: IDependencyScope.() -> Unit
    ) {
        val dependencyScope = DependencyScope()
        block(dependencyScope)
        dependencies.add(Dependency(coordinates, dependencyScope.repositories))
    }
}

class DependencyScope : IDependencyScope {

    internal val repositories: MutableList<String> = mutableListOf()

    override fun repositories(block: IDependencyRepositoriesScope.() -> Unit) {
        repositories
    }

}

class DependencyRepositoriesScope(private val repositories: MutableList<String>) : IDependencyRepositoriesScope {
    override fun maven(coordinates: String) {
        repositories.add(coordinates)
    }
}

class Dependency(
    val coordinates: String,
    val repositories: List<String>
)
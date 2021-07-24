package com.codee.app.core.plugins

import com.codee.app.core.exceptions.IncompatibleException
import com.codee.app.core.plugins.container.AppContainer
import com.codee.app.plugins.api.CodeeCompatibilitySettingsScope
import com.codee.app.plugins.api.DependenciesScope
import com.codee.app.resources.locale.strings.LocalizedString
import kotlin.properties.Delegates
import com.codee.app.plugins.api.CodeeCompatibilitySettingsScope as ICodeeCompatibilitySettingsScope
import com.codee.app.plugins.api.CodeeScope as ICodeeScope
import com.codee.app.plugins.api.ManifestScope as IManifestScope

class ManifestScope : IManifestScope {
    override var name: LocalizedString by Delegates.notNull()
    override var author: String by Delegates.notNull()
    override var versionName: String by Delegates.notNull()
    override var versionCode: Int by Delegates.notNull()

    private val codeeScope by lazy { CodeeScope() }
    private val dependenciesScope by lazy { DependenciesScope() }

    val declaredDependencies: List<Dependency> get() = dependenciesScope.dependencies

    override fun codee(block: ICodeeScope.() -> Unit) {
        block(codeeScope)
    }

    override fun dependencies(block: DependenciesScope.() -> Unit) {
        block(dependenciesScope)
    }
}

class CodeeScope : ICodeeScope {

    private val compatibilitySettingsScope by lazy { CodeeCompatibilitySettingsScope() }

    override fun compatibility(block: CodeeCompatibilitySettingsScope.() -> Unit) {
        block(compatibilitySettingsScope)
        val minVer = compatibilitySettingsScope.minCodeeVersion ?: AppContainer.versionCode
        val maxVer = compatibilitySettingsScope.maxCodeeVersion ?: AppContainer.versionCode
        if (minVer < AppContainer.versionCode || maxVer > AppContainer.versionCode)
                throw IncompatibleException(minVer, maxVer, AppContainer.versionCode)
    }
}

class CodeeCompatibilitySettingsScope : ICodeeCompatibilitySettingsScope {
    override var minCodeeVersion: Int? = null
    override var maxCodeeVersion: Int? = null
}

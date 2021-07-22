package com.codee.app.core.plugins

import com.codee.app.plugins.api.CodeeCompatibilitySettingsScope
import com.codee.app.plugins.api.container.AppContainer
import com.codee.app.plugins.api.container.PluginApiContainer
import com.codee.app.plugins.api.container.PluginLocalizationContainer
import com.codee.app.plugins.api.container.ProjectTemplatesContainer
import com.codee.app.resources.locale.strings.LocalizedString
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext
import kotlin.properties.Delegates
import com.codee.app.plugins.api.CodeeScope as ICodeeScope
import com.codee.app.plugins.api.DependenciesScope as IDependenciesScope
import com.codee.app.plugins.api.MetadataScope as IMetadataScope
import com.codee.app.plugins.api.PluginScope as IPluginScope

class PluginScope : IPluginScope {
    override val app: AppContainer
        get() = TODO("Not yet implemented")
    override val apis: PluginApiContainer
        get() = TODO("Not yet implemented")
    override val localizations: PluginLocalizationContainer
        get() = TODO("Not yet implemented")
    override val templates: ProjectTemplatesContainer
        get() = TODO("Not yet implemented")
    override val coroutineContext = Dispatchers.Main + Job()
}

class MetadataScope : IMetadataScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Default + Job()
    override lateinit var name: LocalizedString
    override lateinit var author: String
    override lateinit var versionName: String
    override var versionCode by Delegates.notNull<Int>()

    private val codeeScope by lazy { CodeeScope() }

    override fun codee(block: ICodeeScope.() -> Unit) {
        return block(codeeScope)
    }
}

class CodeeScope : ICodeeScope {
    override fun compatibility(block: CodeeCompatibilitySettingsScope.() -> Unit) {
        TODO("Not yet implemented")
    }
}

class DependenciesScope : IDependenciesScope {
    val dependencies: List<String> = listOf()
    override val coroutineContext: CoroutineContext = Dispatchers.IO + Job()

    override fun implementation(coordinates: String) {
        TODO("Not yet implemented")
    }
}

data class Plugin(
    val main: PluginScope,
    val manifest: MetadataScope,
    val dependencies: DependenciesScope
)

data class Owned<T>(val owner: Plugin, val value: T)
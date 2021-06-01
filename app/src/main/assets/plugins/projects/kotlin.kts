@file:DependsOn(":core")

import android.graphics.Bitmap
import me.neon.codee.core.project.AbstractProjectType
import me.neon.codee.core.project.registerProjectType
import me.neon.codee.core.project.templates.ProjectTemplate
import java.io.File
import kotlin.script.experimental.dependencies.DependsOn

object KotlinProject : AbstractProjectType {
    override val name: String = "Kotlin Project"
    override val icon: Bitmap? = null
    @ExperimentalStdlibApi
    override val templates: Set<ProjectTemplate> = setOf(SimpleHelloWorldTemplate)
}

object SimpleHelloWorldTemplate : ProjectTemplate {
    override val name: String = "Hello world"
    override val icon: Bitmap? = null
    override val description: String = "Simple project with 'hello world'"

    override fun setupSources(rootDir: File) {
        File(rootDir, "test.kt")
            .writeText("fun main() = println(\"Hello world\")")
    }

}

registerProjectType(KotlinProject)
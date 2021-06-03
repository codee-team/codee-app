package `fun`.kotlingang.deploy

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.the
import kotlin.reflect.KProperty0

internal fun deployError(message: String) {
    throw DeployException(message)
}

/**
 * Checks properties for null. If it is null, throws [DeployException].
 * @param fields - fields to check.
 */
internal fun <T> notNullPropertiesOrException(vararg fields: KProperty0<T?>) = fields.forEach { field ->
    if(field.get() == null)
        throw DeployException("Field for name `${field.name}` is null. Should be provided for deploy task.")
}

/**
 * Deploy task.
 * To applying should be specified [DeployConfiguration].
 */
class Deploy : Plugin<Project> {
    override fun apply(target: Project) {
        target.apply(plugin = "maven-publish")

        val config = target.extensions.create<DeployConfiguration>(name = "deploy")
        target.afterEvaluate {
            notNullPropertiesOrException(
                config::host,
                config::user,
                config::password,
                config::destination,
                config::libraryArtifactId,
                config::libraryDescription,
                config::libraryGroup,
                config::libraryVersion,
                config::libraryName,
                config::libraryComponents,
                config::deployTaskName
            )
            project.the<PublishingExtension>().apply {
                publications {
                    create<MavenPublication>(config.deployTaskName!!) {
                        group = config.libraryGroup!!
                        artifactId = config.libraryArtifactId!!
                        version = config.libraryVersion!!

                        pom {
                            name.set(config.libraryName)
                            description.set(config.libraryDescription)
                        }

                        from(components[config.libraryComponents!!])
                    }
                }
                repositories {
                    maven {
                        url = uri(
                            "sftp://${config.host}:22/${config.destination}"
                        )

                        credentials {
                            username = config.user
                            password = config.password
                        }
                    }
                }
            }
        }
    }
}
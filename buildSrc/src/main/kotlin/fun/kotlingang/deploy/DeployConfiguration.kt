package `fun`.kotlingang.deploy

open class DeployConfiguration {
    var user: String? = null
    var password: String? = null
    var host: String? = null
    var destination: String? = null
    var libraryName: String? = null
    var libraryDescription: String? = null
    var libraryGroup: String? = null
    var libraryArtifactId: String? = null
    var libraryVersion: String? = null
    var libraryComponents: String? = null
    var deployTaskName: String? = null
}
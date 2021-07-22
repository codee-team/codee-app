plugins {
    id(Plugin.JAVA_LIBRARY)
    kotlin(Plugin.JVM)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(scriptingDependencies)
    implementation(scriptUtil)
    implementation(scriptRuntime)
    implementation(scriptingCompilerEmbeddable)
    implementation(pluginsAPI)
    implementation(ktScriptingMavenDependencies)
    implementation(compilerJvmHost)
}
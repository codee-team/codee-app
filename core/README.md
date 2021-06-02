# Core
Everything that can be used for plugins or other customization is stored here.
There are themes, icons, localization, projects and everything related to languages (for plugins: analyzers, etc.).
## Implementation
### Gradle:
```kotlin
repositories {
  maven("https://maven.kotlingang.fun")
}
dependencies {
  implementation("me.neon.codee:core:1.0.0")
}
```
### Kotlin Script:
```kotlin
@file:Repository("https://maven.kotlingang.fun")
@file:DependsOn("me.neon.codee:core:1.0.0")

import kotlin.script.experimental.dependencies.Repository
import kotlin.script.experimental.dependencies.DependsOn

/* Your code */
```

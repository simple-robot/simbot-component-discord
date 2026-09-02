import org.gradle.kotlin.dsl.configure
import org.jetbrains.dokka.gradle.DokkaExtension

plugins {
    id("org.jetbrains.dokka")
}

extensions.configure<DokkaExtension> {
    moduleName = "Simple Robot 组件 | Discord"
}

subprojects {
    plugins.withId("org.jetbrains.dokka") {
        rootProject.dependencies.add(
            "dokka",
            rootProject.dependencies.project(mapOf("path" to path)),
        )
    }
}

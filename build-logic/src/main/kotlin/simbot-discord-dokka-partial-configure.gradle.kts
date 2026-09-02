import org.gradle.kotlin.dsl.configure
import org.jetbrains.dokka.gradle.DokkaExtension
import org.jetbrains.dokka.gradle.engine.parameters.VisibilityModifier
import java.net.URI

plugins {
    id("org.jetbrains.dokka")
}

extensions.configure<DokkaExtension> {
    moduleVersion = P.ComponentDiscord.version.toString()
    dokkaSourceSets.configureEach {
        documentedVisibilities(VisibilityModifier.Public, VisibilityModifier.Protected)

        project.file("Module.md").takeIf { it.isFile && it.length() > 0 }?.also {
            includes.from(it)
        }

        perPackageOption {
            matchingRegex.set(".*internal.*")
            suppress.set(true)
        }

        sourceLink {
            localDirectory.set(project.projectDir)
            val relativePath = project.projectDir.relativeTo(rootProject.projectDir)
                .invariantSeparatorsPath
            remoteUrl.set(URI.create("${P.ComponentDiscord.HOMEPAGE}/tree/main/$relativePath"))
            remoteLineSuffix.set("#L")
        }
    }
}

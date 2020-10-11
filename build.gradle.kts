// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath (Dependencies.gradle)
        classpath (Dependencies.kotlinGradle)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    id("com.diffplug.spotless") version "5.5.1"
}

subprojects {
    repositories {
        google()
        jcenter()
    }

    apply(plugin = "com.diffplug.spotless")
    spotless {
        kotlin {
            target("**/*.kt")
            targetExclude("$buildDir/**/*.kt")
            targetExclude("bin/**/*.kt")

            ktlint(Dependencies.ktlint)
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            // Treat all Kotlin warnings as errors
            allWarningsAsErrors = true

            freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"

            freeCompilerArgs += "-Xallow-jvm-ir-dependencies"
            freeCompilerArgs += "-Xskip-prerelease-check"

            // Set JVM target to 1.8
            jvmTarget = "1.8"
        }
    }
}

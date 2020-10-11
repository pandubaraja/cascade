plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Version.compiledSdkVersion)
    buildToolsVersion("30.0.0")

    defaultConfig {
        applicationId = "com.github.baraja.cascadedemo"

        minSdkVersion(Version.minSdkVersion)
        targetSdkVersion(Version.targetSdkVersion)
        versionCode = Version.versionCode
        versionName = Version.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin
    implementation(Dependencies.kotlin)

    // Android
    implementation(Android.appcompat)
    implementation(Android.ktx)
    implementation(Android.constraintLayout)

    // Testing
    testImplementation(Testing.core)
    testImplementation(Testing.jUnit)

    // Android Testing
    androidTestImplementation(Testing.extJUnit)
    androidTestImplementation(Testing.espresso)
}
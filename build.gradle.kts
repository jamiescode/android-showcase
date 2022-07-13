// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.plugins.gradle.get().toString())
        classpath(libs.plugins.kotlin.get().toString())
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
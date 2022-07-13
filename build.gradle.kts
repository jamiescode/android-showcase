// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.plugins.oss.licenses.get().toString())
    }
}

plugins {
    alias(libs.plugins.application) apply false
    alias(libs.plugins.library) apply false
    alias(libs.plugins.kotlin) apply false
}

apply(from = "gradle/projectDependencyGraph.gradle")

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("org.jetbrains.kotlin.plugin.compose")
    id("io.gitlab.arturbosch.detekt")
    id("org.jmailen.kotlinter")
    id("org.jetbrains.kotlinx.kover")
}

android {
    namespace = "uk.co.jamiecruwys.navigation"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(project(":feature_dog"))
    implementation(project(":ui"))

    implementation(libs.kotlin)
    implementation(libs.bundles.compose)
    implementation(libs.oss.licenses)

    testImplementation(platform(libs.junit5.bom))
    testImplementation(libs.junit5)
}
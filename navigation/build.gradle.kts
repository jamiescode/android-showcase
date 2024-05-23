plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("io.gitlab.arturbosch.detekt")
    id("org.jmailen.kotlinter")
}

android {
    namespace = "uk.co.jamiecruwys.navigation"
}

dependencies {
    implementation(libs.kotlin)
    implementation(libs.bundles.compose)

    testImplementation(platform(libs.junit5.bom))
    testImplementation(libs.junit5)
}
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
    namespace = "uk.co.jamiecruwys.gratitude"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(project(":navigation"))

    implementation(libs.kotlin)
    implementation(libs.timber)
    implementation(libs.bundles.compose)

    implementation(libs.hilt)
    implementation(project(":feature_dog"))
    kapt(libs.hilt.compiler)

    debugImplementation(libs.leakcanary)

    testImplementation(platform(libs.junit5.bom))
    testImplementation(libs.junit5)

    androidTestImplementation(libs.espresso)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.hilt.testing)
    kaptAndroidTest(libs.hilt.compiler)
}
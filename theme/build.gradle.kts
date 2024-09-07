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
    namespace = "com.jamiescode.showcase.theme"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(libs.kotlin)
    implementation(libs.bundles.compose)
    implementation(libs.oss.licenses)

    testImplementation(platform(libs.junit5.bom))
    testImplementation(libs.junit5)

    androidTestImplementation(libs.espresso)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.hilt.testing)
    kaptAndroidTest(libs.hilt.compiler)
}
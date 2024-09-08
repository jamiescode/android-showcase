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
    namespace = "com.jamiescode.showcase.construction"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(project(":feature_dog"))
    implementation(project(":theme"))

    implementation(libs.kotlin)
    implementation(libs.timber)
    implementation(libs.glide)

    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.compose)

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    testImplementation(platform(libs.junit5.bom))
    testImplementation(libs.junit5)
    testImplementation(libs.mockk)
    testImplementation(libs.kluent)

    androidTestImplementation(libs.espresso)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.hilt.testing)
    kaptAndroidTest(libs.hilt.compiler)
}
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
    namespace = "uk.co.jamiecruwys.showcase.cat"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(libs.kotlin)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.oss.licenses)
    implementation(libs.startup)
    implementation(libs.timber)
    implementation(libs.glide)

    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.ktx)
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.accompanist)

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    debugImplementation(libs.leakcanary)

    testImplementation(platform(libs.junit5.bom))
    testImplementation(libs.junit5)

    androidTestImplementation(libs.espresso)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.hilt.testing)
    kaptAndroidTest(libs.hilt.compiler)
}
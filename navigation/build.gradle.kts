plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("io.gitlab.arturbosch.detekt")
    id("org.jmailen.kotlinter")
}

dependencies {
    implementation(libs.kotlin)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.accompanist)

    debugImplementation(libs.leakcanary)

    testImplementation(platform(libs.junit5.bom))
    testImplementation(libs.junit5)

    androidTestImplementation(libs.espresso)
    androidTestImplementation(libs.hilt.testing)
    kaptAndroidTest(libs.hilt.compiler)
}
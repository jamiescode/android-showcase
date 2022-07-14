plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("io.gitlab.arturbosch.detekt")
    id("org.jmailen.kotlinter")
    id("com.google.dagger.hilt.android")
}

dependencies {
    implementation(libs.kotlin)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.glide)
    implementation(libs.oss.licenses)

    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.ktx)
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.accompanist)

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    debugImplementation(libs.leakcanary)

    annotationProcessor(libs.annotation.glide.compiler)

    testImplementation(platform(libs.junit5.bom))
    testImplementation(libs.junit5)

    androidTestImplementation(libs.espresso)
    androidTestImplementation(libs.hilt.testing)
    kaptAndroidTest(libs.hilt.compiler)
}
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.android.gms.oss-licenses-plugin")
    id("io.gitlab.arturbosch.detekt")
    id("org.jmailen.kotlinter")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = libs.versions.sdk.compile.get().toInt()

    defaultConfig {
        applicationId = "uk.co.jamiecruwys.showcase"
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.sky.sport.test.HiltTestRunner"
    }

    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
        }
        getByName("release") {
            isShrinkResources = false
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = freeCompilerArgs + kotlinCompilerOptIns()
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    // Hilt Android - allow references to generated code
    kapt {
        correctErrorTypes = true
    }

    namespace = "uk.co.jamiecruwys.showcase"
}

fun kotlinCompilerOptIns(): String = listOf(
    "androidx.compose.animation.ExperimentalAnimationApi",
    "androidx.compose.foundation.ExperimentalFoundationApi",
).joinToString(prefix = "-Xopt-in=", separator = ",")

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
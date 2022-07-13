plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = libs.versions.sdk.compile.get().toInt()

    defaultConfig {
        applicationId = "uk.co.jamiecruwys.showcase"
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
        }
        getByName("release") {
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }

    namespace = "uk.co.jamiecruwys.showcase"
}

dependencies {
    implementation(libs.kotlin)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.retrofit.logging.interceptor)
    implementation(libs.kodein)
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.constraint.layout)
    implementation(libs.lifecycle.ext)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.glide)

    annotationProcessor(libs.annotation.glide.compiler)

    testImplementation(libs.junit)

    androidTestImplementation(libs.junit.ui)
    androidTestImplementation(libs.espresso)
}
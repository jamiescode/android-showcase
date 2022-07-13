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
    }

    buildFeatures {
        viewBinding = true
    }

    // Hilt Android - allow references to generated code
    kapt {
        correctErrorTypes = true
    }

    namespace = "uk.co.jamiecruwys.showcase"
}

dependencies {
    implementation(libs.kotlin)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.ext)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.glide)
    implementation(libs.oss.licenses)
    implementation(libs.activity.ktx)
    implementation(libs.fragment.ktx)
    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)

    debugImplementation(libs.leakcanary)

    annotationProcessor(libs.annotation.glide.compiler)

    testImplementation(platform(libs.junit5.bom))
    testImplementation(libs.junit5)

    androidTestImplementation(libs.espresso)
    androidTestImplementation(libs.dagger.hilt.testing)
    kaptAndroidTest(libs.dagger.hilt.compiler)
}
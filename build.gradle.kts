import com.android.build.api.dsl.BuildFeatures
import com.android.build.api.dsl.LibraryDefaultConfig
import com.android.build.api.dsl.TestOptions
import com.android.build.api.dsl.Lint
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.plugins.oss.licenses.get().toString())
    }
}

plugins {
    alias(libs.plugins.application) apply false
    alias(libs.plugins.library) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.kover)
}

dependencies {
    kover(project(":app"))
    kover(project(":feature_gratitude"))
    kover(project(":feature_dog"))
    kover(project(":navigation"))
}

kover {
    reports {
        filters {
            excludes {
                androidGeneratedClasses()
            }
        }
    }
}

apply(from = "gradle/projectDependencyGraph.gradle")

allprojects {
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
            freeCompilerArgs.add(kotlinCompilerOptIns())
        }
    }
    tasks.withType<JavaCompile> { applySharedConfig() }
    tasks.withType<Test> { applySharedConfig() }

    val moduleName = this.name
    afterEvaluate {
        plugins.withId("com.android.application") {
            getBaseAppModuleExtensionOrNull()?.applySharedConfig(moduleName)
        }
        plugins.withId("com.android.library") {
            getLibraryExtensionOrNull()?.applySharedConfig(moduleName)
        }
    }

    repositories {
        google()
        mavenCentral()
    }
}

fun kotlinCompilerOptIns(): String = listOf(
    "androidx.compose.animation.ExperimentalAnimationApi",
    "androidx.compose.foundation.ExperimentalFoundationApi",
).joinToString(prefix = "-opt-in=", separator = ",")

/**
 * Which Java version the app will use
 */
fun appJavaVersion(): String = JavaVersion.VERSION_17.toString()

fun JavaCompile.applySharedConfig() {
    val javaVersion = JavaVersion.VERSION_17.toString()
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}

fun Test.applySharedConfig() {
    useJUnitPlatform()
    testLogging {
        // Logging out the events allows us to spot any hanging tests
        events("started", "passed", "skipped", "failed", "standardOut", "standardError")
        outputs.upToDateWhen { false }
        showStandardStreams = true
    }
    addTestListener(createTestListener())
}

fun createTestListener(): TestListener = object: TestListener {
    override fun beforeTest(testDescriptor: TestDescriptor?) {}
    override fun afterTest(testDescriptor: TestDescriptor?, result: TestResult?) {}
    override fun beforeSuite(suite: TestDescriptor?) {}
    override fun afterSuite(suite: TestDescriptor?, result: TestResult?) {
        if (suite?.parent != null && result != null) {
            val output = createTestSummaryText(result)
            val startItem = "|  "
            val endItem = "  |"
            val repeatLength = startItem.length + output.length + endItem.length
            val separator = "-".repeat(repeatLength)
            println("\n" + separator + "\n" + startItem + output + endItem + "\n" + separator)
        }
    }

    fun createTestSummaryText(result: TestResult): String {
        val summaryText = "Results: ${result.resultType} "
        val countText = "${result.testCount} tests"
        val passedText = "${result.successfulTestCount} passed"
        val failedText = "${result.failedTestCount} failed"
        val skippedText = "${result.skippedTestCount} skipped"
        return "$summaryText ($countText, $passedText, $failedText, $skippedText)"
    }
}

fun Project.getBaseAppModuleExtensionOrNull(): BaseAppModuleExtension? = try {
    extensions.getByName("android") as BaseAppModuleExtension
} catch (e: Exception) {
    logger.info("App module $name does not have the \"android\" extension!")
    null
}

fun Project.getLibraryExtensionOrNull(): LibraryExtension? = try {
    extensions.getByName("android") as LibraryExtension
} catch (e: Exception) {
    logger.info("Module $name does not have the \"android\" extension!")
    null
}

fun BaseAppModuleExtension.applySharedConfig(moduleName: String) {
    logger.info("Applying shared config to module $moduleName")
    compileSdk = libs.versions.sdk.compile.get().toInt()
    defaultConfig.applySharedConfig()
    testOptions.applySharedConfig()
    buildFeatures.applySharedConfig()
}

fun LibraryExtension.applySharedConfig(moduleName: String) {
    logger.info("Applying shared config to module $moduleName")
    compileSdk = libs.versions.sdk.compile.get().toInt()
    defaultConfig.applySharedConfig(withConsumerProguard = true)
    testOptions.applySharedConfig()
    buildFeatures.applySharedConfig()
    lint.applySharedConfig()
}

fun LibraryDefaultConfig.applySharedConfig(withConsumerProguard: Boolean = false) {
    minSdk = libs.versions.sdk.min.get().toInt()
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    if (withConsumerProguard) {
        consumerProguardFiles("consumer-rules.pro")
    }
}

fun TestOptions.applySharedConfig() {
    animationsDisabled = true
    unitTests.isReturnDefaultValues = true
}

fun BuildFeatures.applySharedConfig() {
    compose = true
    viewBinding = true
}

fun Lint.applySharedConfig() {
    checkDependencies = true
}
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

rootProject.name = "Showcase"

include(
    ":app",
    ":ui",
    ":navigation",
    ":feature_dog",
    ":feature_cat",
    ":feature_home",
)

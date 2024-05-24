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
    ":feature_cat",
    ":feature_dog",
    ":feature_home",
    ":navigation",
)

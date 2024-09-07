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
    ":feature_dog",
    ":feature_gratitude",
    ":feature_settings",
    ":feature_quote",
    ":navigation",
    ":theme",
)

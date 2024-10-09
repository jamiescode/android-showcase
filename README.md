# Android Showcase

[![Build Status](https://github.com/jamiescode/android-showcase/actions/workflows/build.yml/badge.svg)](https://github.com/jamiescode/android-showcase/actions/workflows/build.yml)
[![Codebeat](https://codebeat.co/badges/01a10974-5fcc-45f3-b079-9f8359d39cef)](https://codebeat.co/projects/github-com-jamiescode-android-showcase-main)
[![CodeFactor](https://www.codefactor.io/repository/github/jamiescode/android-showcase/badge)](https://www.codefactor.io/repository/github/jamiescode/android-showcase)
[![GitHub release](https://img.shields.io/github/release/jamiescode/android-showcase.svg?maxAge=60)](https://github.com/jamiescode/android-showcase/releases)
[![Codecov](https://codecov.io/github/jamiescode/android-showcase/graph/badge.svg?token=5W75L8DUQ0)](https://codecov.io/github/jamiescode/android-showcase)

[![Kotlin Version](https://img.shields.io/badge/Kotlin-2.0.x-blue.svg)](https://kotlinlang.org)
[![AGP](https://img.shields.io/badge/AGP-8.x-blue?style=flat)](https://developer.android.com/studio/releases/gradle-plugin)
[![Gradle](https://img.shields.io/badge/Gradle-8.x-blue?style=flat)](https://gradle.org)
[![License](https://img.shields.io/github/license/jamiescode/android-showcase)](https://github.com/jamiescode/android-showcase/blob/main/LICENSE)
![Min SDK 24](https://img.shields.io/badge/Min%20SDK-24-839192?logo=android&logoColor=white)
![Target SDK 35](https://img.shields.io/badge/Target%20SDK-35-566573?logo=android&logoColor=white)
[![Language: Kotlin](https://img.shields.io/github/languages/top/jamiescode/android-showcase.svg)](https://github.com/jamiescode/android-showcase/search?l=kotlin)

Showcase Android application MVVM, clean architecture, Jetpack Compose and more

To see the list of current and upcoming features please take a look at the [feature roadmap](ROADMAP.md).

## Screenshots

| Empty | List | Settings |
| --- | --- | --- |
| ![Empty](.screenshots/screenshot-empty.webp) | ![List](.screenshots/screenshot-list.webp) | ![Settings](.screenshots/screenshot-settings.webp) |

## Code quality

The following code quality tools are used:

* [Detekt](https://github.com/detekt/detekt) - Static code analysis for Kotlin code
* [Kotlinter](https://github.com/jeremymailen/kotlinter-gradle) - Static code analysis using [ktlint](https://github.com/pinterest/ktlint)
* [Android lint](http://tools.android.com/tips/lint) - scans Android code for bugs
* [Kover](https://github.com/Kotlin/kotlinx-kover) - collects test coverage data

How to run the code quality tools:

* Run `./gradlew check` to run all checks
* Run `./gradlew detekt` to run Detekt
* Run `./gradlew formatKotlin` to automatically format your code
* Run `./gradlew lintKotlin` to run ktlint via Kotlinter
* Run `./gradlew lint` to run Android lint

How to run the code coverage tools:
* Run `./gradlew :app:koverXmlReportDebug` to generate the Kover XML report
* Run `./gradlew :app:koverHtmlReportDebug` to generate the Kover HTML report

How to run the UI tests:
* Run `./gradlew connectedCheck`

How to generate the dependency graph:
* [Install `graphviz`](https://graphviz.gitlab.io/download/)
* Run `./gradlew projectDependencyGraph`. The [gradle file](gradle/projectDependencyGraph.gradle) is in the `gradle` folder
* The graph can be found at `/build/reports/dependency-graph/project.dot.png`
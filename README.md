# Android Showcase

[![Build Status](https://github.com/jamiecruwys/android-showcase/actions/workflows/build.yml/badge.svg)](https://github.com/JamieCruwys/android-showcase/actions/workflows/build.yml)
[![Codebeat](https://codebeat.co/badges/7060f5c8-f2a1-467e-9282-baab0c0e9b3b)](https://codebeat.co/projects/github-com-jamiecruwys-android-showcase-main)
[![CodeFactor](https://www.codefactor.io/repository/github/jamiecruwys/android-showcase/badge)](https://www.codefactor.io/repository/github/jamiecruwys/android-showcase)
[![GitHub release](https://img.shields.io/github/release/jamiecruwys/android-showcase.svg?maxAge=60)](https://github.com/jamiecruwys/android-showcase/releases)
[![TODOs](https://badgen.net/https/api.tickgit.com/badgen/github.com/jamiecruwys/android-showcase)](https://www.tickgit.com/browse?repo=github.com/jamiecruwys/android-showcase)
[![Codecov](https://codecov.io/github/JamieCruwys/android-showcase/graph/badge.svg?token=5W75L8DUQ0)](https://codecov.io/github/JamieCruwys/android-showcase)

[![Kotlin Version](https://img.shields.io/badge/Kotlin-2.0.x-blue.svg)](https://kotlinlang.org)
[![AGP](https://img.shields.io/badge/AGP-8.x-blue?style=flat)](https://developer.android.com/studio/releases/gradle-plugin)
[![Gradle](https://img.shields.io/badge/Gradle-8.x-blue?style=flat)](https://gradle.org)
[![License](https://img.shields.io/github/license/jamiecruwys/android-showcase)](https://github.com/jamiecruwys/android-showcase/blob/master/LICENSE)
![Min SDK 23](https://img.shields.io/badge/Min%20SDK-23-839192?logo=android&logoColor=white)
![Target SDK 34](https://img.shields.io/badge/Target%20SDK-34-566573?logo=android&logoColor=white)
[![Language: Kotlin](https://img.shields.io/github/languages/top/jamiecruwys/android-showcase.svg)](https://github.com/jamiecruwys/android-showcase/search?l=kotlin)

Android application using MVVM, clean architecture &amp; Jetpack components


## Code quality

The following code quality tools are used:

* [Detekt](https://github.com/detekt/detekt) - Static code analysis for Kotlin code
* [Kotlinter](https://github.com/jeremymailen/kotlinter-gradle) - Static code analysis using [ktlint](https://github.com/pinterest/ktlint)
* [Android lint](http://tools.android.com/tips/lint) - scans Android code for bugs

How to run the code quality tools:

* Run `./gradlew check` to run all checks
* Run `./gradlew detekt` to run Detekt
* Run `./gradlew formatKotlin` to automatically format your code
* Run `./gradlew lintKotlin` to run ktlint via Kotlinter
* Run `./gradlew lint` to run Android lint

How to run the UI tests:
* Run `./gradlew connectedCheck`
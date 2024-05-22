# android-showcase
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
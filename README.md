# weekly-weather

A short Android sample app using the [Open Weather Map API](http://openweathermap.org/forecast5), [RxJava](https://github.com/ReactiveX/RxJava), [Dagger 2](http://google.github.io/dagger/) and Card Views.

<a href="screenshot.png"><img src="screenshot.png" alt="Weekly Weather" width= "240" /></a>

## Building

Edit your Global Gradle properties file `~/.gradle/gradle.properties` and add the variable `uk.co.josephearl.android.weeklyweather.apikey` with your Open Weather Map API key, e.g.:

    uk.co.josephearl.android.weeklyweather.apikey="xxxxxxxxx"

Build:

    ./gradlew build

Run:

    ./gradlew installDebug

Test:

    ./gradlew test


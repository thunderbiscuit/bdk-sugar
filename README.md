# Readme
This repository serves as an example of what could be done in a "sugar library" to add functionality to the [bdk-android](https://github.com/bitcoindevkit/bdk-ffi) and [bdk-jvm](https://github.com/bitcoindevkit/bdk-ffi) libraries.

To test the library, first build locally and deploy to your local Maven repository:
```shell
./gradlew publishToMavenLocal
```
Then add `mavenLocal()` to the list of repositories your app should fetch from and add it as a dependency:
```kotlin
// build.gradle.kts
repositories {
    mavenLocal()
}

dependencies {
    implementation("com.bdkutilities:sugar:0.25.0")
}
```

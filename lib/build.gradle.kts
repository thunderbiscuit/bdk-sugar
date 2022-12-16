import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.21"
    id("java-library")
    id("maven-publish")
}

version = "0.25.0-SNAPSHOT"
group = "com.bdkutilities"

tasks.jar {
    manifest {
        attributes(
            mapOf(
                "Implementation-Title" to project.name,
                "Implementation-Version" to project.version
            )
        )
    }
}

java {
    withSourcesJar()
    withJavadocJar()
}

kotlin {
    explicitApi = ExplicitApiMode.Strict
}

repositories {
    mavenCentral()
}

tasks {
    test {
        testLogging {
            events("PASSED", "SKIPPED", "FAILED")
            showExceptions = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    implementation("org.bitcoindevkit:bdk-jvm:0.25.0")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

publishing {
    publications {
        create<MavenPublication>("LocalMaven") {
            groupId = "com.bdkutilities"
            artifactId = "sugar"
            version = "0.25.0"

            from(components["java"])
        }
    }
}

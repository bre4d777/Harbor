import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.20"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
}

tasks.shadowJar {
    archiveClassifier.set("") 
    dependencies {
        include(dependency("org.jetbrains.kotlin:kotlin-stdlib"))
    }
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

application {
    mainClass.set("MainKt")
}

import org.gradle.jvm.tasks.Jar

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.2.51" //the bundled version of kotlin
    id("org.springframework.boot") version "2.0.2.RELEASE" //apply plugin spring 2.0.2release
    id("org.jetbrains.kotlin.jvm") version kotlinVersion //apply plugin kotlin version
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion //apply kotlin spring plugin
    id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion //jpa plugin for kotlin to make default constructors
    // behind the scene
    id("io.spring.dependency-management") version "1.0.5.RELEASE" //if depency mgmt on spring is needed
    id("org.jetbrains.dokka") version "0.9.16"
}

group = "io.github.amaan75" //group id usually your domain name
version = "1.0.0-SNAPSHOT" //version of app

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"

    }
}
val dokka by tasks.getting(org.jetbrains.dokka.gradle.DokkaTask::class) {
    outputFormat = "html"
    outputDirectory = "$buildDir/javadoc"
}

val dokkaJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles Kotlin docs with Dokka"
    classifier = "javadoc"
    from(dokka)
}

repositories {
    mavenCentral()
}

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compile("org.jetbrains.kotlin:kotlin-reflect")
    compile("com.h2database:h2")//h2 seems to work better
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

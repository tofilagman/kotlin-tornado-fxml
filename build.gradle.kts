import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.4.0"
    id("com.github.johnrengelman.shadow") version "4.0.4"
    application
}
group = "com.test"
version = "1.0-SNAPSHOT"

val tornadofx_version: String by rootProject

repositories {
    mavenCentral()
}

application {
    mainClassName = "com.example.MainKt"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("no.tornado:tornadofx:$tornadofx_version")
    implementation("com.google.guava:guava:26.0-jre")
    testImplementation(kotlin("test-junit"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    named<ShadowJar>("shadowJar") {
        archiveBaseName.set("shadow")
        mergeServiceFiles()
        manifest {
            attributes(mapOf("Main-Class" to "com.example.MainKt"))
        }
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}



//tasks.withType<Jar>() {
//    manifest {
//        attributes["Main-Class"] = "com.example.MainKt"
//    }
//    configurations["compileClasspath"].forEach { file: File ->
//        from(zipTree(file.absoluteFile))
//    }
//}
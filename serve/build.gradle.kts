plugins {
    id("application")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains:annotations:23.0.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "serve.App",
        )
    }
}

application {
    mainClass.set("serve.App")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.register<Exec>("nativeBuild") {
    dependsOn("jar")
    commandLine(
        "${environment["GRAALVM_HOME"]}/bin/native-image",
        "-jar",
        "$buildDir/libs/serve.jar",
        "$buildDir/libs/serve",
    )
}

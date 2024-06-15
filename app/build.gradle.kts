plugins {
    application
    checkstyle
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.7.5")
    annotationProcessor("info.picocli:picocli-codegen:4.7.5")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.14.2")
    implementation("commons-io:commons-io:2.6")
}
tasks.test {
    useJUnitPlatform()
}
application {
    mainClass = "hexlet.code.App"
}
tasks.jacocoTestReport { reports { xml.required.set(true) } }
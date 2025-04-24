plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.9.25"
    id("org.jetbrains.intellij") version "1.17.4"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2024.1.7")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))
}

dependencies {
    // JUnit 5 Dependencies
    // testImplementation: 编译和运行测试所需的 API
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0") // 可以去 Maven Central 查找最新版本

    // testRuntimeOnly: 仅在运行时需要的测试引擎
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0") // 版本通常与 api 版本一致

    // 如果你的测试需要访问 IntelliJ SDK 的特定部分
    // 比如 PSI 相关的测试 (虽然你当前的 Lexer 测试可能不需要)
    // testImplementation(intellij.tests) // 引入 IntelliJ 平台的测试依赖

    // 添加你其他的依赖（如果有的话）
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("241")
        untilBuild.set("251.*")
    }
    test {
        // Use the JUnit Platform for running tests (required for JUnit 5)
        useJUnitPlatform()

        // 可选：配置测试报告的详细程度
        // testLogging {
        //     events("passed", "skipped", "failed", "standardOut", "standardError")
        // }
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}

import org.gradle.kotlin.dsl.maven

plugins {
  `java-library`
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

repositories {
  mavenLocal()
  mavenCentral()
  maven("https://repo.purpurmc.org/snapshots/")
  maven("https://repo.aikar.co/content/groups/aikar/")
  maven("https://repo.codemc.org/repository/maven-public/")
  maven("https://jitpack.io/")
}

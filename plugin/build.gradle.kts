plugins {
  id("project.common-conventions")
  alias(libs.plugins.shadow)
  alias(libs.plugins.pluginyml)
  alias(libs.plugins.blossom)
}

dependencies {
  compileOnly(libs.purpur)
  
  compileOnly(libs.dazzleconf)
  compileOnly(libs.iridiumcolorapi)
  
  compileOnly(libs.gson)
}

val release = property("version") as String

tasks {
  shadowJar {
    archiveClassifier.set("")
    archiveFileName.set("commanditems-v$release.jar")
    
    destinationDirectory.set(file("$rootDir/bin/"))
  }
  
  clean {
    delete("$rootDir/bin/")
  }
}

bukkit {
  name = "CommandItems"
  main = "net.velex.commanditems.plugin.CommandItemsPlugin"
  authors = listOf("Qekly", "Yamakaja")
  
  apiVersion = "1.19"
  version = release
  
  libraries = listOf(
    "com.github.VelexNetwork:iridium-color-api:1.2.0",
    "space.arim.dazzleconf:dazzleconf-ext-snakeyaml:1.3.0-M2",
    "com.google.code.gson:gson:2.10.1"
  )
  
  commands {
    register("commanditems") {
      description = "Admin command."
      aliases = listOf("ci", "cmdi")
    }
  }
}

blossom {
  val route = "src/main/java/net/velex/commanditems/plugin/Constants.java"
  replaceToken("{version}", release, route)
}
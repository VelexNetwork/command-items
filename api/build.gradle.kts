plugins {
  id("project.publishing-conventions")
  alias(libs.plugins.shadow)
}

dependencies {
  compileOnly(libs.purpur)
  
  compileOnly(libs.dazzleconf)
  compileOnly(libs.gson)
}

tasks {
  shadowJar {
    val release = property("version") as String
    archiveFileName.set("commanditems-api-v$release.jar")
    
    destinationDirectory.set(file("$rootDir/bin/"))
  }
  
  clean {
    delete("$rootDir/bin/")
  }
}

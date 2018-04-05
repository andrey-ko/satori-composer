## Composition diagram drawer


#### Example using dedicated 'GenerateCompositionDiagram' gradle task
```gradle
buildscript{
  repositories {
    mavenCentral()
    maven {
      url('https://oss.sonatype.org/content/repositories/snapshots/')
    }
  }
  dependencies {
    classpath "com.satori:satori-libs-composition-drawer:0.5.13-SNAPSHOT"
  }
}

task generateCompositionDiagram(type: GenerateCompositionDiagramTask) {
  group "codegen"
  
  cfgPath = file("path/to/config.json")
  imgPath = file("path/to/diagram.png")
  blockWidth = 230
  blockHeight = 45
}
```

### Example using 'JavaExec' gradle task
```gradle
repositories {
  mavenCentral()
  maven {
    url('https://oss.sonatype.org/content/repositories/snapshots/')
  }
}
  
configurations{compositionDrawer}
dependencies {
  compositionDrawer "com.satori:satori-libs-composition-drawer:0.5.13-SNAPSHOT"
}

task generateCompositionDiagram(type: JavaExec) {
  group "codegen"

  def cfgPath = file("path/to/config.json")
  def imgPath = file("path/to/diagram.png")

  inputs.file(cfgPath)
  outputs.file(imgPath)

  classpath = configurations.compositionDrawer
  main = 'com.satori.libs.composition.drawer.App'

  args "--cfg-path", cfgPath
  args "--img-path", imgPath
  args "--block-width", 230
  args "--block-height", 45

  doFirst {
    println "generating composition diagram ...."
    println commandLine.join(" ")
  }
}
```


### Maven (snapshots)
```xml
<repository>
  <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
</repository>
```
```xml
<dependency>
    <groupId>com.satori</groupId>
    <artifactId>satori-libs-composition-drawer</artifactId>
    <version>0.5.13-SNAPSHOT</version>
</dependency>
```

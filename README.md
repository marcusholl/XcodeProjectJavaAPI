#Read Me

##Description

These classes implement a basic API for the Xcode project file (works also with Xcode 4.3).

Note: *The low level classes in the ```com.sap.prd.mobile.ios.mios.xcodeprojreader.jaxb``` package can be used to load and save arbitrary property lists.*

##Usage

###Create a property list parser

``` java
JAXBPlistParser parser = new JAXBPlistParser();
// Xcode project file has to be converted to XML
parser.convert("path/to/project.pbxproj", "path/to/project.pbxproj/or/other/destination");
Plist plist = parser.load(JAXBPlistParserTest.fileName);
```

###Get/Set values

```java
ProjectFile projectFile = new ProjectFile(plist);
assertEquals("46", projectFile.getObjectVersion());

Project project = projectFile.getProject();

Target target = project.getTargets().get(0);
assertEquals("MyTest", target.getName());

target = project.getTargets().getByName("MyTest");
assertEquals("MyTest", target.getName());

BuildConfiguration config =
      project.getBuildConfigurationList().getBuildConfigurations().get(0);
assertEquals("Debug",
      config.getName());

config = project.getBuildConfigurationList().getBuildConfigurations().getByName("Release");
assertEquals("Release", config.getName());

BuildSettings buildSettings = config.getBuildSettings();
assertEquals("5.1",
      buildSettings.getString("IPHONEOS_DEPLOYMENT_TARGET"));
buildSettings.setString("IPHONEOS_DEPLOYMENT_TARGET", "4.0");
assertEquals("4.0",
      buildSettings.getString("IPHONEOS_DEPLOYMENT_TARGET"));

assertEquals("YES",
      buildSettings.getString("VALIDATE_PRODUCT"));
```

### Example: Add custom build phase
####Low Level (not recommended)

```java
Array buildPhaseRefs = project.getTargets().get(0).getArray("buildPhases");
String ref = projectFile.generateReference();
Dict phase = projectFile.createDict();
phase.put("isa", "PBXShellScriptBuildPhase");
phase.put("files", projectFile.createArray());
phase.put("inputPaths", projectFile.createArray());
phase.put("outputPaths", projectFile.createArray());
phase.put("runOnlyForDeploymentPostprocessing", "0");
phase.put("shellPath", "/bin/sh");
phase.put("shellScript", "env > test.txt");
projectFile.setObjectByReference(ref, phase);
buildPhaseRefs.add(ref);
parser.save(plist, "path/to/project.pbxproj");
```

####High Level

```java
ReferenceArray<BuildPhase> buildPhases = project.getTargets().get(0).getBuildPhases();
ShellScriptBuildPhase phase2 = new ShellScriptBuildPhase(projectFile);
phase2.setDefaultValues();
phase2.setShellScript("env > test.txt");
buildPhases.add(phase2);
parser.save(plist, "path/to/project.pbxproj");
```

Note: *Collections are created on the fly.*

``` java
project.getTargets().get(0).getBuildPhases().size()
```
*would create a collection of targets and a collection of build phases if they don't exist. This is important to know, if you intend to save the property list later. If you don't want this behavior, you have to use the low level APIs.*

##Known limitations

The following elements are not parsed, yet:

- Date
- Data
- Integer
- Real
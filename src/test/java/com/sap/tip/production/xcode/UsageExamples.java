package com.sap.tip.production.xcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.tip.production.xcode.buildphases.BuildPhase;
import com.sap.tip.production.xcode.buildphases.ShellScriptBuildPhase;
import com.sap.tip.production.xcode.jaxb.JAXBPlistParser;
import com.sap.tip.production.xcode.jaxb.JAXBPlistParserTest;

public class UsageExamples
{
  @Test
  public void usage() throws Exception
  {
    JAXBPlistParser parser = new JAXBPlistParser();
    Plist plist = parser.load(JAXBPlistParserTest.fileName);

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
    assertEquals("YES",
          buildSettings.getString("VALIDATE_PRODUCT"));

    // LOW LEVEL (not recommended)
    Array buildPhaseRefs = project.getTargets().get(0).getArray("buildPhases");
    String ref = projectFile.generateReference();
    buildPhaseRefs.add(ref);
    Dict phase = projectFile.createDict();
    phase.put("isa", "PBXShellScriptBuildPhase");
    phase.put("files", projectFile.createArray());
    phase.put("inputPaths", projectFile.createArray());
    phase.put("outputPaths", projectFile.createArray());
    phase.put("runOnlyForDeploymentPostprocessing", "0");
    phase.put("shellPath", "/bin/sh");
    phase.put("shellScript", "env > test.txt");
    projectFile.setObjectByReference(ref, phase);

    // HIGH LEVEL
    ReferenceArray<BuildPhase> buildPhases = project.getTargets().get(0).getBuildPhases();
    ShellScriptBuildPhase phase2 = new ShellScriptBuildPhase(projectFile);
    phase2.setDefaultValues();
    phase2.setShellScript("env > test.txt");
    buildPhases.add(phase2);

    //parser.save(plist, JAXBPlistParserTest.fileName);
  }
}

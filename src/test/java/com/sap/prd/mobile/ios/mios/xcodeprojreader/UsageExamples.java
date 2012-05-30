/*
 * #%L
 * xcode-project-reader
 * %%
 * Copyright (C) 2012 SAP AG
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.sap.prd.mobile.ios.mios.xcodeprojreader;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.buildphases.BuildPhase;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.buildphases.PBXShellScriptBuildPhase;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.jaxb.JAXBPlistParser;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.jaxb.JAXBPlistParserTest;

public class UsageExamples
{
  @Test
  public void usage() throws Exception
  {
    JAXBPlistParser parser = new JAXBPlistParser();
    
    // optional step, if project file is not already in XML format
    // parser.convert(JAXBPlistParserTest.fileName, JAXBPlistParserTest.fileName)
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
    PBXShellScriptBuildPhase phase2 = new PBXShellScriptBuildPhase(projectFile);
    phase2.setDefaultValues();
    phase2.setShellScript("env > test.txt");
    buildPhases.add(phase2);

//parser.save(plist, JAXBPlistParserTest.fileName);
  }
}

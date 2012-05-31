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
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.buildphases.PBXShellScriptBuildPhase;

public class ShellScriptBuildPhaseTest
{
  private ProjectFile projectFile;

  @Before
  public void before() throws Exception
  {
    projectFile = ProjectFileTest.load();
  }

  @Test
  public void defaultValues()
  {
    PBXShellScriptBuildPhase phase = new PBXShellScriptBuildPhase(projectFile);

    assertNull(phase.getIsA());
    assertEquals(0, phase.getFiles().size());
    assertEquals(0, phase.getInputPaths().size());
    assertEquals(0, phase.getOutputPaths().size());
    assertNull(phase.getRunOnlyForDeploymentPostprocessing());
    assertNull(phase.getShellPath());

    phase.setDefaultValues();

    assertEquals(PBXShellScriptBuildPhase.isa, phase.getIsA());
    assertEquals(0, phase.getFiles().size());
    assertEquals(0, phase.getInputPaths().size());
    assertEquals(0, phase.getOutputPaths().size());
    assertEquals("0", phase.getRunOnlyForDeploymentPostprocessing());
    assertEquals("/bin/sh", phase.getShellPath());
  }

  @Test
  public void shellPath()
  {
    PBXShellScriptBuildPhase phase = new PBXShellScriptBuildPhase(projectFile);
    phase.setShellScript("env > test.txt");
    assertEquals("env > test.txt", phase.getShellScript());
  }
}

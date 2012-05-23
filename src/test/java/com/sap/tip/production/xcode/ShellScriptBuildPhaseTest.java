package com.sap.tip.production.xcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.sap.tip.production.xcode.buildphases.ShellScriptBuildPhase;

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
    ShellScriptBuildPhase phase = new ShellScriptBuildPhase(projectFile);

    assertNull(phase.getIsA());
    assertEquals(0, phase.getFiles().size());
    assertEquals(0, phase.getInputPaths().size());
    assertEquals(0, phase.getOutputPaths().size());
    assertNull(phase.getRunOnlyForDeploymentPostprocessing());
    assertNull(phase.getShellPath());

    phase.setDefaultValues();

    assertEquals(ShellScriptBuildPhase.isa, phase.getIsA());
    assertEquals(0, phase.getFiles().size());
    assertEquals(0, phase.getInputPaths().size());
    assertEquals(0, phase.getOutputPaths().size());
    assertEquals("0", phase.getRunOnlyForDeploymentPostprocessing());
    assertEquals("/bin/sh", phase.getShellPath());
  }

  @Test
  public void shellPath()
  {
    ShellScriptBuildPhase phase = new ShellScriptBuildPhase(projectFile);
    phase.setShellScript("env > test.txt");
    assertEquals("env > test.txt", phase.getShellScript());
  }
}

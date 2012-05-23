package com.sap.tip.production.xcode.buildphases;

import com.sap.tip.production.xcode.BuildFile;
import com.sap.tip.production.xcode.Dict;
import com.sap.tip.production.xcode.ElementFactory;
import com.sap.tip.production.xcode.ProjectFile;
import com.sap.tip.production.xcode.ReferenceArray;

public class ShellScriptBuildPhase extends BuildPhase
{
  public static final String isa = "PBXShellScriptBuildPhase";

  public ShellScriptBuildPhase(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  public ShellScriptBuildPhase(ProjectFile projectFile, Dict dict)
  {
    super(projectFile, dict);
  }

  public void setDefaultValues()
  {
    setString("isa", isa);
    setArray("files", getProjectFile().createArray());
    setArray("inputPaths", getProjectFile().createArray());
    setArray("outputPaths", getProjectFile().createArray());
    setString("runOnlyForDeploymentPostprocessing", "0");
    setString("shellPath", "/bin/sh");
  }

  public ReferenceArray<BuildFile> getFiles()
  {
    return new ReferenceArray<BuildFile>(getProjectFile(), getOrCreateAndSetArray("files"), new BuildFileFactory());
  }

  public ReferenceArray<BuildFile> getInputPaths()
  {
    return new ReferenceArray<BuildFile>(getProjectFile(), getOrCreateAndSetArray("inputPaths"), new BuildFileFactory());
  }

  public ReferenceArray<BuildFile> getOutputPaths()
  {
    return new ReferenceArray<BuildFile>(getProjectFile(), getOrCreateAndSetArray("outputPaths"),
          new BuildFileFactory());
  }

  public String getRunOnlyForDeploymentPostprocessing()
  {
    return getString("runOnlyForDeploymentPostprocessing");
  }

  public String getShellPath()
  {
    return getString("shellPath");
  }

  public String getShellScript()
  {
    return getString("shellScript");
  }

  public void setShellScript(String script)
  {
    setString("shellScript", script);
  }

  private static class BuildFileFactory implements ElementFactory<BuildFile>
  {
    @Override
    public BuildFile create(ProjectFile projectFile, Dict dict)
    {
      return new BuildFile(projectFile, dict);
    }
  }
}

package com.sap.prd.mobile.ios.mios.xcodeprojreader;

public class BuildConfiguration extends NamedElement
{
  public BuildConfiguration(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  BuildConfiguration(ProjectFile projectFile, Dict config)
  {
    super(projectFile, config);
  }

  public BuildSettings getBuildSettings()
  {
    return new BuildSettings(getProjectFile(), getDict("buildSettings"));
  }
}

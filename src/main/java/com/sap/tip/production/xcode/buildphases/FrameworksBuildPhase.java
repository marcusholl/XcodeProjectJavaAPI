package com.sap.tip.production.xcode.buildphases;

import com.sap.tip.production.xcode.Dict;
import com.sap.tip.production.xcode.ProjectFile;

public class FrameworksBuildPhase extends BuildPhase
{
  public static final String isa = "PBXFrameworksBuildPhase";

  public FrameworksBuildPhase(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  FrameworksBuildPhase(ProjectFile projectFile, Dict buildConfigurationList)
  {
    super(projectFile, buildConfigurationList);
  }
}

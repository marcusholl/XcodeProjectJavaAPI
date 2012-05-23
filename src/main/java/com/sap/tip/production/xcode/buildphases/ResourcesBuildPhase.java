package com.sap.tip.production.xcode.buildphases;

import com.sap.tip.production.xcode.Dict;
import com.sap.tip.production.xcode.ProjectFile;

public class ResourcesBuildPhase extends BuildPhase
{
  public static final String isa = "PBXResourcesBuildPhase";

  public ResourcesBuildPhase(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  ResourcesBuildPhase(ProjectFile projectFile, Dict buildConfigurationList)
  {
    super(projectFile, buildConfigurationList);
  }
}

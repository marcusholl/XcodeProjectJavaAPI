package com.sap.tip.production.xcode.buildphases;

import com.sap.tip.production.xcode.Dict;
import com.sap.tip.production.xcode.ProjectFile;

public class HeadersBuildPhase extends BuildPhase
{
  public static final String isa = "PBXHeadersBuildPhase";

  public HeadersBuildPhase(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  HeadersBuildPhase(ProjectFile projectFile, Dict buildConfigurationList)
  {
    super(projectFile, buildConfigurationList);
  }
}

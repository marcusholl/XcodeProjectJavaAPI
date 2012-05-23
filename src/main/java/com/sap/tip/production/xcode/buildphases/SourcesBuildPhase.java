package com.sap.tip.production.xcode.buildphases;

import com.sap.tip.production.xcode.Dict;
import com.sap.tip.production.xcode.ProjectFile;

public class SourcesBuildPhase extends BuildPhase
{
  public static final String isa = "PBXSourcesBuildPhase";

  public SourcesBuildPhase(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  SourcesBuildPhase(ProjectFile projectFile, Dict buildConfigurationList)
  {
    super(projectFile, buildConfigurationList);
  }
}

package com.sap.tip.production.xcode.buildphases;

import com.sap.tip.production.xcode.Dict;
import com.sap.tip.production.xcode.ProjectFile;

public class CopyFilesBuildPhase extends BuildPhase
{
  public static final String isa = "PBXCopyFilesBuildPhase";

  public CopyFilesBuildPhase(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  CopyFilesBuildPhase(ProjectFile projectFile, Dict buildConfigurationList)
  {
    super(projectFile, buildConfigurationList);
  }
}

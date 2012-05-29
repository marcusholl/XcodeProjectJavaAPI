package com.sap.prd.mobile.ios.mios.xcodeprojreader.buildphases;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.Dict;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.ProjectFile;

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

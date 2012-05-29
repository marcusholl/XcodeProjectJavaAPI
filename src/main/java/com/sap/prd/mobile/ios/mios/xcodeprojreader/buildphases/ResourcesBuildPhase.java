package com.sap.prd.mobile.ios.mios.xcodeprojreader.buildphases;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.Dict;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.ProjectFile;

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

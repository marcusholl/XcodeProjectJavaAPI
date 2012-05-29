package com.sap.prd.mobile.ios.mios.xcodeprojreader.buildphases;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.Dict;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.ProjectFile;

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

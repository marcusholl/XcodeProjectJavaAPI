package com.sap.prd.mobile.ios.mios.xcodeprojreader.buildphases;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.Dict;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.ProjectFile;

public class AppleScriptBuildPhase extends BuildPhase
{
  public static final String isa = "PBXAppleScriptBuildPhase"; // unconfirmed

  public AppleScriptBuildPhase(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  AppleScriptBuildPhase(ProjectFile projectFile, Dict buildConfigurationList)
  {
    super(projectFile, buildConfigurationList);
  }
}

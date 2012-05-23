package com.sap.tip.production.xcode.buildphases;

import com.sap.tip.production.xcode.Dict;
import com.sap.tip.production.xcode.ProjectFile;

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

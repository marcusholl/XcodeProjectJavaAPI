package com.sap.prd.mobile.ios.mios.xcodeprojreader.buildphases;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.Dict;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.ProjectFile;

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

package com.sap.prd.mobile.ios.mios.xcodeprojreader.buildphases;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.Dict;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.ProjectFile;

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

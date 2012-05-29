package com.sap.prd.mobile.ios.mios.xcodeprojreader.buildphases;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.Dict;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.Element;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.ProjectFile;

public abstract class BuildPhase extends Element
{
  public BuildPhase(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  public BuildPhase(ProjectFile projectFile, Dict dict)
  {
    super(projectFile, dict);
  }

  public static BuildPhase create(ProjectFile projectFile, Dict dict)
  {
    String isa = dict.getString("isa");
    BuildPhase phase = null;
    if (AppleScriptBuildPhase.isa.equals(isa))
    {
      phase = new AppleScriptBuildPhase(projectFile, dict);
    }
    else if (CopyFilesBuildPhase.isa.equals(isa))
    {
      phase = new CopyFilesBuildPhase(projectFile, dict);
    }
    else if (FrameworksBuildPhase.isa.equals(isa))
    {
      phase = new FrameworksBuildPhase(projectFile, dict);
    }
    else if (HeadersBuildPhase.isa.equals(isa))
    {
      phase = new HeadersBuildPhase(projectFile, dict);
    }
    else if (ResourcesBuildPhase.isa.equals(isa))
    {
      phase = new ResourcesBuildPhase(projectFile, dict);
    }
    else if (ShellScriptBuildPhase.isa.equals(isa))
    {
      phase = new ShellScriptBuildPhase(projectFile, dict);
    }
    else if (SourcesBuildPhase.isa.equals(isa))
    {
      phase = new SourcesBuildPhase(projectFile, dict);
    }
    else
    {
      throw new IllegalStateException("Unknown build phase (isa: " + isa + ")");
    }
    return phase;
  }

}
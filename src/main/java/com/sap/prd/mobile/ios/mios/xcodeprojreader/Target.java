package com.sap.prd.mobile.ios.mios.xcodeprojreader;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.buildphases.BuildPhase;

public class Target extends NamedElement
{
  public Target(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  Target(ProjectFile projectFile, Dict target)
  {
    super(projectFile, target);
  }

  public BuildConfigurationList getBuildConfigurationList()
  {
    String buildConfigurationListRef = getString("buildConfigurationList");
    Dict buildConfigurationList = getProjectFile().getObjectByReference(buildConfigurationListRef);
    return new BuildConfigurationList(getProjectFile(), buildConfigurationList);
  }

  public ReferenceArray<BuildPhase> getBuildPhases()
  {
    return new ReferenceArray<BuildPhase>(getProjectFile(), getOrCreateAndSetArray("buildPhases"),
          new ElementFactory<BuildPhase>() {
            @Override
            public BuildPhase create(ProjectFile projectFile, Dict dict)
            {
              return BuildPhase.create(projectFile, dict);
            }
          });
  }
}

package com.sap.tip.production.xcode;

public class BuildConfigurationList extends Element
{
  public BuildConfigurationList(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  BuildConfigurationList(ProjectFile projectFile, Dict buildConfigurationList)
  {
    super(projectFile, buildConfigurationList);
  }

  public String getDefaultConfigurationName()
  {
    return getString("defaultConfigurationName");
  }

  public ReferenceArray<BuildConfiguration> getBuildConfigurations()
  {
    return new ReferenceArray<BuildConfiguration>(getProjectFile(),
          getOrCreateAndSetArray("buildConfigurations"), new ElementFactory<BuildConfiguration>() {
            @Override
            public BuildConfiguration create(ProjectFile projectFile, Dict dict)
            {
              return new BuildConfiguration(projectFile, dict);
            }
          });
  }
}

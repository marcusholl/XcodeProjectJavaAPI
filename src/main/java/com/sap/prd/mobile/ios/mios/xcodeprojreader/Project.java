package com.sap.prd.mobile.ios.mios.xcodeprojreader;

public class Project extends Element
{
  public Project(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  Project(ProjectFile projectFile, Dict project)
  {
    super(projectFile, project);
  }

  public String getCompatibilityVersion()
  {
    return getString("compatibilityVersion");
  }

  public BuildConfigurationList getBuildConfigurationList()
  {
    String buildConfigurationListRef = getString("buildConfigurationList");
    Dict buildConfigurationList = getProjectFile().getObjectByReference(buildConfigurationListRef);
    return new BuildConfigurationList(getProjectFile(), buildConfigurationList);
  }

  public ReferenceArray<Target> getTargets()
  {
    return new ReferenceArray<Target>(getProjectFile(), getOrCreateAndSetArray("targets"),
          new ElementFactory<Target>() {
            @Override
            public Target create(ProjectFile projectFile, Dict dict)
            {
              return new Target(projectFile, dict);
            }
          });
  }

}

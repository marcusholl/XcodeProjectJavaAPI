package com.sap.tip.production.xcode;

public class BuildFile extends Element
{
  public BuildFile(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  public BuildFile(ProjectFile projectFile, Dict dict)
  {
    super(projectFile, dict);
  }
}

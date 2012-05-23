package com.sap.tip.production.xcode;

public class BuildSettings extends Element
{
  public BuildSettings(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  BuildSettings(ProjectFile projectFile, Dict settings)
  {
    super(projectFile, settings);
  }

  public String getProductName()
  {
    return getString("PRODUCT_NAME");
  }
}

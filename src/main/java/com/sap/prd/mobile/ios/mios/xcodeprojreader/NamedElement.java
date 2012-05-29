package com.sap.prd.mobile.ios.mios.xcodeprojreader;

public abstract class NamedElement extends Element
{
  protected NamedElement(ProjectFile projectFile, Dict dict)
  {
    super(projectFile, dict);
  }

  public String getName()
  {
    return getString("name");
  }

  public void setName(String name)
  {
    setString("name", name);
  }
}

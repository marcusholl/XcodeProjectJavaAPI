package com.sap.tip.production.xcode;

public abstract class Element implements ValueProvider
{
  private final ProjectFile projectFile;
  private final Dict dict;

  protected Element(ProjectFile projectFile, Dict dict)
  {
    this.projectFile = projectFile;
    this.dict = dict;
  }

  protected ProjectFile getProjectFile()
  {
    return projectFile;
  }

  public Dict getDict()
  {
    return dict;
  }

  @Override
  public String getString(String key)
  {
    return dict.getString(key);
  }

  @Override
  public void setString(String key, String value)
  {
    dict.setString(key, value);
  }

  @Override
  public Array getArray(String key)
  {
    return dict.getArray(key);
  }

  @Override
  public Array getOrCreateAndSetArray(String key)
  {
    return dict.getOrCreateAndSetArray(key);
  }

  @Override
  public void setArray(String key, Array value)
  {
    dict.setArray(key, value);
  }

  @Override
  public Dict getDict(String key)
  {
    return dict.getDict(key);
  }

  @Override
  public Dict getOrCreateAndSetDict(String key)
  {
    return dict.getOrCreateAndSetDict(key);
  }

  @Override
  public void setDict(String key, Dict value)
  {
    dict.setDict(key, value);
  }

  public String getIsA()
  {
    return getString("isa");
  }
}

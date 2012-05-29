/*
 * #%L
 * xcode-project-reader
 * %%
 * Copyright (C) 2012 SAP AG
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.sap.prd.mobile.ios.mios.xcodeprojreader;

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

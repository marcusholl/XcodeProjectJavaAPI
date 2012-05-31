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
package com.sap.prd.mobile.ios.mios.xcodeprojreader.jaxb;

import java.util.LinkedHashMap;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.Array;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.Dict;

class LinkedHashMapDict extends LinkedHashMap<String, Object> implements Dict
{
  private static final long serialVersionUID = 6861596829305840360L;

  @Override
  public String getString(String key)
  {
    return (String) get(key);
  }

  @Override
  public void setString(String key, String value)
  {
    put(key, value);
  }

  @Override
  public Integer getInteger(String key)
  {
    return (Integer) get(key);
  }

  @Override
  public void setInteger(String key, Integer value)
  {
    put(key, value);
  }

  @Override
  public Double getDouble(String key)
  {
    return (Double) get(key);
  }

  @Override
  public void setDouble(String key, Double value)
  {
    put(key, value);
  }

  @Override
  public Boolean getBool(String key)
  {
    return (Boolean) get(key);
  }

  @Override
  public void setBool(String key, Boolean value)
  {
    put(key, value);
  }

  @Override
  public Array getArray(String key)
  {
    return (Array) get(key);
  }

  @Override
  public Array getOrCreateAndSetArray(String key)
  {
    Array array = getArray(key);
    if (array == null)
    {
      array = new JAXBPlist().createArray();
      setArray(key, array);
    }
    return array;
  }

  @Override
  public void setArray(String key, Array value)
  {
    put(key, value);
  }

  @Override
  public Dict getDict(String key)
  {
    return (Dict) get(key);
  }

  @Override
  public Dict getOrCreateAndSetDict(String key)
  {
    Dict dict = getDict(key);
    if (dict == null)
    {
      dict = new JAXBPlist().createDict();
      setDict(key, dict);
    }
    return dict;
  }

  @Override
  public void setDict(String key, Dict value)
  {
    put(key, value);
  }
}

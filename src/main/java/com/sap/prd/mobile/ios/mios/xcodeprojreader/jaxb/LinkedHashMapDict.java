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

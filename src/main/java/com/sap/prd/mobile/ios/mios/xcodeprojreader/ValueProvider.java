package com.sap.prd.mobile.ios.mios.xcodeprojreader;

public interface ValueProvider
{
  String getString(String key);

  void setString(String key, String value);

  Array getArray(String key);

  Array getOrCreateAndSetArray(String key);

  void setArray(String key, Array value);

  Dict getDict(String key);

  Dict getOrCreateAndSetDict(String key);

  void setDict(String key, Dict value);
}

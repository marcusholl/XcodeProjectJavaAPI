package com.sap.prd.mobile.ios.mios.xcodeprojreader;

public interface Plist
{
  String getVersion();

  void setVersion(String value);

  Dict getDict();

  Array createArray();

  Dict createDict();
}
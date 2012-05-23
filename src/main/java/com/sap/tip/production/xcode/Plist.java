package com.sap.tip.production.xcode;

public interface Plist
{
  String getVersion();

  void setVersion(String value);

  Dict getDict();

  Array createArray();

  Dict createDict();
}
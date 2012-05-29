package com.sap.prd.mobile.ios.mios.xcodeprojreader;

public interface ElementFactory<T extends Element>
{
  T create(ProjectFile projectFile, Dict dict);
}

package com.sap.tip.production.xcode;

public interface ElementFactory<T extends Element>
{
  T create(ProjectFile projectFile, Dict dict);
}

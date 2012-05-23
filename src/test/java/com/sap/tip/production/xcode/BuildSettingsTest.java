package com.sap.tip.production.xcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BuildSettingsTest
{
  @Test
  public void productName() throws Exception
  {
    String productName = ProjectFileTest.load().getProject().getTargets().get(0).getBuildConfigurationList()
      .getBuildConfigurations().getByName("Release")
      .getBuildSettings().getProductName();
    assertEquals("$(TARGET_NAME)", productName);
  }
}

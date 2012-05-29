package com.sap.prd.mobile.ios.mios.xcodeprojreader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.BuildConfiguration;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.BuildConfigurationList;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.ReferenceArray;

public class BuildConfigurationListTest
{
  private BuildConfigurationList configList;

  @Before
  public void before() throws Exception
  {
    configList = ProjectFileTest.load().getProject().getBuildConfigurationList();
  }

  @Test
  public void empty() throws Exception
  {
    BuildConfigurationList configList = new BuildConfigurationList(ProjectFileTest.load());
    assertEquals(0, configList.getBuildConfigurations().size());
  }

  @Test
  public void buildConfigurationList()
  {
    assertEquals("Release", configList.getDefaultConfigurationName());
  }

  @Test
  public void buildConfigurations()
  {
    ReferenceArray<BuildConfiguration> configs = configList.getBuildConfigurations();
    assertEquals(2, configs.size());
    assertEquals("Debug", configs.get(0).getName());
    assertEquals("Release", configs.get(1).getName());
  }

  @Test
  public void buildConfigurationDebug()
  {
    BuildConfiguration conf = configList.getBuildConfigurations().getByName("Debug");
    assertEquals("Debug", conf.getName());
  }

  @Test
  public void buildConfigurationRelease()
  {
    BuildConfiguration conf = configList.getBuildConfigurations().getByName("Release");
    assertEquals("Release", conf.getName());
  }

  @Test
  public void buildConfigurationProductName()
  {
    BuildConfiguration conf = configList.getBuildConfigurations().getByName("Release");
    assertNull("PRODUCT_NAME is set on Targets", conf.getBuildSettings().getProductName());
  }

  @Test
  public void buildConfigurationNotFound()
  {
    BuildConfiguration conf = configList.getBuildConfigurations().getByName("Foo");
    assertNull(conf);
  }

}

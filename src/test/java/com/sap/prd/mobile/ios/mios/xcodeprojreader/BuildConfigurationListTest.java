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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

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

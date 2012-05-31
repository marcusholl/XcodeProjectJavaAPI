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

import org.junit.Before;
import org.junit.Test;

public class ProjectTest
{
  private Project project;

  @Before
  public void before() throws Exception
  {
    project = ProjectFileTest.load().getProject();
  }

  @Test
  public void empty() throws Exception
  {
    Project project = new Project(ProjectFileTest.load());
    assertEquals(0, project.getTargets().size());
  }

  @Test
  public void targets() throws Exception
  {
    ReferenceArray<Target> targets = project.getTargets();
    assertEquals(1, targets.size());
    Target target1 = targets.get(0);
    assertEquals("MyTest", target1.getName());
    assertEquals("com.apple.product-type.application", target1.getDict().getString("productType"));
  }

  @Test
  public void targetWithName()
  {
    Target target = project.getTargets().getByName("MyTest");
    assertEquals("MyTest", target.getName());
  }

  @Test
  public void compatibilityVersion()
  {
    assertEquals("Xcode 3.2", project.getCompatibilityVersion());
  }
}

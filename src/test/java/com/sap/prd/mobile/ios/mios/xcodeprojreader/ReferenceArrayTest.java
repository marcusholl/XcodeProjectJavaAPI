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

public class ReferenceArrayTest
{
  private ProjectFile projectFile;
  private ReferenceArray<Target> refsArray;

  @Before
  public void before() throws Exception
  {
    projectFile = ProjectFileTest.load();
    Array refs = projectFile.createArray();
    refs.add("83FC274415580501000A0343");
    refsArray = new ReferenceArray<Target>(projectFile, refs, new ElementFactory<Target>() {
      @Override
      public Target create(ProjectFile projectFile, Dict dict)
      {
        return new Target(projectFile, dict);
      }
    });
  }

  @Test
  public void Get()
  {
    assertEquals(1, refsArray.size());
    assertEquals("PBXNativeTarget", refsArray.get(0).getIsA());
    assertEquals("com.apple.product-type.application", refsArray.getByName("MyTest").getString("productType"));
  }

  @Test
  public void Add()
  {
    Target target2 = new Target(projectFile);
    target2.setName("target2");
    target2.setString("KEY", "VALUE");
    refsArray.add(target2);

    assertEquals(2, refsArray.size());
    assertEquals("VALUE", refsArray.get(1).getString("KEY"));
    assertEquals("VALUE", refsArray.getByName("target2").getString("KEY"));
  }
}

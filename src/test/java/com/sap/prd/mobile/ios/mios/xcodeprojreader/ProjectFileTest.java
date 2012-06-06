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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.jaxb.JAXBPlistParser;

public class ProjectFileTest
{
  private ProjectFile projectFile;

  @Before
  public void before() throws Exception
  {
    projectFile = load();
  }

  static ProjectFile load() throws Exception
  {
    final String fileName = "src/test/resources/project.pbxproj.xml";
    JAXBPlistParser parser = new JAXBPlistParser();
    Plist plist = parser.load(fileName);
    return new ProjectFile(plist);
  }

  @Test
  public void plist() throws Exception
  {
    final String fileName = "src/test/resources/project.pbxproj.xml";
    JAXBPlistParser parser = new JAXBPlistParser();
    Plist plist = parser.load(fileName);
    assertSame(plist, new ProjectFile(plist).getPlist());
  }

  @Test
  public void version()
  {
    assertEquals("1.0", projectFile.getVersion());
  }

  @Test
  public void objectVersion() throws Exception
  {
    assertEquals("46", projectFile.getObjectVersion());
  }

  @Test
  public void rootObject()
  {
    assertEquals("83FC273C15580501000A0343", projectFile.getDict().getString("rootObject"));
  }

  @Test
  public void generateReference()
  {
    assertFalse(projectFile.generateReference().equals(projectFile.generateReference()));
    assertFalse(projectFile.generateReference().equals(projectFile.generateReference()));
  }
}

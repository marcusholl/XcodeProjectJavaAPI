package com.sap.tip.production.xcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.sap.tip.production.xcode.jaxb.JAXBPlistParser;

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
    assertEquals("83FC273C15580501000A0343", projectFile.getString("rootObject"));
  }

  @Test
  public void generateReference()
  {
    assertFalse(projectFile.generateReference().equals(projectFile.generateReference()));
    assertFalse(projectFile.generateReference().equals(projectFile.generateReference()));
  }
}

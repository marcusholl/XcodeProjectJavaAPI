package com.sap.prd.mobile.ios.mios.xcodeprojreader;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.Project;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.ReferenceArray;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.Target;

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
    assertEquals("com.apple.product-type.application", target1.getString("productType"));
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

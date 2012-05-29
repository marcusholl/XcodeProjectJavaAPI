package com.sap.prd.mobile.ios.mios.xcodeprojreader;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.Array;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.Dict;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.ElementFactory;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.ProjectFile;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.ReferenceArray;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.Target;

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

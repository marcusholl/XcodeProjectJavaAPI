package com.sap.prd.mobile.ios.mios.xcodeprojreader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.ReferenceArray;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.Target;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.buildphases.BuildPhase;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.buildphases.FrameworksBuildPhase;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.buildphases.ResourcesBuildPhase;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.buildphases.SourcesBuildPhase;

public class TargetTest
{
  private Target target;

  @Before
  public void before() throws Exception
  {
    target = ProjectFileTest.load().getProject().getTargets().get(0);
  }

  @Test
  public void buildConfigurationList()
  {
    assertNotNull(target.getBuildConfigurationList());
  }

  @Test
  public void buildPhases()
  {
    ReferenceArray<BuildPhase> buildPhases = target.getBuildPhases();
    assertEquals(3, buildPhases.size());
    assertEquals(SourcesBuildPhase.isa, buildPhases.get(0).getIsA());
    assertEquals(FrameworksBuildPhase.isa, buildPhases.get(1).getIsA());
    assertEquals(ResourcesBuildPhase.isa, buildPhases.get(2).getIsA());
  }
}

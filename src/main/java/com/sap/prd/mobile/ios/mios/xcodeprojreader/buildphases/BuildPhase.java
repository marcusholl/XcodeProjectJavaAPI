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
package com.sap.prd.mobile.ios.mios.xcodeprojreader.buildphases;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.Dict;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.Element;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.ProjectFile;

public abstract class BuildPhase extends Element
{
  public BuildPhase(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  public BuildPhase(ProjectFile projectFile, Dict dict)
  {
    super(projectFile, dict);
  }

  public static BuildPhase create(ProjectFile projectFile, Dict dict)
  {
    String isa = dict.getString("isa");
    BuildPhase phase = null;
    if (AppleScriptBuildPhase.isa.equals(isa))
    {
      phase = new AppleScriptBuildPhase(projectFile, dict);
    }
    else if (CopyFilesBuildPhase.isa.equals(isa))
    {
      phase = new CopyFilesBuildPhase(projectFile, dict);
    }
    else if (FrameworksBuildPhase.isa.equals(isa))
    {
      phase = new FrameworksBuildPhase(projectFile, dict);
    }
    else if (HeadersBuildPhase.isa.equals(isa))
    {
      phase = new HeadersBuildPhase(projectFile, dict);
    }
    else if (ResourcesBuildPhase.isa.equals(isa))
    {
      phase = new ResourcesBuildPhase(projectFile, dict);
    }
    else if (ShellScriptBuildPhase.isa.equals(isa))
    {
      phase = new ShellScriptBuildPhase(projectFile, dict);
    }
    else if (SourcesBuildPhase.isa.equals(isa))
    {
      phase = new SourcesBuildPhase(projectFile, dict);
    }
    else
    {
      throw new IllegalStateException("Unknown build phase (isa: " + isa + ")");
    }
    return phase;
  }

}
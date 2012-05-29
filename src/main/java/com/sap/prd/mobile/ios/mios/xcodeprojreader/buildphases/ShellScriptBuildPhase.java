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

import com.sap.prd.mobile.ios.mios.xcodeprojreader.BuildFile;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.Dict;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.ElementFactory;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.ProjectFile;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.ReferenceArray;

public class ShellScriptBuildPhase extends BuildPhase
{
  public static final String isa = "PBXShellScriptBuildPhase";

  public ShellScriptBuildPhase(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  public ShellScriptBuildPhase(ProjectFile projectFile, Dict dict)
  {
    super(projectFile, dict);
  }

  public void setDefaultValues()
  {
    setString("isa", isa);
    setArray("files", getProjectFile().createArray());
    setArray("inputPaths", getProjectFile().createArray());
    setArray("outputPaths", getProjectFile().createArray());
    setString("runOnlyForDeploymentPostprocessing", "0");
    setString("shellPath", "/bin/sh");
  }

  public ReferenceArray<BuildFile> getFiles()
  {
    return new ReferenceArray<BuildFile>(getProjectFile(), getOrCreateAndSetArray("files"), new BuildFileFactory());
  }

  public ReferenceArray<BuildFile> getInputPaths()
  {
    return new ReferenceArray<BuildFile>(getProjectFile(), getOrCreateAndSetArray("inputPaths"), new BuildFileFactory());
  }

  public ReferenceArray<BuildFile> getOutputPaths()
  {
    return new ReferenceArray<BuildFile>(getProjectFile(), getOrCreateAndSetArray("outputPaths"),
          new BuildFileFactory());
  }

  public String getRunOnlyForDeploymentPostprocessing()
  {
    return getString("runOnlyForDeploymentPostprocessing");
  }

  public String getShellPath()
  {
    return getString("shellPath");
  }

  public String getShellScript()
  {
    return getString("shellScript");
  }

  public void setShellScript(String script)
  {
    setString("shellScript", script);
  }

  private static class BuildFileFactory implements ElementFactory<BuildFile>
  {
    @Override
    public BuildFile create(ProjectFile projectFile, Dict dict)
    {
      return new BuildFile(projectFile, dict);
    }
  }
}

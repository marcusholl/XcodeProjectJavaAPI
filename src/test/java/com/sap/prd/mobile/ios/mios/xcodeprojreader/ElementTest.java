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
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class ElementTest
{
  private static class MyElement extends Element
  {
    protected MyElement(ProjectFile projectFile, Dict dict)
    {
      super(projectFile, dict);
    }
  }

  private ProjectFile projectFile;
  private MyElement element;

  @Before
  public void before() throws Exception
  {
    projectFile = ProjectFileTest.load();
    Dict root = projectFile.createDict();

    root.put("name", "MyElement");

    Dict dict1 = projectFile.createDict();
    dict1.put("hello", "world");
    root.put("dict", dict1);

    Array array = projectFile.createArray();
    array.add("String");
    Dict dict2 = projectFile.createDict();
    dict2.put("time", "now");
    array.add(dict2);
    root.put("array", array);

    element = new MyElement(projectFile, root);
  }

  @Test
  public void getString()
  {
    assertEquals("MyElement", element.getString("name"));
  }

  @Test
  public void setString()
  {
    element.setString("name", "MyElement2");
    assertEquals("MyElement2", element.getString("name"));
  }

  @Test
  public void getArray()
  {
    Array array = element.getArray("array");
    assertEquals(2, array.size());
    assertEquals("String", array.get(0));
    Dict dict = (Dict) array.get(1);
    assertEquals("now", dict.getString("time"));
  }

  @Test
  public void getArrayNonExistingKey()
  {
    assertNull(element.getArray("foo"));
  }

  @Test
  public void getOrCreateAndSetArray()
  {
    Array array = element.getOrCreateAndSetArray("array");
    assertEquals(2, array.size());
    assertEquals("String", array.get(0));
    Dict dict = (Dict) array.get(1);
    assertEquals("now", dict.getString("time"));
  }

  @Test
  public void getOrCreateAndSetArrayNonExistingKey()
  {
    Array array = element.getOrCreateAndSetArray("foo");
    assertEquals(0, array.size());
  }

  @Test
  public void setArray()
  {
    Array array = projectFile.createArray();
    element.setArray("foo", array);
    assertSame(array, element.getArray("foo"));
  }

  @Test
  public void getDict()
  {
    Dict dict = element.getDict("dict");
    assertEquals("world", dict.getString("hello"));
  }

  @Test
  public void getDictNonExistingKey()
  {
    assertNull(element.getDict("foo"));
  }

  @Test
  public void getOrCreateAndSetDict()
  {
    Dict dict = element.getDict("dict");
    assertEquals("world", dict.getString("hello"));
  }

  @Test
  public void getOrCreateAndSetDictNonExistingKey()
  {
    Dict dict = element.getOrCreateAndSetDict("foo");
    assertEquals(0, dict.size());
  }

  @Test
  public void setDict()
  {
    Dict dict = projectFile.createDict();
    element.setDict("foo", dict);
    assertSame(dict, element.getDict("foo"));
  }

}

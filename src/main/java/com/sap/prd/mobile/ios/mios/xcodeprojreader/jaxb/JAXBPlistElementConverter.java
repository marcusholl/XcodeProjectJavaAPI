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
package com.sap.prd.mobile.ios.mios.xcodeprojreader.jaxb;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.Array;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.Dict;

public class JAXBPlistElementConverter
{
  private final JAXBDictAdapter dictAdapter;
  private final JAXBArrayAdapter arrayAdapter;

  public JAXBPlistElementConverter(JAXBDictAdapter dictAdapter, JAXBArrayAdapter arrayAdapter)
  {
    this.dictAdapter = dictAdapter;
    this.arrayAdapter = arrayAdapter;
  }

  public Object convertFromJAXB(Object value) throws Exception
  {
    if (value instanceof JAXBDict)
    {
      value = dictAdapter.unmarshal((JAXBDict) value);
    }
    else if (value instanceof JAXBArray)
    {
      value = arrayAdapter.unmarshal((JAXBArray) value);
    }
    else if (value instanceof JAXBTrue)
    {
      value = Boolean.TRUE;
    }
    else if (value instanceof JAXBFalse)
    {
      value = Boolean.FALSE;
    }
    return value;
  }

  public Object convertToJAXB(Object value) throws Exception
  {
    if (value instanceof Dict)
    {
      value = dictAdapter.marshal((Dict) value);
    }
    else if (value instanceof Array)
    {
      value = arrayAdapter.marshal((Array) value);
    }
    else if (value instanceof Boolean)
    {
      value = ((Boolean) value) ? new JAXBTrue() : new JAXBFalse();
    }
    return value;
  }
}

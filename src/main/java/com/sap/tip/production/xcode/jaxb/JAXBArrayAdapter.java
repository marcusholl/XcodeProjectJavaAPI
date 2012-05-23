package com.sap.tip.production.xcode.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.sap.tip.production.xcode.Array;
import com.sap.tip.production.xcode.Dict;

public class JAXBArrayAdapter extends XmlAdapter<JAXBArray, Array>
{
  @Override
  public JAXBArray marshal(Array array) throws Exception
  {
    JAXBArray jaxbArray = new JAXBArray();
    Array elements = new JAXBPlist().createArray();
    for (Object value : array)
    {
      if (value instanceof Dict)
      {
        value = new JAXBDictAdapter().marshal((Dict) value);
      }
      else if (value instanceof Array)
      {
        value = marshal((Array) value);
      }
      elements.add(value);
    }
    jaxbArray.setElements(elements);
    return jaxbArray;
  }

  @Override
  public Array unmarshal(JAXBArray jaxbArray) throws Exception
  {
    Array array = new JAXBPlist().createArray();
    for (Object value : jaxbArray.getElements())
    {
      if (value instanceof JAXBDict)
      {
        value = new JAXBDictAdapter().unmarshal((JAXBDict) value);
      }
      else if (value instanceof JAXBArray)
      {
        value = unmarshal((JAXBArray) value);
      }
      array.add(value);
    }
    return array;
  }
}
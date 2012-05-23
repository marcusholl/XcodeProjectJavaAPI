package com.sap.tip.production.xcode.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sap.tip.production.xcode.Array;

@XmlRootElement(name = "array")
@XmlJavaTypeAdapter(JAXBArrayAdapter.class)
public class JAXBArray
{

  private Array elements = new JAXBPlist().createArray();

  @XmlElements({
      @XmlElement(name = "string", type = String.class),
      @XmlElement(name = "dict", type = JAXBDict.class),
      @XmlElement(name = "array", type = JAXBArray.class)
  })
  public Array getElements()
  {
    return elements;
  }

  void setElements(Array elements)
  {
    this.elements = elements;
  }

}

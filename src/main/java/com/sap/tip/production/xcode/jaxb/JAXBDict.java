package com.sap.tip.production.xcode.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import com.sap.tip.production.xcode.Array;

@XmlRootElement(name = "dict")
public class JAXBDict
{

  private Array elements = new JAXBPlist().createArray();

  @XmlElements({
      @XmlElement(name = "key", type = JAXBKey.class),
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

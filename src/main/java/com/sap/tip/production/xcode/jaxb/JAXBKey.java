package com.sap.tip.production.xcode.jaxb;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "key")
public class JAXBKey
{
  private String value;

  @XmlValue
  public String getValue()
  {
    return value;
  }

  void setValue(String value)
  {
    this.value = value;
  }
}

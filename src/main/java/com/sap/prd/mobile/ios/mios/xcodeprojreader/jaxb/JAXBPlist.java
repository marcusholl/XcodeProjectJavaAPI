package com.sap.prd.mobile.ios.mios.xcodeprojreader.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.Array;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.Dict;
import com.sap.prd.mobile.ios.mios.xcodeprojreader.Plist;

@XmlRootElement(name = "plist")
public class JAXBPlist implements Plist
{
  private String version;
  private Dict dict;

  @Override
  @XmlAttribute
  public String getVersion()
  {
    return version;
  }

  @Override
  public void setVersion(String value)
  {
    this.version = value;
  }

  @Override
  @XmlElement(name = "dict", required = true)
  @XmlJavaTypeAdapter(JAXBDictAdapter.class)
  public Dict getDict()
  {
    return dict;
  }

  void setDict(Dict dict)
  {
    this.dict = dict;
  }

  @Override
  public Array createArray()
  {
    return new ArrayListArray();
  }

  @Override
  public Dict createDict()
  {
    return new LinkedHashMapDict();
  }
}

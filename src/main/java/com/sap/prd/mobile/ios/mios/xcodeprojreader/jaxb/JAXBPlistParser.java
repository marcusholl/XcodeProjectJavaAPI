package com.sap.prd.mobile.ios.mios.xcodeprojreader.jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.sap.prd.mobile.ios.mios.xcodeprojreader.Plist;

// TODO unsupported element types: Date, Data, Integer, Real
public class JAXBPlistParser
{
  public Plist load(String projectFile) throws SAXException, ParserConfigurationException, FileNotFoundException,
        JAXBException
  {
    InputSource project = new InputSource(new FileReader(projectFile));
    return unmarshallPlist(project);
  }

  public Plist load(InputSource project) throws SAXException, ParserConfigurationException,
        JAXBException
  {
    return unmarshallPlist(project);
  }

  private Plist unmarshallPlist(InputSource project) throws SAXException,
        ParserConfigurationException,
        JAXBException
  {
    InputSource dtd = new InputSource(this.getClass().getResourceAsStream("/PropertyList-1.0.dtd"));
    SAXSource ss = createSAXSource(project, dtd);
    JAXBContext ctx = JAXBContext.newInstance(com.sap.prd.mobile.ios.mios.xcodeprojreader.jaxb.JAXBPlist.class);
    Unmarshaller unmarshaller = ctx.createUnmarshaller();

    // unexpected elements should cause an error
    unmarshaller.setEventHandler(new ValidationEventHandler() {
      @Override
      public boolean handleEvent(ValidationEvent event)
      {
        return false;
      }
    });

    return (Plist) unmarshaller.unmarshal(ss);
  }

  private SAXSource createSAXSource(InputSource project, final InputSource dtd) throws SAXException,
        ParserConfigurationException
  {
    XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
    xmlReader.setEntityResolver(new EntityResolver() {
      @Override
      public InputSource resolveEntity(String pid, String sid) throws SAXException
      {
        if (sid.equals("http://www.apple.com/DTDs/PropertyList-1.0.dtd"))
          return dtd;
        throw new SAXException("unable to resolve remote entity, sid = " + sid);
      }
    });
    SAXSource ss = new SAXSource(xmlReader, project);
    return ss;
  }

  public void save(Plist plist, String fileName) throws JAXBException
  {
    marshallPlist(plist, fileName);
  }

  private void marshallPlist(Plist plist, String projectFile) throws JAXBException
  {
    JAXBContext ctx = JAXBContext.newInstance(com.sap.prd.mobile.ios.mios.xcodeprojreader.jaxb.JAXBPlist.class);
    Marshaller marshaller = ctx.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller
      .setProperty(
            "com.sun.xml.internal.bind.xmlHeaders",
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">");
    marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
    marshaller.marshal(plist, new File(projectFile));
  }

  public void convert(String projectFile, File destinationProjectFile) throws IOException
  {
    Process exec = Runtime.getRuntime().exec(
          new String[] { "plutil", "-convert", "xml1", "-o", destinationProjectFile.getAbsolutePath(), projectFile });
    try
    {
      exec.waitFor();
    }
    catch (InterruptedException e)
    {
    }

    if (exec.exitValue() != 0)
    {
      throw new RuntimeException("Could not convert file (Exit Code: " + exec.exitValue() + ")");
    }
  }
}

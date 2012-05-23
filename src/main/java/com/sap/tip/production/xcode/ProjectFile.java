package com.sap.tip.production.xcode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Hex;

public class ProjectFile extends Element
{
  private final Plist plist;

  public ProjectFile(Plist plist)
  {
    super(null, plist.getDict());
    this.plist = plist;
  }

  public Array createArray()
  {
    return plist.createArray();
  }

  public Dict createDict()
  {
    return plist.createDict();
  }

  public String getVersion()
  {
    return plist.getVersion();
  }

  public String getObjectVersion()
  {
    return getString("objectVersion");
  }

  public Dict getObjectByReference(String reference)
  {
    return (Dict) getObjects().get(reference);
  }

  public void setObjectByReference(String reference, Dict object)
  {
    getObjects().put(reference, object);
  }

  public String generateReference()
  {
    MessageDigest md = null;
    SecureRandom prng = null;
    try
    {
      md = MessageDigest.getInstance("SHA1");
      prng = SecureRandom.getInstance("SHA1PRNG");
    }
    catch (NoSuchAlgorithmException e)
    {
    }

    String randomNum = new Integer(prng.nextInt()).toString();
    String ref = new String(Hex.encodeHex(md.digest(randomNum.getBytes())));
    return ref.toUpperCase().substring(0, 24);
  }

  private Dict getObjects()
  {
    return getDict("objects");
  }

  public Project getProject()
  {
    String projectRef = getString("rootObject");
    Dict project = getObjectByReference(projectRef);
    return new Project(this, project);
  }
}

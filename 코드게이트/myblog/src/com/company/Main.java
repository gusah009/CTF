package com.company;

import java.io.File;
import java.security.NoSuchAlgorithmException;

public class Main {

  public static void main(String[] args) throws NoSuchAlgorithmException {
    String tmpDir = System.getProperty("java.io.tmpdir") + "/db/";
    // write your code here
    System.out.println(System.getProperty("java.io.tmpdir"));
    File userArticle = new File(tmpDir + "/article/", "_" + ".xml");
    System.out.println(userArticle.getAbsolutePath());
//    XPath xpath = XPathFactory.newInstance().newXPath();
//    xpath.evaluate("//article[@idx='" + idx + "']/title/text()", document, XPathConstants.STRING))
  }
}

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) throws IOException {
    // write your code here
    String tmpUrl = "3.39.72.134/memo/login/";
    String[] tmpArr = tmpUrl.split("\\/");
    System.out.println(Arrays.toString(tmpArr));
    System.out.println("login".hashCode());
    System.out.println("write".hashCode());

    String memo = "[url:file:/]";
    Pattern pattern = Pattern.compile("(\\[[^\\]]+\\])");
    Matcher matcher = pattern.matcher(memo);
    String img = "";
    if (!matcher.find()) {
      System.out.println("Wrong!");
    } else {
      System.out.println("Success!");
      img = matcher.group();
      String tmp = img.substring(1, img.length() - 1);
      System.out.println("tmp: " + tmp);

      pattern = Pattern.compile("^[a-z]+:");
      matcher = pattern.matcher(tmp);

//      System.out.println(matcher.find());
//      System.out.println(matcher.group());
      if (matcher.find() && !matcher.group().startsWith("file")) {
        System.out.println("!!!!!!!!!!!!!");
        System.out.println("Success!");
        String urlContent = "";
        URL url = new URL(tmp);
        System.out.println(url.toString());
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine = "";

        while (true) {
          if ((inputLine = in.readLine()) == null) {
            in.close();
            break;
          }

          urlContent = urlContent + inputLine + "\n";
          System.out.println(urlContent);
        }
      } else {
        System.out.println("Wrong!");
//        System.out.println(matcher.group().startsWith("file"));
      }
    }
  }
}

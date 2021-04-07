package com.app.core.misc.util;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class StringUtil {
  public static String[] splitByCamelCase(String str) {
    if (str == null) {
      return null;
    }

    int len = str.length();
    if (len == 0) {
      return ArrayUtils.EMPTY_STRING_ARRAY;
    }

    List<String> substrings = new ArrayList<String>();
    int start = 0;
    int counter = 0;

    for (counter = 0; counter < len; counter++) {
      char ch = str.charAt(counter);
      if (counter != 0 && ch >= 'A' && ch <= 'Z') {
        substrings.add(str.substring(start, counter));
        start = counter;
      } else if (counter == len - 1) {
        substrings.add(str.substring(start, counter + 1));
      }
    }
    return (String[]) substrings.toArray(new String[substrings.size()]);
  }

  public static String convertCamelWordsToSentence(String string) {
    String[] words = splitByCamelCase(string);
    String sentence = StringUtils.join(words, ' ');
    return sentence.toLowerCase();
  }

  public static String convertCamelCaseToSnakeCase(String string) {
    String[] words = splitByCamelCase(string);
    String sentence = StringUtils.join(words, '_');
    return sentence.toLowerCase();
  }

  public static String interpolate(String templateString) {
    String currentResult = templateString;
    String previousResult = null;

    while (!StringUtils.equals(currentResult, previousResult)) {
      previousResult = currentResult;

      int i = currentResult.indexOf("${");
      if (i > -1) {
        int j = currentResult.indexOf("}");
        if (j > i) {
          String valueToBeSubstituted = currentResult.substring(i, j + 1);
          String propertyName = currentResult.substring(i + 2, j);
          currentResult = StringUtils.replace(currentResult, valueToBeSubstituted, System.getProperty(propertyName));
        }
      }
    }

    return currentResult;
  }

  public static String interpolate(String templateString, Map<String, String> properties) {
    String currentResult = templateString;
    String previousResult = null;

    while (!StringUtils.equals(currentResult, previousResult)) {
      previousResult = currentResult;

      int i = currentResult.indexOf("${");
      if (i > -1) {
        int j = currentResult.indexOf("}");
        if (j > i) {
          String valueToBeSubstituted = currentResult.substring(i, j + 1);
          String propertyName = currentResult.substring(i + 2, j);
          currentResult = StringUtils.replace(currentResult, valueToBeSubstituted,
              (String) properties.get(propertyName));
        }
      }
    }

    return currentResult;
  }

  public static boolean isInteger(String s) {
    try {
      Integer.parseInt(s);
      return true;
    } catch (Exception e) {
      System.out.println("Exception occured in parsing string '" + s + "' to integer  : " + e.getMessage());

      return false;
    }
  }

  public static boolean isFloat(String s) {
    try {
      Float.parseFloat(s);
      return true;
    } catch (Exception e) {

      System.out.println("Exception occured in parsing string '" + s + "' to float: " + e.getMessage());

      return false;
    }
  }

  public static boolean isDate(String s) {
    try {
      DateFormat.getDateInstance().parse(s);
      return true;
    } catch (Exception e) {
      System.out.println("Exception occured in parsing string '" + s + "' to date: " + e.getMessage());
      return false;
    }
  }

  public static boolean isInList(String target, String list) {
    String separator = "::";
    if (list.indexOf(separator) <= 0) {
      separator = ",";
    }
    String[] subStrings = StringUtils.split(list, separator);
    for (String s : subStrings) {
      if (s.trim().equalsIgnoreCase(target)) {
        return true;
      }
    }
    return false;
  }

  public static boolean contains(String s1, String s2) {
    return StringUtils.contains(s1, s2);
  }

  public static boolean equals(String s1, String s2) {
    if (s1 == null && s2 != null) {
      return false;
    }
    if (s1 != null && s2 == null) {
      return false;
    }
    return ((s1 == null && s2 == null) || (s1 != null && s2 != null && s1.equals(s2)));
  }

  public static boolean equalsIgnoreCase(String s1, String s2) {
    if (s1 == null && s2 != null) {
      return false;
    }
    if (s1 != null && s2 == null) {
      return false;
    }
    return ((s1 == null && s2 == null) || (s1 != null && s2 != null && s1.equalsIgnoreCase(s2)));
  }

  public static String capitalizeFirstLetter(String str) {
    if (StringUtils.isNotEmpty(str)) {
      return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    return str;
  }

  public static List<String> split(String value, int maxLength) {
    List<String> values = null;
    if (StringUtils.isNotBlank(value) && maxLength > 0) {
      values = new ArrayList<String>();
      String originalValue = value;
      while (originalValue.length() > 0) {
        String subString = StringUtils.substring(originalValue, 0, maxLength);
        originalValue = StringUtils.substring(originalValue, subString.length(), originalValue.length());
        values.add(subString);
      }
    }
    return values;
  }
}

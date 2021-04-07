package com.app.core.calendar.util;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class XMLGregorianCalendarUtils {

  private static DatatypeFactory dataTypeFactory = null;

  static {
    try {
      dataTypeFactory = DatatypeFactory.newInstance();
    } catch (DatatypeConfigurationException e) {
      System.out.println(e.getMessage() + e);
    }
  }

  public static XMLGregorianCalendar getCurrentTimestamp() {
    GregorianCalendar gcal = new GregorianCalendar();
    return dataTypeFactory.newXMLGregorianCalendar(gcal);
  }

  public static XMLGregorianCalendar fromGregorianCalendar(GregorianCalendar gcal) {
    return dataTypeFactory.newXMLGregorianCalendar(gcal);
  }

  public static XMLGregorianCalendar fromCalendar(Calendar cal) {
    GregorianCalendar gcal = new GregorianCalendar();
    gcal.setTime(cal.getTime());
    return dataTypeFactory.newXMLGregorianCalendar(gcal);
  }

  public static XMLGregorianCalendar fromDate(Date date) {
    GregorianCalendar gcal = new GregorianCalendar();
    gcal.setTime(date);
    return dataTypeFactory.newXMLGregorianCalendar(gcal);
  }

  public static XMLGregorianCalendar fromSqlDate(Date date) {
    GregorianCalendar gcal = new GregorianCalendar();
    gcal.setTime(date);
    return dataTypeFactory.newXMLGregorianCalendar(gcal);
  }
}

package com.app.core.json.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.app.core.exceptions.SystemException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import org.apache.commons.lang3.StringUtils;
import com.app.core.json.util.DateTimeModule;

public class JsonUtils {
  private static final ObjectMapper OBJECT_MAPPER_NO_INIT = new ObjectMapper();
  private static final ObjectMapper OBJECT_MAPPER_FULL_INIT = new ObjectMapper();
  private static final String DEFAULT_DATE_TIME_FORMAT = "MM/dd/yyyy hh:mm:ss a";

  static {
    OBJECT_MAPPER_NO_INIT.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    OBJECT_MAPPER_NO_INIT.registerModule(new JodaModule());
    OBJECT_MAPPER_NO_INIT.registerModule(new DateTimeModule());

    Hibernate5Module hibernate5Module = new Hibernate5Module();
    hibernate5Module.disable(Hibernate5Module.Feature.FORCE_LAZY_LOADING);

    OBJECT_MAPPER_NO_INIT.registerModule(hibernate5Module);

    OBJECT_MAPPER_FULL_INIT.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    OBJECT_MAPPER_FULL_INIT.registerModule(new JodaModule());
    OBJECT_MAPPER_FULL_INIT.registerModule(new DateTimeModule());

    Hibernate5Module hibernate5Module2 = new Hibernate5Module();
    hibernate5Module2.enable(Hibernate5Module.Feature.FORCE_LAZY_LOADING);
    OBJECT_MAPPER_FULL_INIT.registerModule(hibernate5Module2);
  }

  public static String serializeWithLazyInitialization(Object object) {
    StringWriter stringWriter = new StringWriter();
    try {
      ObjectWriter objectWriter = OBJECT_MAPPER_FULL_INIT.writer(new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a"));
      objectWriter.writeValue(stringWriter, object);
    } catch (Exception e) {
      System.out.println("Error in serializing object of class:" + object.getClass().getName() + e);
      throw new SystemException("Error in serializing object of class" + object.getClass(), e);
    }
    return stringWriter.toString();
  }

  public static String serializeWithoutLazyInitialization(Object object) {
    StringWriter stringWriter = new StringWriter();
    try {
      ObjectWriter objectWriter = OBJECT_MAPPER_NO_INIT.writer(new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a"));
      objectWriter.writeValue(stringWriter, object);
    } catch (Exception e) {
      System.out.println("Error in serializing object of class:" + object.getClass().getName() + e);
      throw new SystemException("Error in serializing object of class:" + object.getClass().getName(), e);
    }
    return stringWriter.toString();
  }

  public static String serializeWithoutLazyInitialization(Object object, String dateFormat) {
    StringWriter stringWriter = new StringWriter();
    try {
      ObjectWriter objectWriter = OBJECT_MAPPER_NO_INIT
          .writer(new SimpleDateFormat(StringUtils.isEmpty(dateFormat) ? DEFAULT_DATE_TIME_FORMAT : dateFormat));

      objectWriter.writeValue(stringWriter, object);
    } catch (Exception e) {
      System.out.println("Error in serializing object of class:" + object.getClass().getName() + e);
      throw new SystemException("Error in serializing object of class:" + object.getClass().getName(), e);
    }
    return stringWriter.toString();
  }

  public static <T> T deserialize(String jsonString, Class<T> targetClass) {
    T finalObject = null;
    try {
      finalObject = (T) OBJECT_MAPPER_NO_INIT.readValue(jsonString.getBytes(), targetClass);
    } catch (Exception e) {
      System.out.println("Error in dserializing object of class:" + targetClass.getName() + e);
      throw new SystemException("Error in deserializing object of class" + targetClass, e);
    }
    return finalObject;
  }
}

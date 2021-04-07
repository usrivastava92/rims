 package com.app.core.json.util;
 
 import com.fasterxml.jackson.databind.module.SimpleModule;
 
 
 
 
 public class DateTimeModule
   extends SimpleModule
 {
   private static final long serialVersionUID = 1L;
   
   public DateTimeModule() { addSerializer(org.joda.time.DateTime.class, new DateTimeCustomSerializer()); }
 }




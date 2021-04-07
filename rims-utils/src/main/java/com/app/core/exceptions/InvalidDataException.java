 package com.app.core.exceptions;
 
 
 public class InvalidDataException
   extends BaseRuntimeException
 {
   private static final long serialVersionUID = 1L;
   private String i18nCode;
   
   public String getI18nCode() { return this.i18nCode; }
 
 
   
   public void setI18nCode(String i18nCode) { this.i18nCode = i18nCode; }
 
 
   
   public InvalidDataException() {}
 
 
   
   public InvalidDataException(String message, Throwable cause) { super(message, cause); }
 
 
   
   public InvalidDataException(String message) { super(message); }
 
 
   
   public InvalidDataException(Throwable cause) { super(cause); }
 }




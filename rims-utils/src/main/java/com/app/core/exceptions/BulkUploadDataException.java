 package com.app.core.exceptions;
 
 
 
 public class BulkUploadDataException
   extends BaseRuntimeException
 {
   private static final long serialVersionUID = 1L;
   
   public BulkUploadDataException() {}
   
   public BulkUploadDataException(String message, Throwable cause) { super(message, cause); }
 
 
   
   public BulkUploadDataException(String message) { super(message); }
 
 
   
   public BulkUploadDataException(Throwable cause) { super(cause); }
 }




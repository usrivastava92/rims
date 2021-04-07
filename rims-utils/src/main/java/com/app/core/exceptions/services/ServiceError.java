 package com.app.core.exceptions.services;
 
 
 
 
 
 
 public class ServiceError
 {
   private String error;
   private String error_description;
   
   public ServiceError(String error, String error_description) {
     this.error = error;
     this.error_description = error_description;
   }
 
   
   public String getError() { return this.error; }
 
 
   
   public void setError(String error) { this.error = error; }
 
 
   
   public String getError_description() { return this.error_description; }
 
 
   
   public void setError_description(String error_description) { this.error_description = error_description; }
 }




 package com.app.core.misc.util;
 
 
 
 public class ClassUtil
 {
   public static boolean isSimpleType(Class clazz) {
     if (isPrimitiveOrWrapper(clazz))
       return true; 
     if (clazz.equals(String.class))
       return true; 
     if (clazz.equals(java.util.Date.class)) {
       return true;
     }
     return false;
   }
   
   public static boolean isPrimitiveOrWrapper(Class clazz) {
     if (clazz.isPrimitive()) {
       return true;
     }
     if (clazz.equals(Boolean.class))
       return true; 
     if (clazz.equals(Character.class))
       return true; 
     if (clazz.equals(Byte.class))
       return true; 
     if (clazz.equals(Short.class))
       return true; 
     if (clazz.equals(Integer.class))
       return true; 
     if (clazz.equals(Long.class))
       return true; 
     if (clazz.equals(Float.class))
       return true; 
     if (clazz.equals(Double.class)) {
       return true;
     }
     return false;
   }
 }




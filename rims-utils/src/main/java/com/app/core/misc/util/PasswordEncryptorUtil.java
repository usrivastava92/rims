 package com.app.core.misc.util;
 
 import java.math.BigInteger;
 import java.security.MessageDigest;
 import java.security.NoSuchAlgorithmException;
 
 
 

 public class PasswordEncryptorUtil
 {
   public static String encryptPassword(String text, String hashKey) throws NoSuchAlgorithmException {
     String plaintext = text + "{" + hashKey + "}";
     MessageDigest m = MessageDigest.getInstance("MD5");
     m.reset();
     m.update(plaintext.getBytes());
     byte[] digest = m.digest();
     BigInteger bigInt = new BigInteger(digest);
     String hashtext = bigInt.toString(16);
     while (hashtext.length() < 32)
     {
       hashtext = "0" + hashtext;
     }
     return hashtext;
   }
 }




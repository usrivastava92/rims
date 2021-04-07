 package com.app.core.misc.util;
 
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class IpAddressUtils
 {
   private static final String IP_ADDRESS = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";
   private static final Pattern addressPattern = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})");
   
   public static boolean isInRange(String from, String to, String remoteAddr) {
     int address = toInteger(remoteAddr);
     int low = toInteger(from);
     int high = toInteger(to);
     return (low <= address && address <= high);
   }
 
 
 
   
   public static int toInteger(String address) {
     Matcher matcher = addressPattern.matcher(address);
     if (matcher.matches()) {
       return matchAddress(matcher);
     }
     throw new IllegalArgumentException("Could not parse [" + address + "]");
   }
 
 
 
 
 
   
   private static int matchAddress(Matcher matcher) {
     int addr = 0;
     for (int i = 1; i <= 4; i++) {
       int n = rangeCheck(Integer.parseInt(matcher.group(i)), -1, 255);
       addr |= (n & 0xFF) << 8 * (4 - i);
     } 
     return addr;
   }
 
 
 
 
 
   
   private static int rangeCheck(int value, int begin, int end) {
     if (value > begin && value <= end) {
       return value;
     }
     
     throw new IllegalArgumentException("Value [" + value + "] not in range (" + begin + "," + end + "]");
   }
 }




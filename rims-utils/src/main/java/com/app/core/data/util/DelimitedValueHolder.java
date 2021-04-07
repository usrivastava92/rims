 package com.app.core.data.util;
 
 import java.util.Collections;
 import java.util.Iterator;
 import java.util.LinkedHashMap;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
 
 
 
 
 
 public class DelimitedValueHolder
 {
   private Map<String, String> keyValueMap;
   
   public void createMap() { this.keyValueMap = new LinkedHashMap(); }
 
 
   
   public DelimitedValueHolder(String keyValues) { setKeyValueMap(keyValues); }
 
 
   
   private void setKeyValueMap(String keyValues) {
     if (StringUtils.isNotBlank(keyValues) && this.keyValueMap == null) {
       String[] keyValueArray = null;
       if (keyValues.contains("~")) {
         keyValueArray = keyValues.split("~");
       } else {
         keyValueArray = new String[] { keyValues };
       } 
       if (keyValueArray.length > 0) {
         createMap();
         for (String keyValue : keyValueArray) {
           String[] breakup = keyValue.split("-");
           this.keyValueMap.put(breakup[0], breakup[1]);
         } 
       } 
     } 
   }
   
   private Map<String, String> getKeyValueMap() { return this.keyValueMap; }
 
   
   public Map<String, String> getBreakup() {
     Map<String, String> result = getKeyValueMap();
     if (result != null) {
       result = Collections.unmodifiableMap(result);
     }
     return result;
   }
   
   public String addKeyValue(String key, String value) {
     Map<String, String> map = getKeyValueMap();
     if (map == null) {
       createMap();
     }
     getKeyValueMap().put(key, value);
     return createKeyValueString();
   }
   
   public String removeValueForKey(String key) {
     Map<String, String> map = getKeyValueMap();
     if (map != null) {
       getKeyValueMap().remove(key);
       return createKeyValueString();
     } 
     return null;
   }
   
   private String createKeyValueString() {
     StringBuilder sb = new StringBuilder();
     Iterator<Map.Entry<String, String>> valueIterator = getKeyValueMap().entrySet().iterator();
     while (valueIterator.hasNext()) {
       Map.Entry<String, String> value = (Map.Entry)valueIterator.next();
       sb.append((String)value.getKey()).append("-").append((String)value.getValue());
       if (valueIterator.hasNext()) {
         sb.append("~");
       }
     } 
     return sb.toString();
   }
 
   
   public String getValueForKey(String key) { return (String)this.keyValueMap.get(key); }
 }




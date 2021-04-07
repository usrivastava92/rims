 package com.app.core.xml.util;
 
 import com.app.core.exceptions.InvalidDataException;
 import com.thoughtworks.xstream.XStream;
 import com.thoughtworks.xstream.converters.Converter;
 import com.thoughtworks.xstream.converters.MarshallingContext;
 import com.thoughtworks.xstream.converters.UnmarshallingContext;
 import com.thoughtworks.xstream.hibernate.converter.HibernatePersistentCollectionConverter;
 import com.thoughtworks.xstream.hibernate.converter.HibernatePersistentMapConverter;
 import com.thoughtworks.xstream.hibernate.converter.HibernatePersistentSortedMapConverter;
 import com.thoughtworks.xstream.hibernate.converter.HibernatePersistentSortedSetConverter;
 import com.thoughtworks.xstream.hibernate.converter.HibernateProxyConverter;
 import com.thoughtworks.xstream.hibernate.mapper.HibernateMapper;
 import com.thoughtworks.xstream.io.HierarchicalStreamReader;
 import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
 import com.thoughtworks.xstream.mapper.MapperWrapper;
 import java.io.ByteArrayOutputStream;
 import javax.xml.parsers.DocumentBuilderFactory;
 import javax.xml.transform.TransformerFactory;
 import javax.xml.transform.dom.DOMSource;
 import javax.xml.transform.stream.StreamResult;
 import org.apache.commons.io.IOUtils;
 import org.apache.commons.lang3.StringUtils;
 import org.joda.time.DateTime;
 import org.joda.time.format.DateTimeFormatter;
 import org.joda.time.format.ISODateTimeFormat;
 import org.w3c.dom.Document;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class XmlUtils
 {
   private static final TransformerFactory TANSFORMER_FACTORY = TransformerFactory.newInstance();
   
   private static final XStream xstream = new XStream();
   
   private static final XStream xStreamWithDateTimeToISO = new XStream()
     {
       protected MapperWrapper wrapMapper(MapperWrapper next) { return new HibernateMapper(next); }
     };
 
   
   static  {
     xStreamWithDateTimeToISO
       .registerConverter(new HibernateProxyConverter());
     xStreamWithDateTimeToISO
       .registerConverter(new HibernatePersistentCollectionConverter(xStreamWithDateTimeToISO
           .getMapper()));
     xStreamWithDateTimeToISO
       .registerConverter(new HibernatePersistentMapConverter(xStreamWithDateTimeToISO
           .getMapper()));
     xStreamWithDateTimeToISO
       .registerConverter(new HibernatePersistentSortedMapConverter(xStreamWithDateTimeToISO
           .getMapper()));
     xStreamWithDateTimeToISO
       .registerConverter(new HibernatePersistentSortedSetConverter(xStreamWithDateTimeToISO
           .getMapper()));
     xStreamWithDateTimeToISO.registerConverter(new Converter() {
           DateTimeFormatter formatter = ISODateTimeFormat.dateTime();
 
 
           
           public boolean canConvert(Class type) { return DateTime.class.isAssignableFrom(type); }
 
 
 
           
           public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
             String value = reader.getValue();
             return StringUtils.isBlank(value) ? null : this.formatter
               .parseDateTime(value);
           }
 
 
 
           
           public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
             DateTime dateTime = (DateTime)source;
             
             writer.setValue(this.formatter.print(dateTime));
           }
         });
     
     xStreamWithDateTimeToISO.setMode(1001);
   }
 
 
   
   public static <T> T readFromXml(String xmlContent, Class<T> targetObjectClass) { return (T)targetObjectClass.cast(xstream.fromXML(xmlContent)); }
 
 
   
   public static String writeToXml(Object objectToWrite) { return xstream.toXML(objectToWrite); }
 
 
   
   public static String writeToXml(Document document) throws InvalidDataException {
     ByteArrayOutputStream stream = new ByteArrayOutputStream();
     try {
       TANSFORMER_FACTORY.newTransformer().transform(new DOMSource(document), new StreamResult(stream));
     }
     catch (Exception e) {
       throw new InvalidDataException("Exception occured while converting DOM into XML", e);
     } 
     
     return stream.toString();
   }
 
 
   
   public static Document readFromXml(String input) throws InvalidDataException {
     try {
       return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(IOUtils.toInputStream(input));
     } catch (Exception e) {
       throw new InvalidDataException("Exception occured while converting input String into document", e);
     } 
   }
 
 
   
   public static String initializeAndWriteToXml(Object objectToWrite) {
     XStream xstream = new XStream()
       {
         protected MapperWrapper wrapMapper(MapperWrapper next) {
           return new HibernateMapper(next);
         }
       };
     xstream.registerConverter(new HibernateProxyConverter());
     xstream.registerConverter(new HibernatePersistentCollectionConverter(xstream
           .getMapper()));
     xstream.registerConverter(new HibernatePersistentMapConverter(xstream
           .getMapper()));
     xstream.registerConverter(new HibernatePersistentSortedMapConverter(xstream
           .getMapper()));
     xstream.registerConverter(new HibernatePersistentSortedSetConverter(xstream
           .getMapper()));
     
     return xstream.toXML(objectToWrite);
   }
   
   public static String initializeAndWriteToXmlWithDateTimeToISO(Object objectToWrite) {
     String string = xStreamWithDateTimeToISO.toXML(objectToWrite);
     return string;
   }
 
   
   public static <T> T readFromXmlWithISOToDateTime(String xmlContent, Class<T> targetObjectClass) { return (T)targetObjectClass.cast(xStreamWithDateTimeToISO.fromXML(xmlContent)); }
 }




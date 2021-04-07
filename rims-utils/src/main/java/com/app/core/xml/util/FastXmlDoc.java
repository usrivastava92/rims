package com.app.core.xml.util;

import com.app.core.exceptions.InvalidDataException;
import com.app.core.exceptions.SystemException;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

public class FastXmlDoc implements Cloneable {
  public static final String RFC_TIMESTAMP_FORMAT = "yyyy-MM-dd\\THH:mm:ssZ";
  private Document doc;
  private Node root;
  private Node[] list;
  private int index;
  private boolean exclusive;
  public static FastXmlDoc empty = new FastXmlDoc();

  public static Node[] newListNode(NodeList list) {
    int length = (list == null) ? 0 : list.getLength();

    Node[] result = new Node[length];

    for (int i = 0; i < length; i++) {
      result[i] = list.item(i);
    }

    return result;
  }

  private static boolean compareNode(Node left, Node right) {
    int end;
    int i;
    NodeList rightChildren;
    NamedNodeMap rightAttr;
    NodeList leftChildren;
    NamedNodeMap leftAttr;
    if (left.getNodeType() != right.getNodeType()) {
      return false;
    }

    switch (left.getNodeType()) {
    case 2:
    case 3:
    case 4:
    case 7:
    case 8:
      if (null != left.getNodeValue() && null != right.getNodeValue()
          && !left.getNodeValue().equals(right.getNodeValue())) {
        return false;
      }
      break;
    }

    switch (left.getNodeType()) {
    case 1:
    case 2:
    case 5:
    case 6:
    case 7:
    case 10:
    case 12:
      if (null != left.getNamespaceURI() && null != right.getNamespaceURI()
          && !left.getNamespaceURI().equals(right.getNamespaceURI())) {
        return false;
      }
      if (null != left.getNodeName() && null != right.getNodeName()
          && !left.getNodeName().equals(right.getNodeName())) {
        return false;
      }
      break;
    }

    switch (left.getNodeType()) {
    case 1:
      leftAttr = left.getAttributes();
      rightAttr = right.getAttributes();

      if (leftAttr == null && rightAttr == null) {
        break;
      }

      if (leftAttr == null || rightAttr == null) {
        return false;
      }

      if (leftAttr.getLength() != rightAttr.getLength()) {
        return false;
      }

      for (i = 0, end = leftAttr.getLength(); i < end; i++) {
        if (!compareNode(leftAttr.item(i), rightAttr.item(i))) {
          return false;
        }
      }
      break;
    }

    switch (left.getNodeType()) {
    case 1:
    case 9:
    case 11:
      leftChildren = left.getChildNodes();
      rightChildren = right.getChildNodes();

      if (leftChildren == null && rightChildren == null) {
        break;
      }

      if (leftChildren == null || rightChildren == null) {
        return false;
      }

      if (leftChildren.getLength() != rightChildren.getLength()) {
        return false;
      }

      for (i = 0, end = leftChildren.getLength(); i < end; i++) {
        if (!compareNode(leftChildren.item(i), rightChildren.item(i))) {
          return false;
        }
      }
      break;
    }
    return true;
  }

  public static Document getNewDocument() {
    Document doc = null;

    try {
      doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    } catch (ParserConfigurationException e) {
      throw new SystemException("could not create Document instance");
    }

    return doc;
  }

  public FastXmlDoc(String tag) {
    this(tag, null);
  }

  public FastXmlDoc(String tag, String ns) {
    this.doc = getNewDocument();

    if (ns != null && !ns.isEmpty()) {
      this.doc.appendChild(this.doc.createElementNS(ns, tag));
    } else {
      this.doc.appendChild(this.doc.createElement(tag));
    }

    this.list = new Node[] { this.doc.getDocumentElement() };
    this.index = 0;

    this.root = getCurrentNode();
  }

  public FastXmlDoc(Document doc) {
    if (doc == null) {
      throw new IllegalArgumentException("doc");
    }

    if (doc.getDocumentElement() == null) {
      throw new IllegalArgumentException("Document instance does not have a root element.");
    }

    initialize(new Node[] { doc.getDocumentElement() }, 0, doc.getDocumentElement());
  }

  public FastXmlDoc(FastXmlDoc doc) {
    if (doc == null || doc.isEmpty()) {
      throw new IllegalArgumentException("doc");
    }

    Node node = doc.asNode();

    initialize(new Node[] { node }, 0, node);
  }

  private FastXmlDoc(Node[] list, int index, Node root) {
    initialize(list, index, root);
  }

  private FastXmlDoc() {
  }

  private void initialize(Node[] list, int index, Node root) {
    if (list == null) {
      throw new IllegalArgumentException("list is null");
    }

    if (list.length == 0) {
      throw new IllegalArgumentException("list has no nodes");
    }

    if (index < 0 || index >= list.length) {
      throw new IndexOutOfBoundsException("index is out of range");
    }

    this.list = list;
    this.index = index;
    this.root = (root != null) ? root : list[index];
    this.doc = this.root.getOwnerDocument();
  }

  public FastXmlDoc at(int index) {
    if (!isEmpty() && index >= 0 && index < this.root.getChildNodes().getLength()) {
      return new FastXmlDoc(newListNode(this.root.getChildNodes()), index, null);
    }

    return empty;
  }

  public FastXmlDoc at(String path) {
    boolean simple = true;

    for (int i = 0; i < path.length(); i++) {
      char c = path.charAt(i);
      if ((i != 0 || c != '@') && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9') && c != '-'
          && c != '.') {

        simple = false;

        break;
      }
    }

    if (simple) {

      Element element = (Element) getCurrentNode();

      if (element != null) {
        if (path.charAt(0) == '@') {

          Node child = element.getAttributeNode(path.substring(1));

          if (child != null) {
            return new FastXmlDoc(new Node[] { child }, 0, null);
          }
        } else {

          ArrayList<Node> children = new ArrayList<Node>();

          for (Node child = element.getFirstChild(); child != null; child = child.getNextSibling()) {

            if (child instanceof Element && child.getNodeName().equals(path)) {
              children.add(child);
            }
          }

          if (children.size() > 0) {
            return new FastXmlDoc((Node[]) children.toArray(new Node[children.size()]), 0, null);
          }
        }
      }

      return empty;
    }

    return atPath(path);
  }

  public FastXmlDoc atPath(String path) {
    if (path == null) {
      throw new IllegalArgumentException("path");
    }

    if (!path.isEmpty()) {
      NodeList results;
      ArrayList<Node> list = new ArrayList<Node>();

      XPath xpath = XPathFactory.newInstance().newXPath();

      try {
        results = (NodeList) xpath.evaluate(path, this.root, XPathConstants.NODESET);
      } catch (XPathExpressionException e) {
        System.out.println("XPathExpressionException while evaluating:" + path);
        return empty;
      }

      for (int i = 0, end = results.getLength(); i < end; i++) {
        list.add(results.item(i));
      }

      if (list.size() > 0) {
        return new FastXmlDoc((Node[]) list.toArray(new Node[list.size()]), 0, null);
      }
    }

    return empty;
  }

  public FastXmlDoc at(Node node) {
    if (node == null) {
      throw new IllegalArgumentException("node");
    }

    if (isEmpty()) {
      return empty;
    }

    if (this.doc != node.getOwnerDocument()) {
      return empty;
    }

    return new FastXmlDoc(new Node[] { node }, 0, null);
  }

  public String getContents() {
    if (this.doc != null) {
      Node current = getCurrentNode();

      if (current instanceof Element && current.hasChildNodes() && current.getChildNodes().getLength() == 1
          && current.getChildNodes().item(0) instanceof org.w3c.dom.Text) {
        return current.getChildNodes().item(0).getNodeValue();
      }

      if (current instanceof org.w3c.dom.Text || current instanceof Attr) {
        return current.getNodeValue();
      }

      return getInnerXml(current);
    }

    return "";
  }

  private String getInnerXml(Node node) {
    DOMImplementationLS lsImpl = (DOMImplementationLS) node.getOwnerDocument().getImplementation().getFeature("LS",
        "3.0");
    LSSerializer lsSerializer = lsImpl.createLSSerializer();
    NodeList childNodes = node.getChildNodes();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < childNodes.getLength(); i++) {
      sb.append(lsSerializer.writeToString(childNodes.item(i)));
    }
    return sb.toString();
  }

  public FastXmlDoc getElements() {
    if (this.doc != null) {
      return at("*");
    }
    return empty;
  }

  public FastXmlDoc getFirst() {
    if (!isEmpty() && this.list != null) {
      return new FastXmlDoc(this.list, 0, null);
    }

    return empty;
  }

  public FastXmlDoc getNext() {
    if (!isEmpty() && this.list != null && this.index < this.list.length - 1) {
      return new FastXmlDoc(this.list, this.index + 1, null);
    }

    return empty;
  }

  public boolean isEmpty() {
    return (this.doc == null);
  }

  public boolean isText() {
    return getCurrentNode() instanceof org.w3c.dom.Text;
  }

  public String getName() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("The FastXmlManipulator is empty.");
    }
    return getCurrentNode().getNodeName();
  }

  public Node getCurrentNode() {
    if (this.doc != null) {
      return (this.list != null) ? this.list[this.index] : this.doc;
    }
    return null;
  }

  public String getNamespaceURI() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("The FastXmlManipulator is empty.");
    }
    return getCurrentNode().getNamespaceURI();
  }

  public String getPrefix() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("The FastXmlManipulator is empty.");
    }
    return getCurrentNode().getPrefix();
  }

  public Node asNode() {
    return getCurrentNode();
  }

  private String getNodeText(Node node) {
    switch (node.getNodeType()) {
    case 2:
    case 3:
    case 4:
      return node.getNodeValue();
    }

    return null;
  }

  public String asInnerText() {
    if (isEmpty()) {
      return null;
    }
    return getCurrentNode().getTextContent();
  }

  public String asText() {
    if (isEmpty()) {
      return null;
    }

    Node current = getCurrentNode();

    if (current instanceof Element) {

      if (!current.hasChildNodes()) {
        return "";
      }

      NodeList children = current.getChildNodes();

      int count = children.getLength();

      if (count == 1) {
        return getNodeText(current.getChildNodes().item(0));
      }

      StringBuilder result = new StringBuilder();
      for (int i = 0; i < count; i++) {
        String text = getNodeText(children.item(i));
        if (text == null) {
          break;
        }
        result.append(text);
      }

      return result.toString();
    }

    return getNodeText(current);
  }

  public boolean asBoolean() {
    return ((Boolean) as(boolean.class)).booleanValue();
  }

  public byte asByte() {
    return ((Byte) as(byte.class)).byteValue();
  }

  public short asShort() {
    return ((Short) as(short.class)).shortValue();
  }

  public int asInt() {
    return ((Integer) as(int.class)).intValue();
  }

  public long asLong() {
    return ((Long) as(long.class)).longValue();
  }

  public float asFloat() {
    return ((Float) as(float.class)).floatValue();
  }

  public double asDouble() {
    return ((Double) as(double.class)).doubleValue();
  }

  public Date asDate() {
    if (isEmpty()) {
      return null;
    }
    try {
      return DateFormat.getInstance().parse(getContents());
    } catch (ParseException e) {
      System.out.println("ParseException while parsing:" + getContents());
      return null;
    }
  }

  public <T> T as(Class<T> type) {
    if (isEmpty()) {
      return null;
    }
    return (T) type.cast(getContents());
  }

  public FastXmlDoc getParent() {
    if (isEmpty()) {
      return empty;
    }

    Node current = getCurrentNode();

    Node parent = null;

    if (current instanceof Attr) {
      parent = ((Attr) current).getOwnerElement();
    } else {
      parent = current.getParentNode();
    }

    if (parent == null || parent instanceof Document) {
      return empty;
    }

    return at(parent);
  }

  public String getLanguage() {
    return at("@xml:lang").asText();
  }

  public void setLanguage(String language) {
    if (language != null) {
      attr("xml:lang", language);
    }
  }

  private Element getRootElement() {
    if (this.root instanceof Document) {
      return ((Document) this.root).getDocumentElement();
    }
    return (Element) this.root;
  }

  public boolean hasName(String name) {
    return (!isEmpty() && getName().equals(name));
  }

  public boolean hasName(String name, String namespaceUri) {
    return (!isEmpty() && getName().equals(name) && getNamespaceURI().equals(namespaceUri));
  }

  public boolean hasAttr(String name) {
    return (!isEmpty() && getCurrentNode().getAttributes() != null
        && getCurrentNode().getAttributes().getNamedItem(name) != null);
  }

  public boolean hasAttr(String name, String namespaceUri) {
    return (!isEmpty() && getCurrentNode().getAttributes() != null
        && getCurrentNode().getAttributes().getNamedItemNS(name, namespaceUri) != null);
  }

  public FastXmlDoc clone() {
    Document doc;
    if (isEmpty()) {
      return this;
    }

    if (this.root instanceof Document) {
      if (this.exclusive) {
        this.exclusive = false;
        return this;
      }
      doc = (Document) this.root.getParentNode().cloneNode(false);
    } else {
      doc = getNewDocument();
      Node node = doc.importNode(this.root, true);
      doc.appendChild(node);
    }
    return new FastXmlDoc(doc);
  }

  public FastXmlDoc setExclusive() {
    if (!isEmpty()) {
      if (!(this.root.getParentNode() instanceof Document)) {
        throw new IllegalStateException("only the root node can be marked exclusive");
      }
      this.exclusive = true;
    }
    return this;
  }

  public FastXmlDoc copy() {
    if (isEmpty()) {
      return this;
    }
    return new FastXmlDoc(this.list, this.index, this.root);
  }

  public FastXmlDoc attr(String tag, String value) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (tag == null) {
      throw new IllegalArgumentException("tag");
    }

    if (value == null) {
      return this;
    }

    Node node = this.doc.createAttribute(tag);

    node.setNodeValue(value);

    getCurrentNode().getAttributes().setNamedItemNS(node);

    return this;
  }

  public FastXmlDoc attr(String tag, Object value) {
    return attr(tag, value.toString());
  }

  public FastXmlDoc attr(String tag, Date value) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd\\THH:mm:ssZ");
    return attr(tag, formatter.format(value));
  }

  public FastXmlDoc start(String tag) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (tag == null) {
      throw new IllegalArgumentException("tag");
    }

    Node node = this.doc.createElement(tag);

    getCurrentNode().appendChild(node);

    this.list = new Node[] { node };
    this.index = 0;

    return this;
  }

  public FastXmlDoc start(String tag, String namespaceUri) {
    if (namespaceUri == null) {
      return start(tag);
    }

    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (tag == null) {
      throw new IllegalArgumentException("tag");
    }

    Node node = this.doc.createElementNS(tag, namespaceUri);

    getCurrentNode().appendChild(node);

    this.list = new Node[] { node };
    this.index = 0;

    return this;
  }

  public FastXmlDoc elem(String tag) {
    return start(tag).end();
  }

  public FastXmlDoc elem(String tag, Object value) {
    if (value == null) {
      return this;
    }
    return start(tag).value(value).end();
  }

  public FastXmlDoc value(String value) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (value == null) {
      return this;
    }

    Node node = this.doc.createTextNode(value);

    getCurrentNode().appendChild(node);

    return this;
  }

  public FastXmlDoc value(Date value) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd\\THH:mm:ssZ");
    return value(formatter.format(value));
  }

  public FastXmlDoc value(Object value) {
    return value(value.toString());
  }

  public FastXmlDoc replaceValue(String value) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (value == null) {
      throw new IllegalArgumentException("value");
    }

    Node current = getCurrentNode();

    if (current instanceof Element) {
      Node node = current.getFirstChild();
      while (node != null) {
        Node next = node.getNextSibling();
        if (node instanceof org.w3c.dom.Text) {
          current.removeChild(node);
        }
        node = next;
      }
      return value(value);
    }

    if (current instanceof org.w3c.dom.Text) {
      current.setNodeValue(value);
      return this;
    }

    if (current instanceof Attr) {
      current.setNodeValue(value);
      return this;
    }

    throw new IllegalStateException("doc has no value");
  }

  public FastXmlDoc replaceValue(Object value) {
    return replaceValue(value.toString());
  }

  public FastXmlDoc insertValueAt(String xpath, String value) {
    Pattern pattern = Pattern.compile("(.+)\\[(\\d+)\\]");

    if (xpath == null) {
      throw new IllegalArgumentException("xpath");
    }

    if (value == null) {
      return this;
    }

    FastXmlDoc cursor = copy();

    if (xpath.length() > 0) {

      String[] path = xpath.replaceAll("^/*|/*$", "").split("/");

      for (int i = 0; i < path.length; i++) {
        String token = path[i];
        int index = -1;

        Matcher match = pattern.matcher(token);
        if (match.find()) {
          index = Integer.parseInt(match.group(2)) - 1;
          token = match.group(1);
        }

        if (token.length() == 0) {
          throw new IllegalArgumentException("token");
        }

        if (i == path.length - 1) {

          if (token.charAt(0) == '@') {
            cursor.attr(token.substring(1), value);
            return this;
          }

          if (token.charAt(0) != '#') {
            cursor = cursor.start(token);
          }
        } else if (index >= 0) {

          int count = index;
          FastXmlDoc current = cursor.at(token);

          while (--count >= 0) {
            if (current.isEmpty()) {
              current = cursor.start(token).copy();
              cursor.end();
            }
            current = current.getNext();
          }

          if (current.isEmpty()) {
            current = cursor.start(token).copy();
            cursor.end();
          }

          cursor = current;
        } else {
          FastXmlDoc current = cursor.at(token + "[last()]");

          if (current.isEmpty()) {
            current = cursor.start(token).copy();
            cursor.end();
          }
          cursor = current;
        }
      }
    }

    if (value.length() > 0) {
      cursor.value(value);
    }

    return this;
  }

  public FastXmlDoc cDataSection(String value) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (value == null) {
      return this;
    }

    Node node = this.doc.createCDATASection(value);

    getCurrentNode().appendChild(node);

    return this;
  }

  public FastXmlDoc comment(String value) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (value == null) {
      return this;
    }

    Node node = this.doc.createComment(value);

    node.appendChild(node);

    return this;
  }

  public FastXmlDoc conditionalComment(String condition, FastXmlDoc contents) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (condition == null || condition.isEmpty()) {
      throw new IllegalStateException("condition");
    }

    if (contents == null || contents.isEmpty()) {
      return this;
    }

    Node node = this.doc
        .createComment(String.format("[%s]>%s<![endif]", new Object[] { condition, contents.getContents() }));

    node.appendChild(node);

    return this;
  }

  public FastXmlDoc end() {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (getCurrentNode() == this.root) {
      throw new IllegalStateException("doc is at root position");
    }

    Node parent = getCurrentNode().getParentNode();

    if (parent == this.doc) {
      this.list = null;
      this.index = -1;
    } else {
      this.list = new Node[] { parent };
      this.index = 0;
    }

    return this;
  }

  public FastXmlDoc getRoot() {
    return new FastXmlDoc(this.list, this.index, this.root);
  }

  public FastXmlDoc end(Node markerNode) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    Node currentNode = asNode();
    while (currentNode != markerNode) {
      end();
      currentNode = asNode();
    }

    return this;
  }

  public FastXmlDoc endAll() {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    while (getCurrentNode() != this.root) {
      end();
    }

    return this;
  }

  private String getOuterXml(Node node, boolean decl, boolean indent) {
    Transformer transformer;
    try {
      transformer = TransformerFactory.newInstance().newTransformer();
    } catch (Exception e) {
      System.out.println("Exception while creating new Transformer instance");
      return "";
    }

    transformer.setOutputProperty("method", "xml");

    if (!decl) {
      transformer.setOutputProperty("omit-xml-declaration", "yes");
    }

    if (indent) {
      transformer.setOutputProperty("indent", "yes");
      transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
    }

    StringWriter writer = new StringWriter();

    try {
      transformer.transform(new DOMSource(node), new StreamResult(writer));
    } catch (TransformerException e) {
      System.out.println("TransformerException while transforming:" + node);
      return "";
    }

    return writer.toString();
  }

  public String toString() {
    return toString(false);
  }

  public String toString(boolean decl) {
    if (isEmpty()) {
      return "";
    }

    return getOuterXml(this.root, (decl == true && this.root.getParentNode() == this.doc), false);
  }

  public String toPrettyString() {
    return getOuterXml(this.root, true, true);
  }

  public FastXmlDoc remove() {
    if (!isEmpty()) {

      Node current = getCurrentNode();

      if (current instanceof Attr) {

        Attr attribute = (Attr) current;

        if (attribute.getOwnerElement() != null) {
          attribute.getOwnerElement().removeAttributeNode(attribute);
        }
      } else if (current.getParentNode() != null) {

        current.getParentNode().removeChild(current);
      }

      this.list = null;
    }

    return empty;
  }

  public FastXmlDoc removeAttr(String name) {
    if (isEmpty()) {
      return this;
    }

    if (name == null) {
      throw new IllegalArgumentException("name");
    }

    getCurrentNode().getAttributes().removeNamedItem(name);

    return this;
  }

  public void removeAll() {
    for (FastXmlDoc doc : toList()) {
      doc.remove();
    }
  }

  public FastXmlDoc removeNodes() {
    if (isEmpty()) {
      return this;
    }

    Node current = getCurrentNode();

    while (current.getFirstChild() != null) {
      current.removeChild(current.getFirstChild());
    }

    return this;
  }

  public FastXmlDoc replace(FastXmlDoc doc) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (doc == null || doc.isEmpty()) {
      return remove();
    }

    Element docnode = doc.getRootElement();

    String defaultNS = this.doc.getDocumentElement().getNamespaceURI();
    String nodeNS = docnode.getNamespaceURI();

    if (defaultNS != null && defaultNS.length() > 0 && (nodeNS == null || nodeNS.length() == 0)) {
      docnode.setAttribute("xmlns", defaultNS);
    }

    Node node = this.doc.importNode(docnode, true);

    return replaceCurrentNode(node);
  }

  private Node insertAfter(Node parent, Node insert, Node ref) {
    if (parent == null) {
      throw new IllegalStateException("doc is at root");
    }

    if (ref != null && ref.getParentNode() != parent) {
      throw new IllegalArgumentException("ref is not a child of parent");
    }

    if (ref == null) {
      parent.insertBefore(insert, parent.getFirstChild());
    } else if (ref.getNextSibling() != null) {
      parent.insertBefore(insert, ref.getNextSibling());
    } else {
      parent.appendChild(insert);
    }

    return insert;
  }

  public FastXmlDoc replaceWithNodes(FastXmlDoc doc) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (doc == null || doc.isEmpty() || doc.asNode().getFirstChild() == null) {
      return remove();
    }

    Node importNode = doc.getRootElement().getFirstChild();
    Node insertNode = getCurrentNode();
    Node parentNode = insertNode.getParentNode();

    while (importNode != null) {
      insertNode = insertAfter(parentNode, this.doc.importNode(importNode, true), insertNode);
      importNode = importNode.getNextSibling();
    }

    parentNode.removeChild(getCurrentNode());

    return at(insertNode);
  }

  public FastXmlDoc replace(String value) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (value == null) {
      return remove();
    }

    return replaceCurrentNode(this.doc.createTextNode(value));
  }

  public FastXmlDoc replace(Object value) {
    return replace(value.toString());
  }

  public FastXmlDoc replace(Date value) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd\\THH:mm:ssZ");
    return replace(formatter.format(value));
  }

  public FastXmlDoc rename(String name) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (name == null) {
      throw new IllegalArgumentException("name");
    }

    if (name.equals(getCurrentNode().getNodeName())) {
      return this;
    }

    Node current = getCurrentNode();

    Element node = current.getOwnerDocument().createElement(name);

    NamedNodeMap list = current.getAttributes();
    for (int i = 0; i < list.getLength(); i++) {
      Attr item = (Attr) list.item(i);
      node.setAttribute(item.getNodeName(), item.getNodeValue());
    }

    for (Node child : newListNode(current.getChildNodes())) {
      node.appendChild(child);
    }

    return replaceCurrentNode(node);
  }

  public FastXmlDoc addNodesInFront(FastXmlDoc doc) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (doc == null) {
      return this;
    }

    if (!(this.root instanceof Element)) {
      throw new IllegalStateException("doc is not an element");
    }

    if (!doc.isEmpty()) {

      Node insertNode = null;

      NodeList nodes = doc.getRootElement().getChildNodes();

      for (int i = 0; i < nodes.getLength(); i++) {
        insertNode = insertAfter(getCurrentNode(), this.doc.importNode(nodes.item(i), true), insertNode);
      }
    }

    return this;
  }

  private FastXmlDoc replaceCurrentNode(Node newNode) {
    Node current = getCurrentNode();

    Node parent = current.getParentNode();

    parent.replaceChild(newNode, current);

    this.list[this.index] = newNode;

    if (current == this.root) {
      this.root = newNode;
      this.doc = this.root.getOwnerDocument();
    }

    return this;
  }

  public ArrayList<FastXmlDoc> toList() {
    if (isEmpty() || this.list == null) {
      return new ArrayList();
    }

    ArrayList<FastXmlDoc> result = new ArrayList<FastXmlDoc>(this.list.length);

    for (int i = 0; i < this.list.length; i++) {
      result.add(new FastXmlDoc(this.list, i, null));
    }

    return result;
  }

  public FastXmlDoc addNodesBefore(FastXmlDoc doc) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (doc == null) {
      return this;
    }

    if (!(this.root instanceof Element)) {
      throw new IllegalStateException("doc is not an element");
    }

    if (!doc.isEmpty()) {

      Node parent = getCurrentNode().getParentNode();

      if (parent == null) {
        throw new IllegalStateException("doc is top node");
      }

      Node marker = parent.insertBefore(this.doc.createTextNode("#"), getCurrentNode());

      Node insertNode = marker;

      for (Node node : newListNode(doc.getRootElement().getChildNodes())) {
        insertNode = insertAfter(parent, this.doc.importNode(node, true), insertNode);
      }

      parent.removeChild(marker);
    }

    return this;
  }

  public FastXmlDoc addNodesAfter(FastXmlDoc doc) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (doc == null) {
      return this;
    }

    if (!(this.root instanceof Element)) {
      throw new IllegalStateException("doc is not an element");
    }

    if (!doc.isEmpty()) {

      Node parent = getCurrentNode().getParentNode();
      if (parent == null) {
        throw new IllegalStateException("doc is top node");
      }

      Node insertNode = getCurrentNode();

      for (Node node : newListNode(doc.getRootElement().getChildNodes())) {
        insertNode = insertAfter(parent, this.doc.importNode(node, true), insertNode);
      }
    }

    return this;
  }

  public FastXmlDoc addNodes(FastXmlDoc doc) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (doc == null) {
      return this;
    }

    if (!doc.isEmpty()) {
      for (Node node : newListNode(doc.getRootElement().getChildNodes())) {
        getCurrentNode().appendChild(this.doc.importNode(node, true));
      }
    }

    return this;
  }

  public FastXmlDoc add(FastXmlDoc doc) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (doc == null) {
      return this;
    }

    if (!doc.isEmpty()) {
      getCurrentNode().appendChild(this.doc.importNode(doc.root, true));
    }

    return this;
  }

  public FastXmlDoc addAfter(String value) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (value == null || value.isEmpty()) {
      return this;
    }

    Node parent = getCurrentNode().getParentNode();
    if (parent == null) {
      throw new IllegalStateException("doc is top node");
    }

    insertAfter(parent, this.doc.createTextNode(value), getCurrentNode());

    return this;
  }

  public FastXmlDoc addAfter(Date value) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd\\THH:mm:ssZ");
    return addAfter(formatter.format(value));
  }

  public FastXmlDoc addAfter(Object value) {
    return addAfter(value.toString());
  }

  public FastXmlDoc addAfter(FastXmlDoc doc) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    Node parent = getCurrentNode().getParentNode();
    if (parent == null) {
      throw new IllegalStateException("doc is top node");
    }

    if (doc != null && !doc.isEmpty()) {
      insertAfter(parent, this.doc.importNode(doc.root, true), getCurrentNode());
    }

    return this;
  }

  public FastXmlDoc addBefore(String value) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (value == null || value.isEmpty()) {
      return this;
    }

    Node parent = getCurrentNode().getParentNode();

    if (parent == null) {
      throw new IllegalStateException("doc is top node");
    }

    parent.insertBefore(this.doc.createTextNode(value), getCurrentNode());

    return this;
  }

  public FastXmlDoc addBefore(Date value) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd\\THH:mm:ssZ");
    return addBefore(formatter.format(value));
  }

  public FastXmlDoc addBefore(Object value) {
    return addBefore(value.toString());
  }

  public FastXmlDoc addBefore(FastXmlDoc doc) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (doc == null) {
      return this;
    }

    Node parent = getCurrentNode().getParentNode();

    if (parent == null) {
      throw new IllegalStateException("doc is top node");
    }

    parent.insertBefore(this.doc.importNode(doc.root, true), getCurrentNode());

    return this;
  }

  public FastXmlDoc addAll(FastXmlDoc doc) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (doc != null) {
      for (FastXmlDoc item : doc.toList()) {
        add(item);
      }
    }

    return this;
  }

  public FastXmlDoc addAllBefore(FastXmlDoc doc) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (doc != null) {
      for (FastXmlDoc item : doc.toList()) {
        addBefore(item);
      }
    }

    return this;
  }

  public FastXmlDoc addAllAfter(FastXmlDoc doc) {
    if (isEmpty()) {
      throw new IllegalStateException("doc is empty");
    }

    if (doc == null) {
      return this;
    }

    ArrayList<FastXmlDoc> list = new ArrayList<FastXmlDoc>();
    for (FastXmlDoc item : doc.toList()) {
      list.add(item);
    }
    Collections.reverse(list);

    for (FastXmlDoc item : list) {
      addAfter(item);
    }

    return this;
  }

  public int length() {
    if (isEmpty()) {
      return 0;
    }

    if (this.list == null) {
      return 1;
    }

    return this.list.length;
  }

  public int hashCode() {
    int prime = 31;
    int result = 1;
    return 31 * result + ((this.root == null) ? 0 : this.root.hashCode());
  }

  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (other == this) {
      return true;
    }
    if (!(other instanceof FastXmlDoc)) {
      return false;
    }
    return compareNode(this.root, ((FastXmlDoc) other).root);
  }

  public static FastXmlDoc load(String xml) {
    DocumentBuilder dBuilder;
    if (xml == null || xml.isEmpty()) {
      return empty;
    }

    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

    try {
      dBuilder = dbFactory.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      System.out.println("ParserConfigurationException while creating new instance of DocumentBuilder");
      return empty;
    }

    xml = xml.trim().replaceFirst("^([\\W]+)<", "<");

    Document doc = null;
    try {
      doc = dBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
    } catch (Exception e) {
      throw new InvalidDataException("Unparsable XML: " + xml);
    }

    return new FastXmlDoc(doc);
  }

  public static FastXmlDoc createSelection(FastXmlDoc[] documents) {
    if (documents == null) {
      throw new IllegalArgumentException("documents are null");
    }

    ArrayList<Node> list = new ArrayList<Node>();
    for (FastXmlDoc doc : documents) {
      if (!doc.isEmpty()) {
        list.add(doc.asNode());
      }
    }

    if (list.isEmpty()) {
      return empty;
    }

    return new FastXmlDoc((Node[]) list.toArray(new Node[list.size()]), 0, null);
  }

  public static FastXmlDoc createSelection() {
    return empty;
  }
}

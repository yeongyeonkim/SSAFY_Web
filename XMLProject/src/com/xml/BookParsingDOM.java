package com.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BookParsingDOM {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();// DOM Parser

		Document doc = parser.parse("xml/book.xml");
		NodeList list_t = doc.getElementsByTagName("title");
		NodeList list_a = doc.getElementsByTagName("author");

		for (int i = 0; i < list_t.getLength(); i++) {
			Node each_t = list_t.item(i);
			Node each_a = list_a.item(i);

			Node child_t = each_t.getFirstChild();
			Node child_a = each_a.getFirstChild();

			System.out.println(child_t.getNodeValue() + " : " + child_a.getNodeValue());
		}
	}

}

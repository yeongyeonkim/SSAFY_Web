package com.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsParsingDOM {

	public static void main(String[] args) throws Exception {
		String url = "http://www.hani.co.kr/rss/";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		
//		Document doc = parser.parse("xml/news.xml");
		Document doc = parser.parse(url);
		
		NodeList list = doc.getElementsByTagName("item");
		for(int i=0; i<list.getLength(); i++) {
			Node member = list.item(i);
			NodeList child = member.getChildNodes();
			
			for(int j=0; j<child.getLength(); j++) {
				Node one = child.item(j);
				String name = one.getNodeName();
				
				if(name.equals("title")) {
					System.out.println(one.getFirstChild().getNodeValue() + " - ");
				}
				if(name.equals("pubDate")) {
					System.out.println(one.getFirstChild().getNodeValue().substring(0,22));
				}
			}
		}
	}

}

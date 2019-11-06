package com.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MemberParsingDOM {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();

		Document doc = parser.parse("xml/member.xml");
		// name, address
		NodeList list = doc.getElementsByTagName("member");
		for (int i = 0; i < list.getLength(); i++) {
			Node member = list.item(i);// member 한사람
			NodeList child = member.getChildNodes();// member한사람의 자식 모두
			System.out.println(child.getLength());

			for (int j = 0; j < child.getLength(); j++) {
				Node one = child.item(j);//자식중한개 추출.
				String name = one.getNodeName();

				if (name.equals("name")) {
					System.out.print(one.getFirstChild().getNodeValue() + ":");
				}
				if (name.equals("address")) {
					System.out.println(one.getFirstChild().getNodeValue());
				}
			}
		}

	}

}

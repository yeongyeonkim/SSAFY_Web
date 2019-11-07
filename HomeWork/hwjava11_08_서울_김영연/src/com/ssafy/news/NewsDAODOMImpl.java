package com.ssafy.news;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAODOMImpl implements INewsDAO {

	List<News> list;
	Document doc;
	private static NewsDAODOMImpl instance = new NewsDAODOMImpl();

	private NewsDAODOMImpl() {
		list = new ArrayList<>();
	}

	public static NewsDAODOMImpl getInstance() {
		return instance;
	}

	private void connectNews(String url) throws Exception {
		list.clear();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		doc = parser.parse(url);
	}

	public List<News> getNewsList(String url) {
		try {
			connectNews(url);
			NodeList nlist = doc.getElementsByTagName("item");
			for (int i = 0; i < nlist.getLength(); i++) {
				Node article = nlist.item(i);
				NodeList child = article.getChildNodes();
				News n = new News();
				for (int j = 0; j < child.getLength(); j++) {
					Node one = child.item(j);
					String name = one.getNodeName();
					if (name.equals("title"))
						n.setTitle(one.getFirstChild().getNodeValue());
					if (name.equals("description"))
						n.setDesc(one.getFirstChild().getNodeValue());
					if (name.equals("link"))
						n.setLink(one.getFirstChild().getNodeValue());
				}
				list.add(n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public News search(int index) {
		return list.get(index);
	}

}

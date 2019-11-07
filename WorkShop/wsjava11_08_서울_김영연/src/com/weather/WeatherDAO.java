package com.weather;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherDAO {

	static Document doc;

	private List<Weather> wlist;

	private static WeatherDAO instance = new WeatherDAO();

	private WeatherDAO() {
		wlist = new ArrayList<>();
	}

	public static WeatherDAO getInstance() {
		return instance;
	}

	public void connectXML(String url) throws Exception {
		wlist.clear(); 
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		doc = parser.parse(url);
	}

	public List<Weather> getWeatherList(String url){
		  
		  try {
			connectXML(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	        	
	        NodeList list = doc.getElementsByTagName("data");
	        
	        for(int i=0; i<list.getLength(); i++) {
	            Node article = list.item(i);//기사 한건  
	            NodeList child = article.getChildNodes();//기사의 자식들 모두 추출
	            Weather n = new Weather(); //기사 한건당 vo 작성 
	            
	            for(int j=0; j<child.getLength(); j++) {
	                Node one = child.item(j); //자식 중 한개 추출 
	                String name = one.getNodeName();
	                if(name.equals("hour")) 
	                	 n.setHour(Integer.parseInt(one.getFirstChild().getNodeValue()));
	                if(name.equals("temp"))
	                	n.setTemp(Double.parseDouble(one.getFirstChild().getNodeValue()));
	                if(name.equals("wfKor"))
	                	n.setWfKor(one.getFirstChild().getNodeValue());
	                if(name.equals("reh"))
	                	n.setReh(Integer.parseInt(one.getFirstChild().getNodeValue()));
	            }	            
	            wlist.add(n);
	        }
		
		return wlist;
	}

}

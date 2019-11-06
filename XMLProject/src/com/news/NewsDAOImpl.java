package com.news;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class NewsDAOImpl {
    ArrayList<News> nlist;
    
    public NewsDAOImpl() {
        nlist = new ArrayList<>();
    }
    
    //1. 전달된url에 접속해서 xml문서 받아오기 
    public List<News> getNewsData(String url) {
        nlist.clear(); 
        try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        Document doc = parser.parse(url);
        
        NodeList list = doc.getElementsByTagName("item");
        
        for(int i=0; i<list.getLength(); i++) {
            Node article = list.item(i);//기사 한건  
            NodeList child = article.getChildNodes();//기사의 자식들 모두 추출
            News n = new News(); //기사 한건당 vo 작성 
            
            for(int j=0; j<child.getLength(); j++) {
                Node one = child.item(j); //자식 중 한개 추출 
                String name = one.getNodeName();
                if(name.equals("title")) 
                    n.setTitle(one.getFirstChild().getNodeValue());
                else if(name.equals("pubDate")) 
                    n.setPubDate(one.getFirstChild().getNodeValue().substring(0, 22));
            }
            
            nlist.add(n);
        }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        System.out.println(nlist.size());
        return nlist;
    }
    //2. xml문서 파싱하기 
    //3. 원하는 엘리먼트 찾아서 vo에 담기
    //4. vo를 list에 담아서 리턴 
}
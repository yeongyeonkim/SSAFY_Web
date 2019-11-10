package com.app;

import java.util.List;

import com.dao.BoardDAO;
import com.dao.IBoard;
import com.domain.Board;

//client program
public class BoardTest {

    public static void main(String[] args) {
    	//dao 객체 생성 후에 메소드 호출
    	IBoard dao = new BoardDAO();
    	List<Board> list = dao.selectAll();
    	
    	for(Board b : list) {
    		System.out.println(b.getNum()+"--"+b.getName()+"--"+b.getWdate()+"--"+b.getTitle());
    	}
    	System.out.println("<------------------- Select One -------------------->");
    	Board tmp = dao.selectOne("21");
    	System.out.println(tmp.getNum()+"--"+tmp.getName()+"--"+tmp.getWdate()+"--"+tmp.getTitle());
    	
    	System.out.println("<------------------- delete -------------------->");
    	dao.delete("20"); //삭제
    	list = dao.selectAll();
    	for(Board b : list) {
    		System.out.println(b.getNum()+"--"+b.getName()+"--"+b.getWdate()+"--"+b.getTitle());
    	}
    	
    	System.out.println("<------------------- insert -------------------->");
    	dao.insert(new Board("20", "guest", "Mel Gibson", "", "게시판 연습20", "게시판연습입니다.", 0));
    	list = dao.selectAll();
    	for(Board b : list) {
    		System.out.println(b.getNum()+"--"+b.getName()+"--"+b.getWdate()+"--"+b.getTitle());
    	}
    	
    	System.out.println("<------------------- search -------------------->");
    	List<Board> add_list = dao.search("게시판 연습2");
    	for(Board b : add_list) {
    		System.out.println(b.getNum()+"--"+b.getName()+"--"+b.getWdate()+"--"+b.getTitle());
    	}
    }
}

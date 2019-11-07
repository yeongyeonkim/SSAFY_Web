package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트 한사람을 위한 세션을 생성하고, 세션안에 데이터 저장시키기
		String msg = "";
		HttpSession session = request.getSession(true);//세션이 없으면 새로 생성, 있으면 리턴
		
		if(session.isNew()) {
			session.setAttribute("apple", new int[] {0});//session에 data 저장
			session.setAttribute("tomato", new int[] {0});
		}
		//session에 저장된 데이터 꺼내기
		int[] apple = (int[])session.getAttribute("apple");
		int[] tomato = (int[])session.getAttribute("tomato");
		
		if(request.getParameter("apple") != null) {
			apple[0]++;
			msg = "사과를 쇼핑백에 추가했습니다.현재 쇼핑백안의 사과는 " +apple[0] + "개 입니다.";
		}else {
			tomato[0]++;
			msg = "토마토를 쇼핑백에 추가했습니다.현재 쇼핑백안의 토마토는 " +tomato[0] + "개 입니다.";
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<center><h1>쇼핑백에 추가</h1>");
		out.println(msg + "<hr>");
		out.println("<a href=ShopServlet>초기화면</a></center>");
		
	}

}










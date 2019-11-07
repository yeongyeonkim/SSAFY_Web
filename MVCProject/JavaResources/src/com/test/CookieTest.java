package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	  throws IOException, ServletException {
		
		response.setContentType("text/html;charset=KSC5601");
		PrintWriter out = response.getWriter();		

		//클라이언트로부터 서버거 저장했던 모든 쿠키를 얻어낸다.
		Cookie[] cookies = request.getCookies();
		
		if(cookies == null || cookies.length == 0) {//쿠키 없음
			return;
		}else{  // 쿠키가 하나라도 있을 때
			for(int i=0; i < cookies.length; i++) {			
				String cookieName = cookies[i].getName();				
				String cookieValue = cookies[i].getValue();
				out.println(cookieName+":"+cookieValue +"<BR>");
	   }	
			out.println("<html><body><center><h2>cookie test</h2></center>");
			out.println("<HR>");		
			out.println("<a href=CookieTest>visit again</a>");
			out.println("</body></html>");
		}		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	   throws IOException, ServletException {
	
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter(); //위 아래 순서 중요함. 한글 깨지지 않게하려면 ㅇㅇ

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		//Cookie 생성 login이름으로 id라는 값이 있
		Cookie idCookie = new Cookie("login", id);
		idCookie.setMaxAge(60*60*24*365);//cookie 유지시간 설정
		
		Cookie passCookie = new Cookie("pass", pass);
		passCookie.setMaxAge(-1);//-1 : 브라우저를 끄면 사라짐
		
		//응답 객체에 쿠키 추가
		response.addCookie(idCookie);
		response.addCookie(passCookie);

		out.println("<html><body>");
		out.println("<h1>쿠키에 정보를 저장했습니다.</h1>");
		out.println("<hr><a href=CookieTest>visit again</a>");//자기자신에 검. get방식
		out.println("</body></html>");   
	}

}
package com.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ContextTest")
public class ContextTest extends HttpServlet {
	/* ServletContext를 이용한 데이터 공유
	 * 여러개의 서블릿에서 데이터를 공유해야 할 경우에 Context parameter를 이용함
	 * web.mxl 파일에 기술한 context parameter를 이용해서 값을 전달 받음
	 * getServletContext(): ServletContext를 얻어오는 메소드
	 * 
	 * ServletConfig를 이용할 데이터 사용
	 * 서블릿 한 개마다 생성되는 ServletConfig 객체에 데이터를 저장하고 불러와서 사용
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		String id = context.getInitParameter("id");
		String pass =context.getInitParameter("pass");
		
		System.out.println("id: " + id);
		System.out.println("pass: " + pass);
		
		//-----------------------
		ServletConfig config = getServletConfig();
		String city = config.getInitParameter("city");
		String code = config.getInitParameter("code");
		System.out.println("city: " + city);
		System.out.println("code: " + code);
		
		
	}
}
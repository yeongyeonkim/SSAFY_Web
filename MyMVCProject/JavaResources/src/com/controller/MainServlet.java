package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.Algo;

//@WebServlet(urlPatterns= {"main/do"});
public class MainServlet extends HttpServlet {	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		process(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		process(req, res);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		
		req.setCharacterEncoding("utf-8");		
		String action = req.getParameter("action");		
		
		if(action == null){
			//res.sendRedirect("view/index.jsp");
			RequestDispatcher dis = req.getRequestDispatcher("view/index.jsp");
			dis.forward(req, res);
			return;		
		
		}else if(action.equals("q1")){//1번문제
			//parameter받아오기
			String num1 = req.getParameter("num1");
			String num2 = req.getParameter("num2");
			
			//Algo 문제풀이 객체 생성 후 메소드 호출해서 결과 받기
			Algo a = new Algo(num1, num2);
			int result = a.doJob();
			
			//결과 저장 후 jsp로 forward
			req.setAttribute("result", result);
			RequestDispatcher dis = req.getRequestDispatcher("view/result.jsp");
			dis.forward(req, res);
			
		}else if(action.equals("q2")){//2번문제
			
		}
	}
}
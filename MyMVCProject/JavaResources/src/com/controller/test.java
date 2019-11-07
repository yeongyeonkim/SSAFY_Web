package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.Algo;

@WebServlet("/test")
public class test extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req,res);
	}
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		if(action == null) {
			RequestDispatcher dis = req.getRequestDispatcher("/view/index.jsp");
			dis.forward(req, res);
			return;
		} else if(action.equals("q1")) {
			String num1 = req.getParameter("num1");
			String num2 = req.getParameter("num2");
			Algo a = new Algo(num1, num2);
			int result = a.doJob();
			req.setAttribute("result", result);
			RequestDispatcher dis = req.getRequestDispatcher("/view/result.jsp");
			try {
				dis.forward(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

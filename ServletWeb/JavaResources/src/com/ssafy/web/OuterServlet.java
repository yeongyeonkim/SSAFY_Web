package com.ssafy.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/outer.do")
public class OuterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>IncludeServlet</title>");
		out.print("</head>");
		out.print("<body>");
		
		out.print("<p>OuterServlet Start</p>");
		
		RequestDispatcher rd=request.getRequestDispatcher("/include.do");
		rd.include(request, response);
		
		out.print("<p>OuterServlet End</p>");
		out.print("</body>");
		out.print("</html>");
	}
}

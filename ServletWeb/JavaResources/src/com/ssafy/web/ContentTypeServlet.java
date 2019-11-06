package com.ssafy.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/content.do")
public class ContentTypeServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/xml");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("<customerlist>");
        out.print("<customer>");
        out.print("<name>희망이</name>");
        out.print("<address>서울</address>");
        out.print("<phone>0102245154</phone>");
        out.print("</customer>");
        out.print("</customerlist>");
		out.close();
	}
}

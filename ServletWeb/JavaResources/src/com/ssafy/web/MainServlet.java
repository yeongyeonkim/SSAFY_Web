package com.ssafy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet({ "/MainServlet", "/main.do" })
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			if (user.equals("ssafy") && pass.equals("1111")) {
				response.sendRedirect("Result.html");
			} else {
				response.sendRedirect("Login.html");
			}

		} else if (action != null && action.equals("register")) {
			String title = request.getParameter("title");
			String isbn = request.getParameter("isbn");
			String isbn2 = request.getParameter("isbn2");
			String isbn3 = request.getParameter("isbn3");
			String kind = request.getParameter("kind");
			String inout = request.getParameter("inout");			
			String pubdate = request.getParameter("pubdate");
			String pub = request.getParameter("pub");
			String author = request.getParameter("author");
			String cost = request.getParameter("cost");
			String mk = request.getParameter("mk");
			String ex = request.getParameter("ex");

			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<title>Book Result</title>");
			out.print("</head>");
			out.print("<body>");
			
			out.print("<div style=\"width:500px;\">");
			out.print("<div align=\"center\">");
			out.print("<h1>입력된 도서 정보</h1>");
			out.print("</div>");
			out.print("<div>");
			out.print("<table border='1' style=\"width:100%\">");
			out.print("<tr>");
			out.print("<td colspan='2' style=\"background-color: #e6e6e6; text-align: center;\">");
			out.print("도서정보 ");
			out.print("</td>");
			out.print("</tr>");
			
			out.print("<tr>");
			out.print("<td  style=\"background-color: #e6e6e6; text-align: center;\">");
			out.print("도서명");
			out.print("</td>");
			out.print("<td>");
			out.print(title);
			out.print("</td>");
			out.print("</tr>");
			
			out.print("<tr>");
			out.print("<td  style=\"background-color: #e6e6e6; text-align: center;\">");
			out.print("도서번호");
			out.print("</td>");
			out.print("<td>");
			out.print(isbn+"-"+isbn2+"-"+isbn3);
			out.print("</td>");
			out.print("</tr>");
			
			out.print("<tr>");
			out.print("<td style=\"background-color: #e6e6e6; text-align: center;\">");
			out.print("도서종류");
			out.print("</td>");
			out.print("<td>");
			out.print(kind);
			out.print("</td>");
			out.print("</tr>");
			
			out.print("<tr>");
			out.print("<td  style=\"background-color: #e6e6e6; text-align: center;\">");
			out.print("도서국가");
			out.print("</td>");
			out.print("<td>");
			out.print(inout);
			out.print("</td>");
			out.print("</tr>");

	
			
			out.print("<tr>");
			out.print("<td  style=\"background-color: #e6e6e6; text-align: center;\">");
			out.print("출판일");
			out.print("</td>");
			out.print("<td>");
			out.print(pubdate);
			out.print("</td>");
			out.print("</tr>");

			
			out.print("<tr>");
			out.print("<td style=\"background-color: #e6e6e6; text-align: center;\">");
			out.print("출판사");
			out.print("</td>");
			out.print("<td>");
			out.print(pub);
			out.print("</td>");
			out.print("</tr>");
		
			out.print("<tr>");
			out.print("<td  style=\"background-color: #e6e6e6; text-align: center;\">");
			out.print("저 자");
			out.print("</td>");
			out.print("<td>");
			out.print(author);
			out.print("</td>");
			out.print("</tr>");
		
			out.print("<tr>");
			out.print("<td  style=\"background-color: #e6e6e6; text-align: center;\">");
			out.print("도서가격");
			out.print("</td>");
			out.print("<td>");
			out.print(cost+mk);
			out.print("</td>");
			out.print("</tr>");
			
			
			out.print("<tr>");
			out.print("<td style=\"background-color: #e6e6e6; text-align: center;\">");
			out.print("도서설명");
			out.print("</td>");
			out.print("<td>");
			out.print(ex);
			out.print("</td>");
			out.print("</tr>");
			out.print("</table>");
			out.print("</div>");
			
			out.print("<div align=\"center\">");
			out.print("<p><a href='Book.html'>도서등록</p>");
			out.print("</div>");
			
			
			out.print("</div>");
			out.print("</body>");
			out.print("</html>");

		}
	}
}
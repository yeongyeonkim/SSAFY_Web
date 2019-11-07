package com.session;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet{
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
	
		 res.setContentType("text/html;charset=utf-8");
	  	 PrintWriter out = res.getWriter();
	  	 
	 	 out.println("<html><body bgcolor=pink><center>");
	 	 out.println("<p>shopping mall</p>");
	 	 out.println("<form name=form method=POST action=CartServlet>");
	 	 out.println("<p><input type=submit name=tomato value=쇼핑백에토마토넣기>");
	 	 out.println("<input type=submit name=apple value=쇼핑백에사과넣기>");
		 out.println("</form>");

		 out.println("<form name=form method=POST action=CheckOutServlet>");
	 	 out.println("<input type=submit name=see value=카트보기>");
	 	 out.println("<input type=submit name=buy value=주문하기></p>");
	 	 out.println("</form>");
	 	 out.println("</body></center></html>");
	 	 out.close();
	 	 }
  }






package com.db;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParamTest")
public class ParamTest extends HttpServlet {
	static int pid = 1; 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String pname = request.getParameter("pname");
		String price = request.getParameter("price");
		String description = request.getParameter("description");

		// 2.받은 값들로 객체에 저장하기
		Product p = new Product(pid++, pname, price, description);

		// 3.jsp로 forward 하기
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp"); // SendReD~와 다름, RequestDispatcher는
																					// url 주소가 변하지 않음
		request.setAttribute("data", p);
		rd.forward(request, response);

	}
}
package com.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 이전 서블릿에서 empid 받아오기
 * 테이블에서 해당 사번의 레코드 가져오기
 * 가져온 정보를 화면에 출력
*/
@WebServlet("/Detail")
public class Detail extends HttpServlet {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";
	String Query = "select empid, fname, phone, hdate, jobid, deptid, email  from emp where empid = ?";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement stat = con.prepareStatement(Query);
			stat.setString(1, request.getParameter("empid"));
			ResultSet rs = stat.executeQuery();
			rs.next(); // 이거안하면안돼요
			out.println("<h1>Employee Data</h1>");
			out.println("<table border=1>");

			String empid = rs.getString(1);
			String fname = rs.getString(2);
			String phone = rs.getString(3);
			String hdate = rs.getString(4);
			String jobid = rs.getString(5);
			String deptid = rs.getString(6);
			String email = rs.getString(7);

			out.println("");
			out.println("<tr><th>사  번</th><td>" + empid + "</td></tr>");
			out.println("<tr><th>이  름</th><td>" + fname + "</td></tr>");
			out.println("<tr><th>전  화</th><td>" + phone + "</td></tr>");
			out.println("<tr><th>입사일</th><td>" + hdate + "</td></tr>");
			out.println("<tr><th>업무ID</th><td>" + jobid + "</td></tr>");
			out.println("<tr><th>부서ID</th><td>" + deptid + "</td></tr>");
			out.println("<tr><th>이메일</th><td>" + email + "</td></tr>");

			out.println("</table>");
			out.println("<br><a href=JdbcServlet>back</a>");
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
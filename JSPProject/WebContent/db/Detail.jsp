<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%!
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";
	String Query = "select empid, fname, phone, hdate, jobid, deptid, email  from emp where empid = ?";
%>

	
<%
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement stat = con.prepareStatement(Query);
			stat.setString(1, request.getParameter("empid"));
			ResultSet rs = stat.executeQuery();
			rs.next(); // 이거안하면안돼요
			String empid = rs.getString(1);
			String fname = rs.getString(2);
			String phone = rs.getString(3);
			String hdate = rs.getString(4);
			String jobid = rs.getString(5);
			String deptid = rs.getString(6);
			String email = rs.getString(7);
%>
	
			<h1>Employee Data</h1>
			<table border=1>
			<tr><th>사  번</th><td><%=empid %></td></tr>
			<tr><th>이  름</th><td><%=fname %></td></tr>
			<tr><th>전  화</th><td><%=phone %></td></tr>
			<tr><th>입사일</th><td><%=hdate %></td></tr>
			<tr><th>업무ID</th><td><%=jobid %></td></tr>
			<tr><th>부서ID</th><td><%=deptid %></td></tr>
			<tr><th>이메일</th><td><%=email %></td></tr>

			</table>
			<br><a href=main.jsp>back</a>
			<%
			rs.close();
			stat.close();
			con.close();
			%>
		

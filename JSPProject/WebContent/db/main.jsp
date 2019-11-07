<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>


<%!String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";
	String Query = "select empid, fname from emp order by empid";
	
%>

<%
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, user, password);
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(Query);
%>
<h1>Employee Data</h1>
<table border=1>
	<%
		while (rs.next()) {
			String empid = rs.getString(1);
			String fname = rs.getString(2);
	%>
	<tr>
		<td><%=empid%></td>
		<td><a href=Detail.jsp?empid=<%=empid%>><%=fname%></a></td>
	</tr>
	<%
		}
	%>
</table>
<%
	rs.close();
	stat.close();
	con.close();
%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.ArrayList, com.model.Customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<center>
		<h1>Customer Data</h1>
		<%@ inlucde file="loginCheck.jsp"%>

		<table border="1">
			<c:forEach items="${list}" var="c">
				<tr>
					<td>${c.num }</td>
					<td><a href="read.cus?num=${c.num}">${c.name}</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href=insert.cus">새고객등록</a>
	</center>
</body>
</html>
<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Customer 데이터</h1>
<%@ include file="logincheck.jsp" %>

<%
	//controller가 보내 준 데이터 꺼내기
	ArrayList<Customer> list = (ArrayList<Customer>)request.getAttribute("list");
%>
<table border="1">
	<%for(Customer c: list){ %>
		<tr>
			<td><%= c.getNum() %></td>
			<td><a href="read.cus?num=<%=c.getNum()%>"><%= c.getName() %></a></td>
		</tr>
	<%} %>
</table>
<br>
<a href="insert.cus">add new data</a>
</body>
</html>


 -->










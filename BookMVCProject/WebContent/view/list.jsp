<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,com.model.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Book 데이터</h1>
<%@ include file="loginCheck.jsp" %>
<%
	// controller가 보내준 데이터 꺼내기
	ArrayList<Book> list = (ArrayList<Book>)request.getAttribute("list");
%>
<table border="1">
	<%
		for(Book c:list){
	%>
	<tr>
		<td><%=c.getIsbn() %></td>
		<td><a href="read.book?isbn=<%=c.getIsbn()%>"><%=c.getTitle() %></a></td>
	</tr>
	<%} %>
</table>
<br>
<a href="insert.book">add new data</a>
</body>
</html>
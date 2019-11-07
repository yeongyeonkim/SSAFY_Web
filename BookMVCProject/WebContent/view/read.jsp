<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,com.model.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Book 상세 데이터</h1>
<%
	// controller가 보내준 데이터 꺼내기
	Book c = (Book) request.getAttribute("c");
%>
<table border="1">
	<tr>
		<td><%=c.getIsbn() %></td>
		<td><%=c.getTitle() %></td>
		<td><%=c.getAuthor() %></td>
		<td><%=c.getPrice() %></td>
	</tr>
</table><br>
<a href="list.book">초기화면</a>&nbsp;&nbsp;&nbsp;
<a href="delete.book?num=<%=c.getIsbn() %>">삭제하기</a>
</body>
</html>
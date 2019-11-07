<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.model.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="logincheck.jsp" %>
<h1>추가된 Customer 데이터</h1>
<%
	//controller가 보내 준 데이터 꺼내기
	Customer c = (Customer)request.getAttribute("c");
%>
<table border="1">	
		<tr>
			<td><%= c.getNum() %></td>
			<td><%= c.getName() %></td>
			<td><%= c.getAddress()%></td>
		</tr>	
</table>
<br>
<a href="list.cus">초기화면</a>

</body>
</html>






















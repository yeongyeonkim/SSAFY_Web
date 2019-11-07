<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String login = (String)session.getAttribute("login");
	if(login != null){
%>
<%=login %>님! 환영합니다.<a href="logout.cus">로그아웃</a><br>

<%}else{ %>
<a href="login.cus">로그인</a><br>
<%} %>
</body>
</html>







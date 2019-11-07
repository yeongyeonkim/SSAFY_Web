<%@page import="com.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,com.model.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body bgcolor=pink><center>
	<h2>Product 검색</h2>
	<form action="../read.pro" >
	<input type="text" name="num" >
		<input type="submit"  value="검색"></form>
	
	<a href="view/main.jsp">main&nbsp;&nbsp;&nbsp;</a>
	
	</br>
</body>
</html>
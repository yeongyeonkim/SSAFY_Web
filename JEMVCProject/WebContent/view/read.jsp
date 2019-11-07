<%@page import="com.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,com.model.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td{
		text-align:center;
		padding: 1px;
	}
	
</style>
</head>
<body bgcolor=pink><center>
	<h2>Product 상세 데이터</h2>
	<table border="1"bgcolor=#d0def5>
 		<tr>
			<td style="width: 20px" >${c.num}</td>
			<td style="width: 50px" >${c.name}</td>
			<td style="width: 70px" >${c.price}</td>
		</tr>
		 
	</table>
	<br>
	<a href="view/main.jsp">back&nbsp;&nbsp;&nbsp;</a>
	<a href="delete.pro?num=${c.num}">삭제하기&nbsp;&nbsp;&nbsp;</a>
	</br>
</body>
</html>
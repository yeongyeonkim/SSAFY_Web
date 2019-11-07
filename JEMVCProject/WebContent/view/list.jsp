<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.util.ArrayList,com.model.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c</title>
<style type="text/css">
	td{
		text-align:center;
		padding: 1px;
	}
	
</style>
</head>
<body bgcolor=pink><center>
<h2>Product 데이터</h2>

<table border="1"bgcolor=#d0def5>
<c:forEach var="c" items="${list}">
  <tr>
            <td style="width: 20px" > ${c.num}</td> 
            <td style="width: 60px"><a href="read.pro?num=${c.num}"> ${c.name} </td>
        </tr>
</c:forEach>

</table>
<br>
<a href="view/main.jsp">add new data</a>
</body>
</html>
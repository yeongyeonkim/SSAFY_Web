<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<html>
<body><center>   

<h1>Customer Detail Data</h1>

<table border="1">

		<tr>
			<td>${c.num }</td>
			<td>${c.name }</td>
			<td>${c.address }</td>
		</tr>	
		
</table>
<p>
<a href="main.do?action=updateForm&num=${c.num}">수정하기</a>
<a href="main.do?action=delete&num=${c.num}">삭제하기</a>
</body>
</html>














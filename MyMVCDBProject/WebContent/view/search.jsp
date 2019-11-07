<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<html>
<body><center>   

<h1>Customer Search Data</h1>

<table border="1">
	<c:forEach items="${list }" var="c">
		<tr>
			<td>${c.num }</td>
			<td><a href="main.do?action=read&num=${c.num}">${c.name }</a></td>
		</tr>	
	</c:forEach>		
</table>

<a href="main.do?">초기화면</a>

</body>
</html>














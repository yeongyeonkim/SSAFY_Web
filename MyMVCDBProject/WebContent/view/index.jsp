<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<html>
<body><center>   

<h1>Customer Data</h1>
<jsp:include page="loginCheck.jsp"/>
<table border="1">
	<c:forEach items="${list }" var="c">
		<tr>
			<td>${c.num }</td>
			<td><a href="main.do?action=read&num=${c.num}">${c.name }</a></td>
		</tr>	
	</c:forEach>		
</table>

<a href="main.do?action=insertForm">새고객등록</a>
<p></p>
<form action="main.do?action=findByAddress" method="post">
	<input type="text" name ="address">
	<input type="submit" value="주소 검색">
</form>
</body>
</html>














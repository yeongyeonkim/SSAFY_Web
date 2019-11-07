<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>outer.jsp</h1>
<%@ include file="inner.jsp" %><!-- 복붙효과 -->

<br><br><br>

<%@ include file="inner.jsp" %><!-- 복붙효과 -->

<br><br><br>

<jsp:include page="inner2.jsp"/>
</body>
</html>
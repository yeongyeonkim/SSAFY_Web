<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 처리</title>
</head>
<body>
<jsp:useBean id="book" class="com.ssafy.model.domain.Book" scope="request" />
<jsp:setProperty property="*" name="book" />
<jsp:forward page="bookOutput.jsp" />
</body>
</html>
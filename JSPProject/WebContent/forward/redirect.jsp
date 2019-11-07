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
	// 이전 화면에서 보낸 값 받아서 체크 후 다음 화면으로 forward
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	if(id.equals("tom") && pass.equals("123")){
		response.sendRedirect("welcome.jsp");
	}else{
		response.sendRedirect("Login.html");
	}
	
%>
</body>
</html>
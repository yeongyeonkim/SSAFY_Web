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
		
%>

	<jsp:forward page="welcome.jsp"> <!-- forward를하면 주소창 값이 안바뀜. -->
	
	<!-- 지금상황에서는 사실 필요없음 같은 request를 사용하기떄문에 -->
	<jsp:param value="<%=id %>" name="id"/> 
	<!-- --- -->
	</jsp:forward>
<%
	}else{
%>
	<jsp:forward page="Login,html"/>

<%
	}
%>
</body>
</html>
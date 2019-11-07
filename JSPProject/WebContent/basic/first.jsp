<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="tomcat에 지시할 사항을 적는 부분" %> <!-- 주석으로 이내용이 들어감. 정보제공기능 -->
<%@ page import="java.util.ArrayList, java.util.Date" %>
<%@ page errorPage="error.jsp" %> <!-- 에러가 나면 에러페이지로 이동시킴 -->
<%-- jsp 주석: import 속성을 제외한 다른 속성(자주색 글자)은 두번 이상 사용하면 error 발생 --%>
<!-- html 주석: --><!-- jsp 파일에서는 jsp주석을 사용할것. jsp주석은 source코드로 반영이 되지않음 --> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>first jsp 입니다.</h1>
<%
	int count=99;
	out.print(count);
%>
</body>
</html>
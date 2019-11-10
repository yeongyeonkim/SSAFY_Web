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
	pageContext.setAttribute("name", "페이지 스콥");//페이지 스콥을 먼저 찾는다.
	request.setAttribute("name", "리퀘스트 스콥");//페이지 스콥이 없으면 리퀘스트 스콥
%>
리터널 : ${'Literals'}<br>
연산자 : ${ 8 > 3 }<br>
내장객체 : ${ header }<br>
내장객체 : ${ header['host'] }<br>
내장객체 : ${ header.host }<br>
파라미터 : ${ param }<br>
파라미터 : ${ param.name }<br>
파라미터 : ${ param.name }<br>
파라미터 : ${ param.hobby }<br>
파라미터 : ${ paramValues.hobby[0] }<br>
파라미터 : ${ paramValues.hobby[1] }<br>
파라미터 : ${ paramValues.hobby[2] }<br>
범위: ${name}<br> <!-- getAttribute 효과, 먼저 페이지스콥에서 찾는다. 
					없으면 리퀘스트스콥에서 찾음, 10번라인 주석처리해서 확인 -->
범위: ${pageScope.name}<br> <!-- pageScope에서 명시적으로 줘서 찾는 경우 -->
범위: ${requestScope.name}<br> <!-- requestScope에서 명시적으로 줘서 찾는 경우 -->
</body>
</html>
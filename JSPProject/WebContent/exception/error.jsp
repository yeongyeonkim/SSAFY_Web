<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- error 처리 페이지가 반드시 가져야 되는 지시어 속성 
내장 객체중 exception 객체를 사용할 수 있음--%>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<body>
<h1>예외 발생</h1>
예외 종류: <%=exception.getClass().getName() %><br>
메시지: <%=exception.getMessage() %><br>
<hr>
<h3>숫자를 입력해 주세요</h3>
</body>
</html>
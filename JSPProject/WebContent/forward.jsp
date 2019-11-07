<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user = request.getParameter("user");
	String pass = request.getParameter("pass");
	if(user.equals("ssafy") && pass.equals("1111")){
%>
	<jsp:forward page="LoginSuccess.jsp">
		<jsp:param value="<%= user %>" name="user"/>
	</jsp:forward>
<% }else { %>
	<jsp:forward page="error.jsp"/>
<%} %>
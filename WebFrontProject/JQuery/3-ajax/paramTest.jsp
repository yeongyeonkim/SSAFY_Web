<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//java code 적는 영역
	//name, address 받기
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	
	out.println("hello, " + name + "! you live in " + address);
%>
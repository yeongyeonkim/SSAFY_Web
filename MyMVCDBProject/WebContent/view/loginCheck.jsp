<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty id}">
	<a href="main.do?action=loginForm">로그인</a><br>
</c:if>

<c:if test="${!empty id}">
	welcome, ${id} !!!
	<a href="main.do?action=logout">로그아웃</a><br>
</c:if>
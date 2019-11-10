<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${param.user == 'member'}">
	<jsp:include page="Login.jsp"/>
</c:if>
<c:if test="${param.user == 'guest'}">
	<jsp:include page="memberRegister.html"/>
</c:if>
 <c:if test="${param.user != 'member' and param.user != 'guest'}">
 	잘못 입력했습니다. 다시 입력하세요.
 </c:if>
 <a href="test.html">다시 입력하기</a>

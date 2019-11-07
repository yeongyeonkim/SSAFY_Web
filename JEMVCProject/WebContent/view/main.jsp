<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상품 관리 메인</title>
<style type="text/css">
	input{
		width : 150px;
		height: 70px;
		font-weight : bold;
		margin: 10px;
		font-size: 15px;
		
	}
	form{
	
	display:inline;
	}
</style>
</head>
<body bgcolor=pink>
	<center>
		<h1>상품 관리 메인 페이지 입니다.</h1>
		<form action="../list.pro" >
		<input type="submit" name="list" value="상품 전체 조회"></form>
		<form action="insert.jsp">
		<input type="submit" name="insert"  value="상품 추가"></form><br>
		<form action="search.jsp">
		<input type="submit" name="search" value="상품 검색"></form>
		<form action="../delete.pro">
		<input type="submit" name="delete" value="상품 삭제"></form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ ���� ����</title>
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
		<h1>��ǰ ���� ���� ������ �Դϴ�.</h1>
		<form action="../list.pro" >
		<input type="submit" name="list" value="��ǰ ��ü ��ȸ"></form>
		<form action="insert.jsp">
		<input type="submit" name="insert"  value="��ǰ �߰�"></form><br>
		<form action="search.jsp">
		<input type="submit" name="search" value="��ǰ �˻�"></form>
		<form action="../delete.pro">
		<input type="submit" name="delete" value="��ǰ ����"></form>
</body>
</html>
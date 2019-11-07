<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h1>새로운 데이터 입력</h1>

<form action="insertProcess.book" method="post">
번호: <input type="text" id="isbn" name="isbn"><br>
제목: <input type="text" id="title" name="title"><br>
작가: <input type="text" id="author" name="author"><br>
가격: <input type="text" id="price" name="price"><br>
<input type="submit" value="등록">
</form>
</body>
</html>
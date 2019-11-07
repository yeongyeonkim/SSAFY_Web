<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body bgcolor=pink><center>
<h3>Product 추가 데이터</h3>
<br>
<form action="../insert.pro" bgcolor=#d0def5>
상품 번호: <input type="number" name="num"><br>
상품 명: <input type="text" name="name"><br>
상품 가격: <input type="text" name="price"><br>
<input type="submit" value="저장"> <input type="reset" value="취소">
<br><a href="view/main.jsp">초기화면</a>
</form>
</body>
</html>
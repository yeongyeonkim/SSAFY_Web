<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>�α���</h1>
	<!-- property�� �ִ� Context root������ �ٲ��־����
		 /customer/CookieTest �̺κп��� customer -->
	<form action="/customer/CookieTest" method="post" id="f">
		���̵�:<input type="text" name="id" id="id"><br> 
		�н�����:<input type="password" name="pass" id="pass"><br> 
		
		<input type="reset"	value="���"> 
		<input type="submit" value="����">
	</form>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 : ${param.id} <br/>
	취미 : ${paramValues.hobby[0]}
		, ${paramValues.hobby[1]}
		, ${paramValues.hobby[2]}<br/>
		
	쿠키 정보 : ${cookie.address.value}		
</body>
</html>




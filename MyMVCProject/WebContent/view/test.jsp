<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1, h4 {
	text-align: center;
}
a {
	margin: 10px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#q1').click(function(){
			$.ajax({
				url:'main.do?action=q1',
				data:{
					num1 : $('#num1').val(),
					num2 : $('#num2').val()
				},
				success: function(result){
					$('#display').html('<h3>' + result + '</h3>');
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>메인 페이지</h1>
	<p />

	num1:
	<input type="text" name="num1" id="num1"> num2:
	<input type="text" name="num2" id="num2">
	<button id="q1">get-1</button>
	<hr>
	num3:
	<input type="text" name="num3" id="num3"> num4:
	<input type="text" name="num4" id="num4">
	<button id="q2">get-2</button>
	<div id="display"></div>
</body>
</html>
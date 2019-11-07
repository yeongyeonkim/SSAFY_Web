<%@ page contentType="text/html;charset=utf-8" %>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#q1').click(function(){
			//ajax 요청 보내기
			$.ajax({
				url:'main.do?action=q1', //파라메타 달아서 보낼 것
				data: { // client에서 server로 보낼 데이터
					num1: $('#num1').val(),//★
					num2: $('#num2').val()
				},
				success: function(result){
					$('#display').html('<h3>'+result+'</h3>');//★ id가 display인곳에 값을 넣으세요?
							//div나 span에 뿌리는 거라 html라고 씀.
				}//server에서 성공적으로 응답이 도착 했을 때
			});
		});
	});
	
</script>
</head>
<body>
<h1> 메인 페이지 </h1>
<p/>

num1:	<input type="text" name="num1" id="num1">
num2:	<input type="text" name="num2" id="num2">
<button id="q1">get-1</button> 
<hr>
num3:	<input type="text" name="num3" id="num3">
num4:	<input type="text" name="num4" id="num4">
<button id="q2">get-2</button> 
<div id="display"></div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<html>
<body><center>   

<h1>Customer Update Data</h1>

<form action="main.do?action=updateProcess" method="post">
	<table border="1">
		<tr>
			<td>번호</td>
			<td><input type="number" class="form-control" name="num" value = "${num}" readonly="readonly"/></td>	
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" class="form-control" name="address" placeholder="주소를 입력하세요." required="required"/></td>	
		</tr>	
	</table>
	
	<input type="submit" value="수정">
</form>

<p>
<a href="main.do">초기화면</a>

</body>
</html>














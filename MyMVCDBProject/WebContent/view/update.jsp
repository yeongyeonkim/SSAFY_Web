<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<html>
<body><center>   

<h1>Customer Update Data</h1>

<form action="main.do?action=updateProcess" method="post">
	<table border="1">
		<tr>
			<td>��ȣ</td>
			<td><input type="number" class="form-control" name="num" value = "${num}" readonly="readonly"/></td>	
		</tr>
		<tr>
			<td>�ּ�</td>
			<td><input type="text" class="form-control" name="address" placeholder="�ּҸ� �Է��ϼ���." required="required"/></td>	
		</tr>	
	</table>
	
	<input type="submit" value="����">
</form>

<p>
<a href="main.do">�ʱ�ȭ��</a>

</body>
</html>














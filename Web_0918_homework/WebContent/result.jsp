<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.db.Product"%>
<% Product p = (Product)request.getAttribute("data");%>
	<form id="bookForm" action="/Web_0918_homework/ParamTest" method="post">
		<div style="width: 400px; border: 1px solid #000">
			<div>
				<h1 style="text-align: center;">상품을 등록 해 주세요.</h1>
			</div>
			<div>
				<table>
				<tr>
					<td>상품번호: <%= p.getPid() %> <br></td>
				</tr>
					<tr>
						<td>상 품 명 : <%= p.getPname() %><br></td>
					</tr>
					<tr>
						<td>상품가격 : <%= p.getPrice() %><br></td>
					</tr>
					<tr>
						<td>상품설명 : <%= p.getDescription() %><br></td>
					</tr>
				</table>
			</div>
			<a href="">상품 목록</a>
		</div>
	</form>
</body>
</html>



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<% request.setCharacterEncoding("utf-8"); %>
<%
	String title = request.getParameter("title");
	String isbn1 = request.getParameter("isbn1");
	String isbn2 = request.getParameter("isbn2");
	String isbn3 = request.getParameter("isbn3");
	String catalogue = request.getParameter("catalogue");
	String nation = request.getParameter("nation");
	String publishDate = request.getParameter("publishDate");
	String publisher = request.getParameter("publisher");
	String author = request.getParameter("author");
	String price = request.getParameter("price");
	String description = request.getParameter("description");
%>
<div style="width:500px;\">
	<div align="center">
			<h1>입력된 도서 정보</h1>
		</div>
		<div>
			<table border='1' style="width:100%">
				<tr>
					<td colspan='2' style="background-color: #e6e6e6; text-align:center;">도서정보</td>
				</tr>
				<tr>
					<td style="background-color: #e6e6e6; text-align:center;">도서명</td>
					<td><%=request.getParameter("title") %></td>
				</tr>
				<tr>
					<td style="background-color: #e6e6e6; text-align:center;">도서번호</td>
					<td><%=isbn1%>-<%=isbn2%>-<%=isbn3%></td>
				</tr>
				<tr>
					<td style="background-color: #e6e6e6; text-align:center;">도서종류</td>
					<td><%=catalogue %></td>
				</tr>
				<tr>
					<td style="background-color: #e6e6e6; text-align:center;">도서국가</td>
					<td><%=nation%></td>
				</tr>
				<tr>
					<td style="background-color: #e6e6e6; text-align:center;">출판일</td>
					<td><%=publishDate %></td>
				</tr>
				<tr>
					<td style="background-color: #e6e6e6; text-align:center;">출판사</td>
					<td><%=publisher%></td>
				</tr>
				<tr>
					<td style="background-color: #e6e6e6; text-align:center;">
						저 자</td>
					<td><%=author %></td>
				</tr>
				<tr>
					<td style="background-color: #e6e6e6; text-align:center;">도서가격</td>
					<td><%=price%></td>
				</tr>
				<tr>
					<td style="background-color: #e6e6e6; text-align:center;">도서설명</td>
					<td><%=description %></td>
				</tr>
			</table>
		</div>
		<div align="center"><p>
				<a href='Book.jsp'>도서등록</a></p>
		</div>
	</div>
</body>
</html>

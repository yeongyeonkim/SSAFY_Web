<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
	<%--
		$(document).ready(function() {
			$('.preview').mouseenter(function() {
				var id = $(this).attr('id');
				//alert($('id'));
				$.ajax({
					url : 'content.bod?id=' + id,

					success : function(result, status) {
						$('#preview').css("visibility", "visible");
						$('#preview').html(result);
					}
				})
			});

			$('.preview').mouseleave(function() {
				var id = $('.preview').attr('id');
				$('#preview').css("visibility", "hidden");
			});

		})
		--%>
		$(document).ready(function() {
			$('.preview').mouseover(function() {
				$.ajax({
					url : 'read2.bod',
					success : function(result) {
						$('#display').html("<h3>" + result + "</h3>");
						$('#display').css('visibility', 'visible');
					},
					data : {
						num : $(this).attr('id')
					}
				});
			});
		});
	</script>
	<center>
		<h1>JSP 게시판</h1>
		<!-- <div id="display" style="visibility: hidden;"> -->
		<div id="preview" style="visibility: hidden;">
			<h3>result</h3>
		</div>
		<TABLE BORDER=1 CELLSPACING=1 CELLPADDING=1>
			<TR>
				<th width=100 bgcolor=#113366><font color=#ffffee size=2>번호</th>
				<th width=200 bgcolor=#113366><font color=#ffffee size=2>제목</th>
				<th width=100 bgcolor=#113366><font color=#ffffee size=2>글쓴이</th>
				<th width=150 bgcolor=#113366><font color=#ffffee size=2>날짜</th>
				<th width=100 bgcolor=#113366><font color=#ffffee size=2>조회수</th>

				<c:forEach items="${list}" var="b">
					<tr bgcolor=pink>
						<td align=center bgcolor=pink>&nbsp;<font size=2>${b.num}</td>
						<td align=center bgcolor=pink>&nbsp;<font size=2><a
								href="read.bod?num=${b.num}" id="${b.num}" class="preview">${b.title }</td>
						<td align=center bgcolor=pink>&nbsp;<font size=2>
								${b.name }</td>
						<td align=center bgcolor=pink>&nbsp;<font size=2>${b.wdate }</td>
						<td align=center bgcolor=pink>&nbsp;<font size=2>${b.count}</td>
					</tr>
				</c:forEach>
		</table>
		<br></br> <a href=insertForm.bod>새글쓰기</a>
</body>
</html>
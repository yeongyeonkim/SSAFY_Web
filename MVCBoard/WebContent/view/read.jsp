<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><body><center>	
<h1>글 읽기 </h1><p>

<TABLE BORDER=2 CELLSPACING=2 CELLPADDING = 2>
	 
 		<TR>
				<TH WIDTH=200>NUM</TH><TD  width=300 align=center>${c.num}</TD>
				<TH WIDTH=300>NAME</TH><TD width=300 align=center>${c.name }</TD>
		</TR> 
		<TR><TH WIDTH=200>DATE</TH><TD width=300 align=center>${c.wdate }</TD>
					<TH WIDTH=300>COUNT</TH><TD width=300 align=center>${c.count }</TD>
		</TR>
		<TR>
					<TH WIDTH=200>TITLE</TH>
					<TD COLSPAN=3>${c.title }</TD>
		</TR>
		<TR>
					<TH WIDTH=200>CONTENT</TH>
			<TD COLSPAN=3><textarea readonly cols=120 rows=20>${c.content }</textarea></TD>
		</TR> 		
	</TABLE><br>
	<br><a href="list.bod">전체화면</a>&nbsp;&nbsp;&nbsp;	
	<br><a href="delete.bod?num=${c.num}">삭제하기</form>&nbsp;&nbsp;&nbsp;	
	</center></body></html>
</table>

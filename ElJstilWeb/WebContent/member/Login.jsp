<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 .errormsg{
 	font-size:  14px;
 	color:red;
 }
</style>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	String id="";
	String checked="";
	if(cookies!=null){
		for(Cookie cookie: cookies){
			if(cookie.getName().equals("id")){
				id = cookie.getValue();
				checked="checked='checked'";
			}
		}
	}
	String loginId = (String)session.getAttribute("id");
	if(loginId != null){  //로긴 된 상황  %>
	<p><%=loginId %>님 환영합니다. 
	   <a href="logout.do">로그아웃</a>
	</p> 
	<%}else{  //로그인이 되지 않은 상황 
		String msg = (String)request.getAttribute("msg");
	%>	
	<form method="post"  action="sessionlogin.do">
	<table align="center" border="1">
	    <%if(msg !=null){ %>
		 <tr><td colspan='2' class='errormsg'><%=msg %></td></tr>					
	    <%}%>
		<tr><td>아 이 디</td>
		<td><input type="text" name="id" value="<%=id%>"></td></tr>
		<tr><td>비밀번호</td>
		<td><input type="password" name="password"></td></tr>
		<tr>
			<td colspan="2"  align="right">
			  아이디 저장<input type="checkbox" name="idsave" value="t"  <%=checked%> />
			  <input type="submit" value="로그인">
			</td>
		</tr>
	</table>
</form>
<%}%>
</body>
</html>

	






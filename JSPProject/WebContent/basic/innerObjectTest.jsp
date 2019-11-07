<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 내장객체 : jsp에서 미리 준비된 객체들, scriptlet이나 식(expression)에서만 사용가능
선언에서는 사용 불가
--%>
<%!
    public void hello(JspWriter o) throws Exception {
        o.println("hello");
    }
%>
<%
    int cnt = 99;
    out.println(cnt);
    hello(out);
%>
<hr>
<%= ++cnt %>
</body>
</html>
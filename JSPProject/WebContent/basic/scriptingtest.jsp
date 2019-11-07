<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	//선언(declaration):멤버 필드나 메소드 선언시 사용
	int count =100;
	public String hello(String name){
		return "hello,," + name;
	}
%>

<%-- 식: 출력(변수, 메소드 호출 결과, 계산 값 등), ;을 붙이지 않는다. --%>
count:<%= count %><br>
hello(): <%=hello("tommy") %><br>

<%--스크립트렛(scriptlet): 자바코드 적는 영역 --%><%--영어 단어 뒤에 let이 붙는건 servlet의 let임(작다는의미) --%>
<%-- 되도록이면 스크립트렛을 사용하지말고 식을 사용하는것이 좋다. scriptlet은 jsp -> java로 변환하는데 낭비가심하기 떄문에 --%>
<%
	int num = 123; // 지역변수임
	out.println(++num);
%>
<hr>
count: <%= ++count %><br>
</body>
</html>
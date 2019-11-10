<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.util.ArrayList,com.ssafy.model.domain.Goods"
    %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<%
    String[] prices={"5000","3000","10000","500"};

    String  price2="5000,3000,10000,500";
	ArrayList<Goods> list = new ArrayList<Goods>();
	list.add(new Goods(1,"a1",5000,10,0));
	list.add(new Goods(2,"a2",10000,100,0));
	list.add(new Goods(3,"a3",3000,50,0));
	list.add(new Goods(4,"a4",50000,200,0));
	
	pageContext.setAttribute("price2", price2);
	pageContext.setAttribute("prices", prices);
	pageContext.setAttribute("list", list);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach  var="price"  items='${prices}'>
		${price},  ${price*30} <br/>
	</c:forEach>
	<hr/>
	${price2}<br/>
	<c:forEach  var="p"  items='${price2}'>
		${p},  ${p*3} <br/>
	</c:forEach>
	<c:forEach  var='g' items='${list}' varStatus='seq'>
	    순번: ${seq.count}
		이름: ${g.proname}
		단가: ${g.proprice}
		수량: ${g.quantity}
		금액: ${g.total}<br/>
	</c:forEach>
	<c:forEach  var='g' items='${list}' varStatus='seq'
	            begin='1'  end='3'  step='2'>
	    순번: ${seq.count}
		이름: ${g.proname}
		단가: ${g.proprice}
		수량: ${g.quantity}
		금액: ${g.total}<br/>
	</c:forEach>
	
</body>
</html>





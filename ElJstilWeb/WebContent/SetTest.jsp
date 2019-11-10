<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
<jsp:useBean id="goods" class="com.ssafy.model.domain.Goods" 
             scope='request' />
<c:set target="${goods}" property='quantity' value='5000'/> 
<c:set target="${goods}" property='proname'  value='맛있는 모과차'/> 
<c:set var='price'  value='5000'/>            
<!DOCTYPE html>
<html><head><meta charset="UTF-8"><title>Insert title here</title></head>
<body>
상품이름 : ${goods.proname} <br/>
상품수량 : ${goods.quantity}<br/>
단가 :${price}</br>
<c:set  var='total'   value='${total+goods.quantity*price}'/>	
총 가격 : ${total}<br>
<c:remove var="total"/>
total 삭제후 : ${total}<br>
</body>
</html>
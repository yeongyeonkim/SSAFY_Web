<%@page import="com.safe.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
<!-- META TAG ================================================ -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap4.3.1 css ====================================== -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- MDB ==================================================== -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.6.1/css/mdb.min.css" rel="stylesheet">
<!-- Additional Stylesheet =============================== -->
<link rel="stylesheet" href="css/Info.css">
<!-- Font Download (https://fonts.google.com/) ================ -->
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding&amp;subset=korean" rel="stylesheet">
<!-- Icon Pack Download (https://fontawesome.com/)========== -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>
<!-- /HEAD ==================================================== -->
<!-- ========================================================== -->
<!-- ========================================================== -->
<!-- BODY  ==================================================== -->
<body>
	<header>
		<!-- Navbar =============================================== -->
		<c:if test="${empty s_id}">
			<c:import url="/view/navbar_bf.jsp" charEncoding="utf-8"></c:import>
		</c:if>
		<c:if test="${not empty s_id}">
			<c:import url="/view/navbar_af.jsp" charEncoding="utf-8"></c:import>
		</c:if>
		<!-- /Navbar ================================================ -->
		<!--Carousel Wrapper ======================================== -->
		<div id="main_carousel" class="carousel">
			<div class="carousel-inner ">
				<div class="view" style="background-image: url('img/index_food6.jpg'); background-repeat: no-repeat; background-size: cover; background-position: bottom;">
					<!-- Mask & flexbox options-->
					<div class="mask rgba-black-light d-flex justify-content-center align-items-center">
						<div class="text-center white-text mx-5 wow fadeIn">
							<h1 class="mb-2">
								<strong>회원정보</strong>
							</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /Carousel Wrapper ==================================== -->
	</header>

	<!--Main layout =============================================== -->
	<main>
	<div class="container wrapper mx-auto">
		<div class="mx-auto text-center">
			<br>
			<span class="mt-2">
				<span>아이디:&nbsp;</span> ${mem.id}
			</span>
			<br>
			<span class="mt-2">
				<span>이름:&nbsp;</span> ${mem.name}
			</span>
			<br>
			<span class="mt-2">
				<span>주소:&nbsp;</span> ${mem.address}
			</span>
			<br>
			<span class="mt-2">
				<span>전화번호:&nbsp;</span> ${mem.phone}
			</span>
			<br>
			<span class="mt-2">
				<span>알러지:&nbsp;</span> ${mem.allergy}
			</span>
			<br>
			​
			<div class="row justify-content-center">
				<button class="btn btn-lg  rgba-green-strong" type="button" onclick = "location.href = 'memView.food?action=edit' ">회원정보 수정</button>
				<button class="btn btn-lg  rgba-green-strong" type="button" onclick = "location.href = 'memList.food'">회원목록 보기</button>
			</div>
		</div>
	</div>
	</main>
	<!--/Main layout ============================================== -->
	<!-- footer =================================================== -->
	<footer class="page-footer text-center font-small mt-4 wow fadeIn">
		<div class="footer-copyright py-3">
			© 2019 Copyright:
		</div>
	</footer>
	<!-- /footer ================================================== -->
	<!-- ========================================================== -->
	<!-- JavaScript CDN LIST ====================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- jQuery 3.4.1 ============================================= -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<!-- Popper.js 1.14.3 ========================================= -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<!-- Bootstrap 4.1.3 ========================================== -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.6.0/js/mdb.min.js"></script>
	<!-- /JavaScript CDN LIST ===================================== -->
	<!-- ========================================================== -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RECIPE</title>

<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">
<link href="https://fonts.googleapis.com/css?family=Single+Day&display=swap&subset=korean"
	  rel="stylesheet">
</head>

<body>
	<div>
		<header>
			<div id="con1">
				<nav class="dropdown">
					<button class="button" >
						<c:if test = "${user eq null }">
							<img src="img/home/logout.png" >
						</c:if>
						<c:if test = "${user ne null }">
							<img src="img/home/login.png" >
						</c:if>
					</button>
					<div class="dropdown-content" >
					<ul class="nav">
						<a href="myPage.do">마이페이지</a>
						<a href="#">스크랩한 레시피</a>
						<a href="#">레시피 노트</a>
						<a href="#">알림</a>
						<a href="#">메시지</a>
						<a href="#">문의내역</a>
						<a href="#">주문조회</a>
						<a href="#">장바구니</a>
						<c:if test="${m_id eq null }">
							<a href="login.do">로그인</a>
						</c:if>
						<c:if test="${m_id ne null }">
							<a href="update.do">회원정보수정</a>
							<a href="logOut.do">로그아웃</a>
							<a href="delete.do">회원탈퇴</a>
						</c:if>
					</ul>
				</div>
			</nav>
			<div id="topnav" class="topnav" > 
				<a href="home.do">홈</a>
				<a href="cook.do">레시피</a>
				<a href="boardList.do">게시판</a>
				<a href="store.do">스토어</a>
				<a href="refrigerator.do">냉장고</a>
				<div class="login-container">
					<c:if test="${user eq null }">
						<form action="loginPro.do" method = "post">
							<input type="text" placeholder="아이디" name="m_id">
							<input type="password" placeholder="비밀번호" name="m_pw">
							<input type="submit" value="로그인">
							<!-- <button type="submit">Login</button> -->
						</form>
					</c:if>
					<c:if test="${user ne null }">
						<div class = "login-success">${user.getM_nickname() } 님</div>
					</c:if>
				</div>
			</div>
				
			<script>
				window.onscroll = function() {myFunction()};

				var navbar = document.getElementById("navbar");
				var sticky = navbar.offsetTop;

				function myFunction() {
				  if (window.pageYOffset >= sticky) {
				    navbar.classList.add("sticky");
				  } else {
				    navbar.classList.remove("sticky");
				  }
				}
			</script>
			</div>
	
		</header>
	</div>
</body>
</html>
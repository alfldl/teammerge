<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="r_css/css_main/main.css" rel="stylesheet" type="text/css">
</head>

<body>

	<div id="wrap" >
		
			<div id="con1">
			<nav class="dropdown">
				<button class="button" ><img src="r_img/img_main/img22.jpg" ></button>
			
				<div class="dropdown-content" >
				<ul class="nav">
					
					<a href="#">마이페이지</a>
					<a href="#">스크랩한 레시피</a>
					<a href="#">레시피 노트</a>
					<a href="#">알림</a>
					<a href="#">메시지</a>
					<a href="#">문의내역</a>
					<a href="#">주문조회</a>
					<a href="#">장바구니</a>
					<a href="#">회원정보수정</a>
					<a href="r_main/loginForm.jsp">로그인</a>
				</ul>
				</div>
			</nav>
			<div id="topnav" class="topnav" > 
			
					<a href="home.do">홈</a>
					<a href="recipe.do">레시피</a>
					<a href="#">게시판</a>
					<a href="#">스토어</a>
					<a href="#">냉장고</a>
					<div class="login-container">
					<form action="login.do">
					<input type="text" placeholder="아이디" name="m_id">
					<input type="text" placeholder="비밀번호" name="m_pw">
					<button type="submit">Login</button>
					</form>
					
			
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
	

		<div id=gongback1></div>
		<section id=main>
			<div id=today>
				<section class=gallery>
					<p1><link href="https://fonts.googleapis.com/css?family=Jua&display=swap&subset=korean" rel="stylesheet">오늘 뭐먹지?</p1>
					<div id="gallery_box">
						<div id="gallery_list">
							<div class="items">
								<ul>
								<c:forEach var="cook" items="${list }"  varStatus="vs" >
									    <c:if test="${randomValue1 == vs.index}">
											<li><img src="${pageContext.request.contextPath }/save/${cook.c_img}.jpg"></li>
											<li>${cook.c_name }</li>
										</c:if>
								</c:forEach>
																		
								</ul>
								
							</div>
							<div class="items">
								<ul>
									<c:forEach var="img" items="${list }"  varStatus="vs" >
									    <c:if test="${randomValue2 == vs.index}">
											<li><img src="${pageContext.request.contextPath }/save/${img.c_img}.jpg"></li>
											<li>${img.c_name }</li>
										</c:if>
										</c:forEach>
								</ul>
							</div>
							<div class="items">
								<ul>
									<c:forEach var="img" items="${list }"  varStatus="vs" >
									    <c:if test="${randomValue3 == vs.index}">
											<li><img src="${pageContext.request.contextPath }/save/${img.c_img}.jpg"></li>
											<li>${img.c_name }</li>
										</c:if>
										</c:forEach>
								</ul>
							</div>
							<div class="items">
								<ul>
									<c:forEach var="img" items="${list }"  varStatus="vs" >
									    <c:if test="${randomValue4 == vs.index}">
											<li><img  src="${pageContext.request.contextPath }/save/${img.c_img}.jpg"></li>
											<li>${img.c_name }</li>
										</c:if>
										</c:forEach>
								</ul>
								
							</div>
							<div class="items">
								<ul>
									<c:forEach var="img" items="${list }"  varStatus="vs" >
									    <c:if test="${randomValue5 == vs.index}">
											<li><img  src="${pageContext.request.contextPath }/save/${img.c_img}.jpg"></li>
											<li>${img.c_name }</li>
										</c:if>
										</c:forEach>
								</ul>
							</div>
								
								</div>
						<!-- galley_list -->
					</div>
					<!-- gallery_box -->
				</section>
			</div>
			<div id=gongback2></div>
			<div id=best>
				<section class=gallery>
				<p2><link href="https://fonts.googleapis.com/css?family=Jua&display=swap&subset=korean"  rel="stylesheet">레시피 Best</p2>
					<div id="gallery_box">
						<div id="gallery_list">
							<div class="items">
								<ul>
									<li><img src="r_img/img_main/img8.jpg"></li>
									<li>양념치킨</li>
								</ul>
							</div>
							<div class="items">
								<ul>
									<li><img src="r_img/img_main/img9.jpg"></li>
									<li>계란말이</li>
								</ul>
							</div>
							<div class="items">
								<ul>
									<li><img src="r_img/img_main/img10.jpg"></li>
									<li>잡채</li>
								</ul>
							</div>
							<div class="items">
								<ul>
									<li><img src="r_img/img_main/img11.jpg"></li>
									<li>일본식 카레</li>
								</ul>
							</div>
							<div class="items">
								<ul>
									<li><img src="r_img/img_main/img12.jpg"></li>
									<li>냉이된장국</li>
								</ul>
							</div>
						</div>
						<!-- galley_list -->
					</div>
					<!-- gallery_box -->
				</section>
			</div>
			<div id=gongback2></div>
			<div id=store>
				<section class=gallery>
					<p3><link href="https://fonts.googleapis.com/css?family=Jua&display=swap&subset=korean"  rel="stylesheet">쇼핑몰 Best</p3>
					<div id="gallery_box">
						<div id="gallery_list">
							<div class="items" >
								<ul>
									<li><a href="https://www.11st.co.kr/html/main.html?gclid=CjwKCAjwsMzzBRACEiwAx4lLG1wOMi2MCAMBhijuuxfOEC27vrhiHwdn1dgTundW9j-U4_SQgGQLXRoCbtIQAvD_BwE?code=1020&utm_term=11QJSRK&utm_campaign=0829_%B1%B8%B1%DB11&utm_source=%B1%B8%B1%DB_PC_S&utm_medium=%B0%CB%BB%F6">
									<img src="r_img/img_main/img13.jpg" ></a></li>
									<li>11번가</li>
								</ul>
							</div>
							<div class="items">
								<ul>
									<li><a href="https://www.coupang.com/np/categories/393760">
									<img src="r_img/img_main/img15.jpg"></a></li>
									<li>쿠팡</li>
								</ul>
							</div>
							<div class="items">
								<ul>
									<li><a href="http://shopping.interpark.com/display/main.do?dispNo=001760&smid1=gnb&smid2=003&smid3=1">
									<img src="r_img/img_main/img16.jpg"></a></li>
									<li>인터파크</li>
								</ul>
							</div>
							<div class="items">
								<ul>
									<li><a href="http://corners.gmarket.co.kr/ExpressShop">
									<img src="r_img/img_main/img17.jpg"></a></li>
									<li>지마켓</li>
								</ul>
							</div>
							<div class="items">
								<ul>
									<li><a href="http://www.auction.co.kr/category/category51.html">
									<img src="r_img/img_main/img18.jpg"></a></li>
									<li>옥션</li>
								</ul>
							</div>
						</div>
						<!-- galley_list -->
					</div>
					<!-- gallery_box -->
				</section>
			</div>
		</section>
		<!-- main section-->
		<div id=gongback1>
		</div>
	
		<footer>
		<form action="">
		<input class="a" type="text" placeholder="불편사항이나 제안사항이 있으신가요? 레시피를 부탁해에 전하고 싶은 의견을 남겨주세요."><br>
		<input  class="b" type="submit" value="의견제출">
		</form>
				
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
		</footer>

	</div>
	<!-- div wrap-->

<div>

</div>
</body>
</html>
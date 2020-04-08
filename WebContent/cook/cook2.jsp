<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/recipe.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="gong"></div>
	<div class="grid_con">
		<div class="con1">
			<div id="cate_box">
				<div id="cate_list">
					<div class="cate_items">
						<ul>
							<a href="cook2.do?category=한식&pageNum=1"><label><li><img
										src="img/recipe/1.PNG"></li>
									<li>한식</li></label></a>
						</ul>
					</div>
					<div class="cate_items">
						<ul>
							<a href="cook2.do?category=중식&pageNum=1"><label><li><img
										src="img/recipe/2.PNG"></li>
									<li>중식</li></label></a>
						</ul>
					</div>
					<div class="cate_items">
						<ul>
							<a href="cook2.do?category=일식&pageNum=1"><label><li><img
										src="img/recipe/3.PNG"></li>
									<li>일식</li></label></a>
						</ul>
					</div>
					<div class="cate_items">
						<ul>
							<a href="cook2.do?category=양식&pageNum=1"><label><li><img
										src="img/recipe/4.PNG"></li>
									<li>양식</li></label></a>
						</ul>
					</div>
					<div class="cate_items">
						<ul>
							<a href="cook2.do?category=퓨전&pageNum=1"><label><li><img
										src="img/recipe/5.PNG"></li>
									<li>퓨전</li></label></a>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="con2">
			<div id="recipe_box">
				<div id="recipe_list">
					<c:forEach var="cook" items="${list }">
						<div class="recipe_items">
							<ul>
								<li>${cook.c_no }</li>
								<a
									href="cookContent.do?c_no=${cook.c_no }&pageNum=${currentPage}"><label><li><img
											src="${pageContext.request.contextPath }${cook.c_img }"></li>
										<li><b>${cook.c_name }</b></li></label></a>
								<li>by.${cook.m_nickname }</li>
								<li id="vc">조회수 : ${cook.c_hits }</li>
							</ul>
						</div>
						<c:set var="startNum" value="${startNum -1 }" />
					</c:forEach>
				</div>
			</div>
			<div id="pageNum">
				<c:if test="${startPage > blockSize }">
					<a
						href='cook2.do?category=${c_category }&pageNum=${startPage-blockSize}'>[<<]</a>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<a href='cook2.do?category=${c_category }&pageNum=${i}'>[${i }]</a>
				</c:forEach>
				<c:if test="${endPage < pageCnt }">
					<a
						href='cook2.do?category=${c_category }&pageNum=${startPage+blockSize }'>[>>]</a>
				</c:if>
				<div id="writer">
					<center>
						<c:if test="${m_id eq null }">
							<input type="button" value="글쓰기"
								onclick="location.href='login.do'">

						</c:if>
						<c:if test="${m_id ne null }">
							<input type="button" value="글쓰기"
								onclick="location.href='cookWriter.do?pageNum=${pageNum }'">
						</c:if>
					</center>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>
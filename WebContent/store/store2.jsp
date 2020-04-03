<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/recipe.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="grid_con">
		<div class="con1">
			<div id="cate_box">
				<div id="cate_list">
					<div class="cate_items">
						<ul>
							<a href="#"><label><li><img
										src="img/store/noodle.png"></li>
									<li>면류</li></label></a>
						</ul>
					</div>
					<div class="cate_items">
						<ul>
							<a href="#"><label><li><img
										src="img/store/meat.png"></li>
									<li>육류</li></label></a>
						</ul>
					</div>
					<div class="cate_items">
						<ul>
							<a href="#"><label><li><img
										src="img/store/fish.png"></li>
									<li>해산물류</li></label></a>
						</ul>
					</div>
					<div class="cate_items">
						<ul>
							<a href="#"><label><li><img
										src="img/store/salad.png"></li>
									<li>채소류</li></label></a>
						</ul>
					</div>
					<div class="cate_items">
						<ul>
							<a href="#"><label><li><img
										src="img/store/source.png"></li>
									<li>기타</li></label></a>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="con2">
			<div id="recipe_box">
				<div id="recipe_list">
					<c:forEach items="${list }" var="list" varStatus="readcount">
						<div class="recipe_items">
							<form action="storeContent2.do" onclick="${list.s_url }">
								<ul>
									<a href="${list.s_url }"><label>
											<li><input type="hidden" value="${list.s_no }"
												name="s_no"></li> <input type="hidden"
											value="${list.s_url }" name="s_url">
											<li><img alt="java" src="${pageContext.request.contextPath }${list.s_img }"></li>
											<li>${store.s_readcount }</li> 
											<input type="submit" value="${list.s_title }">
									</label></a>
								</ul>
							</form>
						</div>
					</c:forEach>
				</div>
			</div>
			<div id="pageNum">
				<c:if test="${startPage > blockSize }">
					<a href='store.do?pageNum=${startPage-blockSize}'>[<<]</a>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<a href='store.do?pageNum=${i}'>[${i }]</a>
				</c:forEach>
				<c:if test="${endPage < pageCnt }">
					<a href='store.do?pageNum=${startPage+blockSize }'>[>>]</a>
				</c:if>
			</div>
		</div>
	</div>

</body>
</html>
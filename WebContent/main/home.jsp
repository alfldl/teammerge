<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<%@ include file="../header.jsp"%>
</head>
<body>

	<div class="gong"></div>
	<div class="grid_con">
		<div class="con1">
			<div id="recipe_box">
				<div id="recipe_list">
					<div class="recipe_items">
						<ul>
							<c:forEach var="cook" items="${list }" varStatus="vs">
								<c:if test="${randomValue1 == vs.index}">
									<a href='content.do?num=${board.num}&pageNum=${currentPage}'>
										<li><img id="1"
											src="${pageContext.request.contextPath }${cook.c_img}"></li>
										<li>${cook.c_name }</li>
									</a>

								</c:if>
							</c:forEach>
						</ul>
					</div>
					<div class="recipe_items">
						<ul>
							<c:forEach var="cook" items="${list }" varStatus="vs">
								<c:if test="${randomValue2 == vs.index}">
									<a href='content.do?num=${board.num}&pageNum=${currentPage}'>
										<li><img id="1"
											src="${pageContext.request.contextPath }${cook.c_img}"></li>
										<li>${cook.c_name }</li>
									</a>

								</c:if>
							</c:forEach>
						</ul>
					</div>
					<div class="recipe_items">
						<ul>
							<c:forEach var="cook" items="${list }" varStatus="vs">
								<c:if test="${randomValue3 == vs.index}">
									<a href='content.do?num=${board.num}&pageNum=${currentPage}'>
										<li><img id="1"
											src="${pageContext.request.contextPath }${cook.c_img}"></li>
										<li>${cook.c_name }</li>
									</a>

								</c:if>
							</c:forEach>
						</ul>
					</div>

					<div class="recipe_items">
						<ul>
							<c:forEach var="cook" items="${list }" varStatus="vs">
								<c:if test="${randomValue4 == vs.index}">
									<a href='content.do?num=${board.num}&pageNum=${currentPage}'>
										<li><img id="1"
											src="${pageContext.request.contextPath }${cook.c_img}"></li>
										<li>${cook.c_name }</li>
									</a>

								</c:if>
							</c:forEach>
						</ul>
					</div>

					<div class="recipe_items">
						<ul>
							<c:forEach var="cook" items="${list }" varStatus="vs">
								<c:if test="${randomValue5 == vs.index}">
									<a href='content.do?num=${board.num}&pageNum=${currentPage}'>
										<li><img id="1"
											src="${pageContext.request.contextPath }${cook.c_img}"></li>
										<li>${cook.c_name }</li>
									</a>

								</c:if>
							</c:forEach>
						</ul>
					</div>


				</div>
			</div>
		</div>
		<div class="con2">
			<div id="recipe_box">
				<div id="recipe_list">
					<c:forEach var="mbest" items="${mbest }">
						<div class="recipe_items">
							<ul>
								<a
									href="cookContent.do?c_no=${cook.c_no }&pageNum=${currentPage}">
									<label>
										<li><img
											src="${pageContext.request.contextPath }${mbest.c_img }"></li>
								</label>
									<li>${mbest.c_name }</li>
								</a>
							</ul>
						</div>

					</c:forEach>
				</div>
			</div>
		</div>
		<div class="con3">
			<div id="recipe_box">
				<div id="recipe_list">
					<c:forEach var="sbest" items="${sbest }">
						<div class="recipe_items">
							<%-- <ul>
								<a
									href="cookContent.do?s_no=${store.s_no }&pageNum=${currentPage}">
									<label>
										<li><img
											src="${pageContext.request.contextPath }${sbest.s_img }"></li>
								</label>
									<li>${sbest.s_title }</li>
								</a>
							</ul> --%>
							<form action="storeContent2.do" onclick="${sbest.s_url }">
								<ul>
									<a href="${sbest.s_url }"><label>
											<li><input type="hidden" value="${sbest.s_no }" name="s_no"></li> 
											<input type="hidden" value="${sbest.s_url }" name="s_url">
											<li><img alt="java" src="${pageContext.request.contextPath }${sbest.s_img }"></li>
											<li>${store.s_readcount }</li> 
											<input type="submit" value="${sbest.s_title }">
									</label></a>
								</ul>
							</form>
						</div>

					</c:forEach>
				</div>
			</div>
		</div>


	</div>
	<div class="footer">
		<form id=00 action="comment.do">
			<input class="a" type="text"
				placeholder="불편사항이나 제안사항이 있으신가요? 레시피를 부탁해에 전하고 싶은 의견을 남겨주세요."><br>
			<input class="b" type="submit" value="의견제출">
		</form>
	</div>


	<%@ include file="../footer.jsp"%>
</body>

</html>
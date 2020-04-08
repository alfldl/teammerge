<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/recipe.css">
<style>
</style>
</head>
<body>
<%@ include file="../header.jsp"%>
	<div class="grid_con">
		<div class="con1">
			<div id="cate_list">
				<div class="cate_items">
					<ul>
						<label>
							<li>오늘의 재료</li>
							<li>
							<c:forEach items="${checkedItem }" var="checkedItem">
							${checkedItem }
							</c:forEach>
							</li>
						</label>
					</ul>
				</div><!-- cate_items close -->
			</div><!-- cate_list2 close -->
		</div><!-- con1 close -->
		<div class="con2">
			<div id="recipe_box">
				<div id="recipe_list">
					<c:forEach items="${sList }" var="sList">
						<div class="recipe_items">
							<ul>
								<a href="cookContent.do?c_no=${sList.c_no }&pageNum=${currentPage}"> 
									<label>
										<li><img src="${pageContext.request.contextPath }${sList.c_img }" alt="img"></li>
										<li><a href='cookContent.do?c_no=${sList.c_no }'><b>${sList.c_name }</b></a></li>
									</label>
								</a>
								<li>by.${sList.m_nickname }</li>
							</ul>
						</div><!-- recipe_items close -->
					<c:set var="startNum" value="${startNum -1 }" />
					</c:forEach>
				</div><!-- recipe_list close -->
			</div><!-- recipe_box close -->
			<div id="pageNum">
				<c:if test="${startPage > blockSize }">
					<a href='searchList.do?pageNum=${startPage-blockSize}&i_itemStr=${i_itemStr}'>[<<]</a>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					
					<a href='searchList.do?pageNum=${i }&i_itemStr=${i_itemStr}'>[${i }]</a>
				</c:forEach>
				<c:if test="${endPage < pageCnt }">
					<a href='searchList.do?pageNum=${startPage+blockSize }&i_itemStr=${i_itemStr}'>[>>]</a>
				</c:if>
			</div><!-- pageNum close -->
		</div><!--  con2 close -->
	</div><!-- grid_con -->
	<%@ include file="../footer.jsp"%>
</body>
</html>
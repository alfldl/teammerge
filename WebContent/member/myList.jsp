<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/recipe.css?after">
</head>
<body>
<%@ include file="../header.jsp"%>
	<div class="gong"></div>
		<div class = "mylist">
			<div class="con2">
				<div id="recipe_box">
					<div id="recipe_list">
						<c:forEach items="${wList }" var="list">
							<div class="recipe_items">
								<ul>
									<a href="cookContent.do?c_no=${list.c_no }&pageNum=${currentPage}"> 
										<label>
											<li><img src="${pageContext.request.contextPath }${list.c_img }" alt="img"></li>
											<li><a href='cookContent.do?c_no=${list.c_no }'><b>${list.c_name }</b></a></li>
										</label>
									</a>
								</ul>
							</div>
						<c:set var="startNum" value="${startNum -1 }" />
						</c:forEach>
					</div>
				</div>
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
				</div>
			</div>
		</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>
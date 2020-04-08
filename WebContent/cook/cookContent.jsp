<%@page import="dao.cook.CookImg"%>
<%@page import="java.util.List"%>
<%@page import="dao.cook.Cook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/cookCon.css">
<title>Insert title here</title>
<style>
table {
	position: relative;
	top: 50px;
	border-collapse: collapse;
	margin-left: auto;
	margin-right: auto;
	width: 800px;
	height: 800px;
}

#cookImg {
	width: 600px;
	height: 350px;
}

#button {
	position: relative;
}
</style>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="gong"></div>
	<div class="grid_con">
		<div class="con1">
			<div id="recipe_box">
				<div id="recipe_list">
					<table id="table1" border="1">
						<tr>
							<td>번호</td>
							<td>${cook.c_no }</td>
						</tr>
						<tr>
							<td>작성일</td>
							<td>${cook.c_date }</td>
						</tr>

						<tr>
							<td>작성자</td>
							<td>${m_nickname }</td>
						</tr>
						<tr>
							<td>조회수</td>
							<td>${cook.c_hits }</td>
						</tr>
						<tr>
							<td>요리명</td>
							<td>${cook.c_name }</td>
						</tr>

						<tr>
							<td>요리 카테고리</td>
							<td>${cook.c_category }</td>
						</tr>

						<tr>
							<td>대표 이미지</td>
							<td><img id="cookImg" src="${pageContext.request.contextPath }${cook.c_img }" required = "required"></td>
						</tr>
						<tr>
							<td>레시피 재료</td>
							<td>
								<ul class="i_item">
									<c:forEach items="${itemList }" var="itemList">
										<li>${itemList.i_item }&nbsp;</li>
									</c:forEach>
								</ul>
							</td>
						</tr>
						<c:forEach items="${list }" var="list">
							<tr>
								<td>과정${list.po_step }</td>
								<td><img
									src="${pageContext.request.contextPath }${list.c_po_img }"
									alt="이미지">
									<p>${list.c_po }</td>
							</tr>
						</c:forEach>
					</table>
					<form id="button" action="cookUpdate.do" method="post">
						<input type="hidden" name="c_no" value="${cook.c_no }"> 
						<input type="hidden" name="pageNum" value="${pageNum }">
						<c:if test = "${user.m_no eq cook.m_no }">
							<input type="submit" value="레시피 수정">
							<input type="button" value="삭제"
							onclick="location.href='cookDelete.do?pageNum=${pageNum }&c_no=${cook.c_no }'">
						</c:if>
					</form>
					<%-- <c:if test="${user.m_no eq cook.m_no }">
						<input type="button" value="삭제"
							onclick="location.href='cookDelete.do?pageNum=${pageNum }&c_no=${cook.c_no }'">
					</c:if> --%>
				</div>
			</div>
		</div>
	</div>
</body>
<%@ include file="../footer.jsp"%>
</html>
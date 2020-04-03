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
			<div id="cate_box">
				<div id="cate_list">
					<div class="cate_items"></div>
				</div>
			</div>
		</div>
		<div class="con2">
			<div id="recipe_box">
				<div id="recipe_list">
					<table border="1">
						<tr>
							<td>번호</td>
							<td>${cook.c_no }</td>
						</tr>

						<tr>
							<td>작성자</td>
							<td>${cook.m_nickname }</td>
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
							<td>요리 이미지</td>
							<td><img id="cookImg"
								src="${pageContext.request.contextPath }${cook.c_img }"></td>
						</tr>
						<tr>
							<td>요리과정</td>
							<td>${cook.c_po }</td>
						</tr>

						<tr>
							<td>조회수</td>
							<td>${cook.c_hits }</td>
						</tr>


						<tr>
							<td>작성일</td>
							<td>${cook.c_date }</td>
						</tr>
					</table>
					<form id="button" action="cookUpdate.do">
						<input type="hidden" name="c_no" value="${cook.c_no }">
						<input type="hidden" name="m_no" value="${cook.m_no }"> 
						<input type="hidden" name="c_name" value="${cook.c_name }"> 
						<input type="hidden" name="c_category" value="${cook.c_category }">
						<input type="hidden" name="c_img" value="${cook.c_img }">
						<input type="hidden" name="c_hits" value="${cook.c_hits }">
						<input type="hidden" name="c_po" value="${cook.c_po }"> 
						<input type="hidden" name="pageNum" value="${pageNum }"> 
						<input type="submit" value="레시피 수정">
					</form>
					
					<form id="button" action="cookDelete.do">
						<input type="hidden" name="c_no" value="${cook.c_no }">
						<input type="hidden" name="m_no" value="${cook.m_no }"> 
						<input type="hidden" name="c_name" value="${cook.c_name }"> 
						<input type="hidden" name="c_category" value="${cook.c_category }">
						<input type="hidden" name="c_img" value="${cook.c_img }">
						<input type="hidden" name="c_hits" value="${cook.c_hits }">
						<input type="hidden" name="c_po" value="${cook.c_po }"> 
						<input type="hidden" name="pageNum" value="${pageNum }"> 
						<input type="submit" value="레시피 삭제">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<%@ include file="../footer.jsp"%>

</body>
</html>
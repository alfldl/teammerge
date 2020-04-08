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

<link rel="stylesheet" type="text/css" href="css/refrigerator.css?after">

</head>

<body >
<%@ include file="../header.jsp" %>
	<div class="gong"></div>
	<form action = "search.do" method = "post" accept-charset = "utf-8">
		<div class = "container">
			<div class = "catego">면류</div>
			<div>
				<div class = "item">
					<c:forEach items = "${listNoodle }" var = "listN">
						<div style = "float: left">
							<input type = "checkbox" value="${listN.i_item }" name="i_item" >
							<img alt="java" src="${pageContext.request.contextPath }${listN.i_img }"><br>
							${listN.i_item }
						</div>
					</c:forEach>
				</div>
			</div>
			<div class = "catego">육류</div>
			<div>
				<div class = "item">
					<c:forEach items = "${listMeat }" var = "listM">
						<div style = "float: left">
							<input type = "checkbox" value="${listM.i_item }" name="i_item" >
							<img alt="java" src="${pageContext.request.contextPath }/${listM.i_img }"><br>
							${listM.i_item }<p>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class = "catego">해산물</div>
			<div>
				<div class = "item">
					<c:forEach items = "${listSeafood }" var = "listS">
						<div style = "float: left">
							<input type = "checkbox" value="${listS.i_item }" name="i_item" >
							<img alt="java" src="${pageContext.request.contextPath }${listS.i_img }"><br>
							${listS.i_item }
						</div>
					</c:forEach>
				</div>
			</div>
			<div class = "catego">채소류</div>
			<div>
				<div class = "item">
					<c:forEach items = "${listVegitable }" var = "listV">
						<div style = "float: left">
							<input type = "checkbox" value="${listV.i_item }" name="i_item" >
							<img alt="java" src="${pageContext.request.contextPath }${listV.i_img }"><br>
							${listV.i_item }
						</div>
					</c:forEach>
				</div>
			</div>
			<div class = "catego">조미료</div>
			<div>
				<div class = "item">
					<c:forEach items = "${listCondiment }" var = "listC">
						<div style = "float: left">
							<input type = "checkbox" value="${listC.i_item }" name="i_item" >
							<img alt="java" src="${pageContext.request.contextPath }${listC.i_img }"><br>
							${listC.i_item }
						</div>
					</c:forEach>
				</div>
			</div>
		</div> 
		
		<center><input type = "submit" value = "선택한 재료로 레시피 검색하기" class = "btn"></center>
		
	</form>
</body>
<%@ include file="../footer.jsp" %>
</html>
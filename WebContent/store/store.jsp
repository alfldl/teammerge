<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/store.css">
</head>
<body>
	<div class="grid-container">
		<div class="grid-item" style="font-size: 20px";>
			<c:forEach items="${list }" var="list">
				<img alt="java"
					src="${pageContext.request.contextPath }${list.s_img }">
				<div>
					${list.s_title } ${list.s_url } ${list.s_readcount }
					<br>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
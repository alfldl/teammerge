<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div style = "margin-top: 10%;">
		bmList ->
		<c:forEach items = "${bmList }" var = "bm">
			${bm.s_no }<p>
			${bm.c_no }<p>
		</c:forEach>
		<hr>
		writeList ->
		<c:forEach items = "${wList }" var = "write">
			${write.c_no }<p>
		</c:forEach>
	</div>
</body>
</html>
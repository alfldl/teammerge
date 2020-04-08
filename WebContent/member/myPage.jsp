<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/recipe.css">
<%@ include file="../header.jsp"%>
</head>
<body>
	<div class="gong"></div>
	<div>
		<form action = "update.do">
			<input type = "submit" value = "회원 정보 수정" name = "update">
		</form>
	</div>
	<div>
		<form action = "myList.do">
			<input type = "submit" value = "글쓴 목록" name = "update">
		</form>
	</div>
</body>
<%@ include file="../footer.jsp"%>
</html>
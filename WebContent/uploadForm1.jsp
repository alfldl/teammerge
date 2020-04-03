<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="upload1.do" method="post" enctype="multipart/form-data">
		<div>
		스토어 이름:<input type="text" name="s_title"  required="required"><p>
		이미지 첨부 : <input type="file" name="s_img" required="required"><p>
		스토어 링크:<input type="text" name="s_url"  required="required"><p>
		<input type="submit" value="확인">
		</div>
		</form>
</body>
</html>
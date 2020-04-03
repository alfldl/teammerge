<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="upload.do" method="post" enctype="multipart/form-data">
		<div>
		레시피 이름:<input type="text" name="c_name"  required="required"><p>
		레시피 카테고리:<input type="text" name="c_category"  required="required"><p>
		이미지첨부 : <input type="file" name="c_img" required="required"><p>
		레시피 내용:<input type="text" name="c_po"  required="required"><p>
		<input type="submit" value="확인">
		</div>
			</form>
			
</body>
</html>

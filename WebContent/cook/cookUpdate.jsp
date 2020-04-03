<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<form action="cookUpdatePro.do">
			<input type="hidden" name="pageNum" value="${pageNum }">
			<tr>
				<td>번호</td>
				<td>${cook.c_no }</td>
				<input type="hidden" name="c_no" value="${cook.c_no }">
			</tr>

			<tr>
				<td>작성자</td>
				<td>${cook.m_no }</td>
			</tr>

			<tr>
				<td>요리명</td>
				<td><input type="text" name="c_name" value="${cook.c_name }"></td>
			</tr>

			<tr>
				<td>요리 카테고리</td>
				<td><select name="cate">
						<option name="cate" value="한식">한식</option>
						<option name="cate" value="일식">일식</option>
						<option name="cate" value="중식">중식</option>
						<option name="cate" value="퓨전">퓨전</option>
				</select></td>
			</tr>

			<tr>
				<td>요리 이미지</td>
				<td>${cook.c_img }</td>
			</tr>

			<tr>
				<td>조회수</td>
				<td>${cook.c_hits }</td>
			</tr>

			<tr>
				<td>요리과정</td>
				<td><textarea name="c_po" style="height: 160px; whight: 430px;">
						${cook.c_po }
					</textarea></td>
			</tr>
		<tr>
			<input type="submit" value="수정완료">
		</tr>
		<tr>
			<input type="reset" value="취소">
		</tr>

		</form>
	</table>

</body>
</html>
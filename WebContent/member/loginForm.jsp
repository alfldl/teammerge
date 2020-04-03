<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>레부 로그인</title>
</head>
<body>
	<div align="center">
		<h2 align="center">
			<a href="../index.jsp"><img src="r_img/img_member/logo1.jpg" alt=""></a>
		</h2>
		<form action="loginPro.do" method="post">
			<table border="1">
				<tr>
					<td style="text-align:center">아이디</td>
					<td><input type="text" name="m_id" placeholder="&nbsp;ID"
						required="required"></td>
				</tr>
				<tr>
					<td style="text-align:center">암호</td>
					<td><input type="password" name="m_pw"
						placeholder="&nbsp;PASSWORD" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="확인"></td>
					<td><input type="reset" value="취소"></td>
				</tr>
			</table>
		</form>
		<p>

			<input type="button" value="회원가입"
				onclick="location.href='join.do'">
	<%@ include file="../footer.jsp" %>
	</div>
</body>
</html>
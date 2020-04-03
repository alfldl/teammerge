<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
	<div>
		<form action="deletePro.do">
			<input type="text" name="m_id" value="${m_id }">
			<input type="password" name="m_pw">
			
			<input type="submit" value="회원탈퇴">
			<input type="reset" value="취소">
		</form>
	</div>

</body>
</html>
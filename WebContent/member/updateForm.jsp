<%@page import="dao.member.Member"%>
<%@page import="dao.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 수정</title>
<script>
	function chk() {
		if (frm.m_pw_new.value != frm.m_pw_new2.value) {
			alert("암호가 다릅니다");
			frm.m_pw.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div align="center">
		<h1>
			<a href="../index.jsp"><img src="../r_img/img_member/logo1.jpg"
				alt=""></a>
		</h1>
		<h2>회원 정보 수정</h2>
		<form action="updatePro.do?" name="frm" onsubmit="return chk()" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="m_id" value="${info.m_id }"></td>
				</tr>
				<tr>
					<td>현재 암호</td>
					<td><input type="password" name="m_pw" required="required"></td>
				</tr>
				<tr>
					<td>변경 암호</td>
					<td><input type="password" name="m_pw_new" required="required"></td>
				</tr>
				<tr>
					<td>변경 암호 확인</td>
					<td><input type="password" name="m_pw_new2" required="required"></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" name="m_nickName" required="required"
						value="${info.m_nickname }"></td>
				<tr>
					<td>이름</td>
					<td><input type="text" name="m_name" required="required"
						value="${info.m_name }"></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="tel" name="m_phone" required="required"
						value="${info.m_phone }"></td>
				</tr>
			</table>
			<br> <input type="submit" value="확인"> <input
				type="reset" value="취소">
		</form>
	</div>
</body>
</html>
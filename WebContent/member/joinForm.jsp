<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>레부 회원가입</title>
<script type="text/javascript">
	function chk() {
		if (frm.m_pw.value != frm.m_pw2.value) {
			alert("암호가 다릅니다");
			frm.m_pw.focus();
			return false;
		}
		return true;
	}
	function winop() {
		if (!frm.m_id.value) {
			alert("id를 입력하고 사용하세요");
			frm.m_id.focus();
			return false;
		}
			window.open("confirmId.do?m_id=" + frm.m_id.value, "",
				"width=300 height=300");
	}
</script>
</head>
<body>
	<div align="center">
		<h2 align="center">
			<a href="#"><img src="r_img/img_member/logo1.jpg" alt=""></a>
		</h2>
		<form action="joinPro.do" method="post" onsubmit="return chk()" name = "frm">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="m_id" required="required">
						<input type="button" value="중복체크" onclick="winop()">
					</td>
				</tr>
				<tr>
					<td>암호</td>
					<td><input type="password" name="m_pw" required="required"></td>
				</tr>
				<tr>
					<td>암호확인</td>
					<td><input type="password" name="m_pw2" required="required"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="m_name" required="required"></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" name="m_nickName" required="required"></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="tel" name="m_phone" required="required" placeholder="xxx-xxxx-xxxx" ></td>
				</tr>
				<tr>
					<td><input type="submit" value="확인"></td>
					<td><input type="reset" value="취소"></td>
				</tr>
			</table>
		</form>
		<br>
		<br>
		<br>
	<%@ include file="../footer.jsp"%>
	</div>
</body>
</html>
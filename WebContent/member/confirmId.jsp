<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>중복 확인</title>

<script type = "text/javascript">
	function wincl(){
		opener.document.frm.m_id.value = "${m_id}";
		window.close();
	}
</script>

</head>
<body>
	<c:if test="${result eq 0}">
		${m_id }는 사용 가능합니다.
		<input type = "button" value = "닫기" onclick = "wincl()">
	</c:if>
	<c:if test="${result eq 1}">
		${m_id }는 이미 존재하는 아이디입니다.
		
	</c:if>
	<form>
		아이디: <input type = "text" name = "m_id"><p>
		<input type = "submit" value = "확인 ">
	</form>
</body>
</html>
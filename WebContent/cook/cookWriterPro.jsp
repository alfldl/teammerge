<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<c:if test="${result1 > 0 }">
		<c:if test="${result2 > 0 }">
			<c:if test="${result3 > 0 }">
				<script type="text/javascript">
					alert("입력 완료");
					location.href = "cook.do";
				</script>
			</c:if>
		</c:if>
	</c:if>
	<c:if test="${result == 0 }">
		<script type="text/javascript">
			alert("똑바로 하십쇼 허허;;;");
			location.href = "cook.do?pageNum=${pageNum}";
		</script>
	</c:if>
	
</head>
<body>


</body>
</html>
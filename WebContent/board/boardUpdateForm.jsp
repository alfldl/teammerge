<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board Update</title>
<link rel="stylesheet" type="text/css" href="css/board.css">

<script>
var error = "${param.error}"
if (error == "true") {
	alert("요청이 잘못되었습니다.")
}
</script>
</head>

<body>
	<%@ include file="../header.jsp" %>
	<div class="board-gb"></div>
	<div id="board-wrap">
		<div class="board-write-con1">
			<h2>게시글수정</h2>
		</div>	
		<div class="board-wirte-con2">
			<form action="boardUpdatePro.do" method="post">
				<input type="hidden" name="bNo" value="${bNo }">
				<input type="hidden" name="pageNum" value="${pageNum }">
			<table>
				<tr>
					<td class="title-td">		
						<input type="text" name="title" required="required" 
							size="110" value="${board.title }" >
					</td>
				</tr>		
				
				<tr>
					<td><textarea  class="content-td" rows="15" cols="101" name="content"
						required="required">${board.content }</textarea>
					</td>
				</tr>		
						
				<tr>
					<td>
						<div class="insert-btn">
							<input class="submit-btn" type="submit" value="수정">
							<input class="cnxl-btn" type="button" value="취소" onclick="history.back()">
						</div>
					</td>
				</tr>	
			</table>		
			</form>
		</div>
	</div>
</body>
<%@ include file="../footer.jsp" %>
</html>
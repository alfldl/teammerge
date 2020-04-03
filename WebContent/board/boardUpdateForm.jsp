<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board Update</title>
<%@ include file="../header.jsp" %>
<div id=gongback1></div>
<div id=gongback1></div>
<script>
var error = "${param.error}"
if (error == "true") {
	alert("요청이 잘못되었습니다.")
}
</script>
<div id="board">
	<form action="boardUpdatePro.do" method="post">
		<input type="hidden" name="bNo" value="${bNo }">
		<input type="hidden" name="pageNum" value="${pageNum }">
		
	<table>
			<caption>
				<h2>게시글수정</h2>
			</caption>
			
			<tr>
				<td>		
					<input type="text" name="title" required="required" 
						value="${board.title }" size="100">
				</td>
			</tr>		
			
			<tr>
				<td><textarea  style="resize: none" rows="20" cols="105" name="content"
					required="required">${board.content }</textarea>
				</td>
			</tr>		
					
			<tr>
				<td>
					<input type="submit" value="수정">
					<input type="button" value="취소" onclick="history.back()">
				</td>
			</tr>	
				
			</table>		
		</form>
</div>

<%@ include file="../footer.jsp" %>
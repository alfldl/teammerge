<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Board</title>

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
	<form action="boardWritePro.do?pageNum=${pageNum }" method="post">
		<input type="hidden" name="bNo" value="${bNo }">

	<table>
		<caption>
			<h2>게시판 글쓰기</h2>
		</caption>
		
		<tr>
			<td>		
				<input type="text" name="title" required="required" placeholder="게시글 제목을 입력해주세요" 
					size="100">
			</td>
		</tr>		
		
		<tr>
			<td><textarea  style="resize: none" rows="20" cols="105" name="content"
					required="required" placeholder="내용을 입력하세요"></textarea>
			</td>
		</tr>		
				
		<tr>
			<td>
				<input type="submit" value="확인">
				<input type="button" value="취소" onclick="history.back()">
			</td>
		</tr>	
			
		</table>		
	</form>
</div>
	
	<%@ include file="../footer.jsp" %>
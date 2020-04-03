<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>BoardList</title>

<%@ include file="../header.jsp" %>
<script>
var isDelete = "${param.delete}"
if (isDelete == "true") {
	alert("삭제완료!");
} 
</script>

<style type="text/css"> 
table {
	width: 80%;
	
}

.button {
  background-color: #808080;
  border: none;
  color: white;
  padding: 10px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  float: right;
  cursor: pointer;
  border-radius: 10px; 
  margin-bottom: 25px; 
  
}

</style>

<div id="wrap">
	<h2 >자유게시판</h2>
<hr>

	<table>
		<tr>
			<th>NO.</th><th>제목</th><th>작성자</th>
			<th>작성일</th><th>조회수</th><th>좋아요♥</th>
		</tr>
		<c:if test="${totalCnt > 0 }">
			<c:forEach items="${list}" var="board">
					<tr style="text-align: center">
						<td>${ board.bNo}</td>
						<td><a href='boardContent.do?bNo=${board.bNo}&pageNum=${currentPage}'>
							${ board.title}</a></td>
						<td>${ board.writer}</td>
						<td>${ board.bDate}</td>
						<td>${ board.hits}</td>
						<td>${ board.likeCnt}</td>
					</tr>
			</c:forEach>
		</c:if>
	</table>
	

	<c:if test="${user ne null }">
		<a href="boardWriteForm.do" class="button">글쓰기</a>
	</c:if>
	
		
	<div style="text-align: center;">
		<c:if test="${startPage > blockSize }">
			<a href='boardList.do?pageNum=${startPage-blockSize}'>[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<a href='boardList.do?pageNum=${i}'>[${i}]</a>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a href='boardList.do?pageNum=${startPage+blockSize}'>[다음]</a>
		</c:if>
	</div>
	
	
</div>


<%@ include file="../footer.jsp" %>
</html>
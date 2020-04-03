<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html>
<title>BoardContent</title>

<%@ include file="../header.jsp" %>
<script>
var isDelete = "${param.delete}"
if (isDelete == "false") {
	alert("잘못된 요청입니다.");
}
</script>
<style>
.likes {
text-decoration: none;
}
</style>

<div id="board">
	<div>${board.title } 
		<div style="float: right">${board.bDate }</div>
	</div>
<hr>	
	<section>
		<article>
			${board.content }
		</article>
	</section>
	<section style=text-align:right>
		<a href='like.do?bNo=${board.bNo}&pageNum=${pageNum}' class="likes">
		            좋아요
		   <c:choose>
		   		<c:when test="${isLike eq 0 }"> ♡ </c:when>
		   		<c:otherwise> ♥ </c:otherwise>
		   
		   </c:choose>     
		</a>
	
			<button onclick="location.href='boardUpdateForm.do?bNo=${board.bNo}&pageNum=${pageNum}'">
			           수정
			 </button>           
			<button onclick="location.href='boardDeletePro.do?bNo=${board.bNo}&pageNum=${pageNum}'">
			            삭제
		</button>
		
	</section>
		
	<div>
		<div>${board.writer }</div>
	</div>
	<div>
		<form action="replyWrite.do" method="post">
			<input type="hidden" name="bNo" value="${bNo }">
			<input type="hidden" name="pageNum" value="${pageNum }">
			<textarea style="resize: none; width: 800px; height: 90px;" name="content"></textarea>
			<button>
				등록
			</button>
		</form>
	</div>
		<button onclick="location.href='boardList.do?pageNum=${pageNum }'">
		목록
		</button>

	<ul>
		<c:forEach var="reply" items="${replyList }">
		<li>
		${reply.content } 
		${reply.writer } 
		${reply.date } 
		<a href='replyDelete.do?pageNum=${pageNum }&bNo=${bNo }&brNo=${reply.brNo }' style=float:right >
		X
		</a>
		</li>
		
		</c:forEach>
	</ul>

</div> <!--board end  -->

<%@ include file="../footer.jsp" %>

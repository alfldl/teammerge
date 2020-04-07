<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BoardContent</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<link href="https://fonts.googleapis.com/css2?family=Single+Day&display=swap" rel="stylesheet">

<script>
var isDelete = "${param.delete}"
if (isDelete == "false") {
	alert("잘못된 요청입니다.");
}
</script>
</head>

<body>
	<%@ include file="../header.jsp" %>
	<div class="board-gb"></div>
	<div id="board-wrap">
		<div class="board-content-con1">
			<div><c:out value="${board.title }" /> 
				<div style="float: right">${board.bDate }</div>
			</div>
		</div>
		<div class="board-content-con2">
			<section>
				<article>
					<c:out value='${board.content }' />
				</article>
			</section>
		</div>
		<div class="board-content-con3">
			<c:if test="${mNo ne null }">
				<div class="contents-btns">
					<a href='like.do?bNo=${board.bNo}&pageNum=${pageNum}' class="likes">
							좋아요
						<c:choose>
						   	<c:when test="${isLike eq 0 }">♡ </c:when>
						   	<c:otherwise><span class="heart">♥</span></c:otherwise>
						  </c:choose>     
					</a>
			<c:if test="${mNo eq board.mNo }">
	
				<button class="submit-btn" onclick="location.href='boardUpdateForm.do?bNo=${board.bNo}&pageNum=${pageNum}'">
				           수정
				 </button>           
				<button class="cnxl-btn" onclick="location.href='boardDeletePro.do?bNo=${board.bNo}&pageNum=${pageNum}'">
				            삭제
				</button>
			</c:if>
				</div>
			</c:if>	
		</div>
		<div>
			<img src="img/board/user.png">
			<span class="board-writer"> ${board.writer } </span>
		</div>
		<div>
			<form action="replyWrite.do" method="post">
				<div>
					<button class="reply-btn">
						등록
					</button>
				</div>	
				<c:if test="${mNo ne null }">
					<input type="hidden" name="bNo" value="${bNo }">
					<input type="hidden" name="pageNum" value="${pageNum }">
					<textarea class="reply-box" name="content"></textarea>
			</form>
				</c:if>	
		</div>
		<div>
			<ul class="reply-ul">
				<c:forEach var="reply" items="${replyList }">
					<li>
						<span id="1"><c:out value='${reply.content }' /></span>
						<span id="2">${reply.writer } </span>
						<span id="3">${reply.date } </span>
							<c:if test="${mNo eq reply.mNo }">
								<a href='replyDelete.do?pageNum=${pageNum }&bNo=${bNo }&brNo=${reply.brNo }' >
								X
								</a>
						</c:if>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div>
			<button class="list-btn" onclick="location.href='boardList.do?pageNum=${pageNum }'">
				목록
			</button>
		</div>
	</div> <!--board end  -->
</body>
	<%@ include file="../footer.jsp" %>
</html>

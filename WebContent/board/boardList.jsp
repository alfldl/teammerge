<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BoardList</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
 
<script>
var isDelete = "${param.delete}"
if (isDelete == "true") {
	alert("삭제완료!");
} 

function submit() {
	var formTag = document.getElementById("icon");
	formTag.submit();
}

function gofilter() {
	var formTag = document.getElementById("filterForm");
	formTag.submit();
}

</script>
<style type="text/css"> 
.board-tb {
	width: 100%;
	
}
.board-gb {
	width: 100%;
	height: 70px;
	
}

#board-con {
	height: 100vh;
	width: 80%;
	margin: auto;
}

.write-button {
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
  border-radius: 5px; 
  margin-bottom: 25px; 
  
}

.gongback {
	height: 100px;
}

</style>

</head>
<body>
	<%@ include file="../header.jsp" %>

	<div class="board-gb"></div>
	<div id="board-con">
		<div class="board-con1">
			<h2 >자유게시판</h2>
				<form action="boardList.do" id="icon">
					<div style=text-align:right;>
						<input type="text" name="keyword" required="required" placeholder="검색"> 
						<i class="fa fa-search" onclick="submit();"></i>
					</div>
				</form>
		</div>
		<div class="board-con2">
		
			<table class="board-tb">
				<tr>
					<th>NO.</th><th>제목</th><th>작성자</th>
					<th>작성일</th><th>조회수</th><th>좋아요♥</th>
				</tr>
				<c:if test="${noticeList ne null }">
					<c:forEach items="${noticeList }" var="notice">
						<tr style="text-align: center; background-color:pink">
							<td><div style="background-color:red">공지</div></td>
							<td><a href='boardContent.do?bNo=${notice.bNo}&pageNum=${currentPage}'>
								${ notice.title}</a> &nbsp; [ ${notice.reCnt } ] </td>
							<td>${ notice.writer}</td>
							<td>${ notice.bDate}</td>
							<td>${ notice.hits}</td>
							<td>${ notice.likeCnt}</td>
						<tr>	
					</c:forEach>
				
				</c:if>
				<c:if test="${totalCnt > 0 }">
					<c:forEach items="${list}" var="board">
						<tr style="text-align: center; <c:if test='${board.type eq "QnA"}'> background-color: powderblue</c:if>">
							<td>${ board.bNo} </td>
							<td><a href='boardContent.do?bNo=${board.bNo}&pageNum=${currentPage}'>
							<c:out value="${ board.title}" /></a> &nbsp;[ ${ board.reCnt } ]</td>
							<td>${ board.writer}</td>
							<td>${ board.bDate}</td>
							<td>${ board.hits}</td>
							<td>${ board.likeCnt}</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
		<div class="board-con3">
		
			<div style="text-align: center;">
			
				<c:if test="${startPage > blockSize }">
					<a href='boardList.do?pageNum=${startPage-blockSize}&keyword=${keyword}&filter=${filter}'>[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href='boardList.do?pageNum=${i}&keyword=${keyword}&filter=${filter}'>[${i}]</a>
				</c:forEach>
				<c:if test="${endPage < pageCnt }">
					<a href='boardList.do?pageNum=${startPage+blockSize}&keyword=${keyword}&filter=${filter}'>[다음]</a>
				</c:if>
			</div>
			
			<div>
				<c:if test="${user ne null }">
					<a href="boardWriteForm.do" class="write-button">글쓰기</a>
				</c:if>
			</div>
			
			<div>
				<form action="boardList.do" id="filterForm">
					<select style="width:10%" onchange="gofilter();" name="filter">
						<option value="b_date">최신순</option>
						<option value="b_hits">조회수</option>
						<option value="like_cnt">좋아요수</option>
						<option value="re_cnt">댓글수</option>
					</select>
				</form>
			</div>
		</div>
	</div>
</body>
<%@ include file="../footer.jsp" %>
</html>
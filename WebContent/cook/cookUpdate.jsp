<%@page import="dao.cook.CookImg"%>
<%@page import="java.util.List"%>
<%@page import="dao.cook.Cook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/cookUp.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<title>Insert title here</title>
<style>
table {
	position: relative;
	top: 50px;
	border-collapse: collapse;
	margin-left: auto;
	margin-right: auto;
	width: 800px;
	height: 800px;
}

#cookImg {
	width: 600px;
	height: 350px;
}

#button {
	position: relative;
}
</style>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="gong"></div>
	<form action="cookUpdatePro.do" enctype="multipart/form-data"
		method="post">
		<div class="grid_con">
			<div class="con1">
				<div id="recipe_box">
					<div id="recipe_list">
						<table id="table1" border="1">
							<tr>
								<td>번호</td>
								<td>${cook.c_no }</td>
							</tr>
							<tr>
								<td>작성일</td>
								<td>${cook.c_date }</td>
							</tr>

							<tr>
								<td>작성자</td>
								<td>${cook.m_no }</td>
							</tr>
							<tr>
								<td>조회수</td>
								<td>${cook.c_hits }</td>
							</tr>
							<tr>
								<td>요리명</td>
								<td><input type="text" name="c_name"
									value="${cook.c_name }" requierd="requierd"></td>
							</tr>

							<tr>
								<td>요리 카테고리</td>
								<td><select name="cate">
										<option name="cate" value="한식">한식</option>
										<option name="cate" value="일식">일식</option>
										<option name="cate" value="중식">중식</option>
										<option name="cate" value="양식">양식</option>
										<option name="cate" value="퓨전">퓨전</option>
								</select></td>
							</tr>

							<tr>
								<td>번경 전 대표 이미지
									<p>
										<img id="cookImg"
											src="${pageContext.request.contextPath }${cook.c_img }">
								</td>
								<td>변경 할 대표 이미지
									<p>
										<input type="file" name="img0">
								</td>
							</tr>
						</table>
						<table id="itemTable">
							<tr>
								<td>
									<div>면류</div>
								</td>
								<td>
									<div class="item">
										<c:forEach items="${listNoodle }" var="listN">
											<div style="float: left">
												<input type="checkbox" value="${listN.i_item }"
													name="i_item"> <img alt="java"
													src="${pageContext.request.contextPath }${listN.i_img }"><br>
												${listN.i_item }
											</div>
										</c:forEach>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div>육류</div>
								</td>	
								<td>
									<div class="item">
										<c:forEach items="${listMeat }" var="listM">
											<div style="float: left">
												<input type="checkbox" value="${listM.i_item }"
													name="i_item"> <img alt="java"
													src="${pageContext.request.contextPath }/${listM.i_img }"><br>
												${listM.i_item }
												<p>
											</div>
										</c:forEach>
									</div>
								</td>
							</tr>
							<tr>
								<td>
							
									<div>해산물</div>
								</td>
								<td>
									<div class="item">
										<c:forEach items="${listSeafood }" var="listS">
											<div style="float: left">
												<input type="checkbox" value="${listS.i_item }"
													name="i_item"> <img alt="java"
													src="${pageContext.request.contextPath }${listS.i_img }"><br>
												${listS.i_item }
											</div>
										</c:forEach>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div>채소류</div>
								</td>
								<td>
									<div class="item">
										<c:forEach items="${listVegitable }" var="listV">
											<div style="float: left">
												<input type="checkbox" value="${listV.i_item }"
													name="i_item"> <img alt="java"
													src="${pageContext.request.contextPath }${listV.i_img }"><br>
												${listV.i_item }
											</div>
										</c:forEach>
									</div>
								</td>
							</tr>
						</table>
						<table id="table2">
								<c:forEach items="${list }" var="list">
								<tr name="addCon" id="addCon">
									<td>
										<p>변경 할 이미지
										<p>
											<input type="file" name="img${list.po_step }"
												requierd="requierd" id="img">
									</td>
									<td>과정${list.po_step }
										<p>
											<textarea placeholder="요리과정을 넣어주세요" name="c_po"
												style="height: 170px; width: 500px; resize: none;"
												requierd="requierd">${list.c_po }</textarea>
									</td>
									<c:if test="${list.po_step > 1 }">
										<td><button name="delCook" type="button">삭제</button>
									</c:if>
								</tr>
							</c:forEach>
						</table>

						<button id="btn1" name="addCook" type="button">+ 추가 +</button>

						<input type="hidden" name="c_no" value="${cook.c_no }"> 
						<input type="hidden" name="pageNum" value="${pageNum }"> 
						<input type="submit" value="레시피 수정" onclick="return fileChk();">
					</div>
				</div>
			</div>
		</div>
	</form>

</body>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>
	function fileChk() {
		var chk = document.getElementById('img');
		if(!chk.value) {
			alert('조리과정 이미지를 업로드 해주세요');
			return false;
		}
	}
	var i = ${ listSize };
	$(document).on(
					"click",
					"button[name=addCook]",
					function() {
						i++;
						var addCookText = '<tr name="addCon">'
								+ '<td>요리 이미지<p>'
								+ '<input type="file" name="img' + i + '" id="img">'
								+ '</td>'
								+ '<td>추가 과정'
								+ i
								+ '<p>'
								+ '<textarea placeholder="요리과정을 넣어주세요" name="c_po" style="height: 170px; width: 500px; resize:none;" requierd="requierd" >'
								+ '</textarea>' + '</td>'
								+ '<td><button name="delCook" type="button">삭제</button>'
								+ '</tr>';
						var trHtml = $("tr[name=addCon]:last");
						trHtml.after(addCookText);
					});
	$(document).on("click", "button[name=delCook]", function() {
		i--;
		var trHtml = $(this).parent().parent();
		trHtml.remove();
	});
</script>
<%@ include file="../footer.jsp"%>
</html>
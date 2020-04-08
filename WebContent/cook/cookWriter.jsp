<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/cookWriter.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<title>Insert title here</title>
<style>
</style>
<script>
	function fileChk() {
		var chk = document.getElementById('thumnail');
		if(!chk.value) {
			alert('대표이미지를 업로드 해주세요');
			return false;
		}
	}
	var i = 1;
	$(document).on(
					"click",
					"button[name=addCook]",
					function() {
						i++;
						var addCookText = '<tr name="addCon">'
								+ '<td>요리 이미지<p>'
								+ '<input type="file" name="img' + i + '">'
								+ '</td>'
								+ '<td>요리과정<p>'
								+ '<textarea placeholder="요리과정을 넣어주세요" name="c_po" style="height: 170px; width: 500px; resize:none; "></textarea>'
								+ '</td>'
								+ '<td><button name="delCook" type="button">삭제</button>'
								+ '</tr>';
						var trHtml = $("tr[name=addCon]:last");
						trHtml.after(addCookText);
					});
	$(document).on("click", "button[name=delCook]", function() {
		var trHtml = $(this).parent().parent();
		trHtml.remove();
	});
</script>
</head>
<body>
<body>
	<%@ include file="../header.jsp"%>
	<div class="gong"></div>
	<form action="cookWriterPro.do?pageNum=${pageNum }"
		enctype="multipart/form-data" method="post">
		<input type="hidden" name="pageNum" value="${pageNum }">
		<div class="grid_con">
			<div class="con1">
				<div id="cate_box">
					<table id="table1">
						<tr>
							<td>요리명</td>
							<td><input type="text" name="c_name"></td>
							<td>대표 이미지</td>
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
							<td><input type="file" name="img0" id="thumnail"></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="con2">
				<div id="recipe_box2">
					<div class="container">
						<div class="catego">면류</div>
						<div class="cateog">
							<div class="item">
								<c:forEach items="${listNoodle }" var="listN">
									<div style="float: left">
										<input type="checkbox" value="${listN.i_item }" name="i_item">
										<img alt="java" src="${pageContext.request.contextPath }${listN.i_img }"><br>
										${listN.i_item }
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="catego">육류</div>
						<div class="cateog">
							<div class="item">
								<c:forEach items="${listMeat }" var="listM">
									<div style="float: left">
										<input type="checkbox" value="${listM.i_item }" name="i_item">
										<img alt="java"
											src="${pageContext.request.contextPath }/${listM.i_img }"><br>
										${listM.i_item }
										<p>
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="catego">해산물</div>
						<div class="cateog">
							<div class="item">
								<c:forEach items="${listSeafood }" var="listS">
									<div style="float: left">
										<input type="checkbox" value="${listS.i_item }" name="i_item">
										<img alt="java"
											src="${pageContext.request.contextPath }${listS.i_img }"><br>
										${listS.i_item }
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="catego">채소류</div>
						<div class="cateog">
							<div class="item">
								<c:forEach items="${listVegitable }" var="listV">
									<div style="float: left">
										<input type="checkbox" value="${listV.i_item }" name="i_item">
										<img alt="java"
											src="${pageContext.request.contextPath }${listV.i_img }"><br>
										${listV.i_item }
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="con3">
				<div id="recipe_box">
					<table id="table2">
						<tr name="addCon" id="addCon">
							<td>요리 이미지
								<p>
									<input type="file" name="img1">
							</td>
							<td>요리과정
								<p>
									<textarea placeholder="요리과정을 넣어주세요" name="c_po"
										style="height: 170px; width: 500px; resize: none;"></textarea>
							</td>
						</tr>
					</table>
					<button id="btn1" name="addCook" type = "button">+ 추가</button>
				</div>
			</div>
		</div>
		<input id="submit" type="submit" value="작성완료" onclick="return fileChk();">
	</form>
	
</body>
<script>
	var i = 1;
	$(document)
			.on(
					"click",
					"button[name=addCook]",
					function() {
						i++;
						var addCookText = '<tr name="addCon">'
								+ '<td>요리 이미지<p>'
								+ '<input type="file" name="img' + i + '">'
								+ '</td>'
								+ '<td>요리과정<p>'
								+ '<textarea placeholder="요리과정을 넣어주세요" name="c_po" style="height: 170px; width: 500px; resize:none; "></textarea>'
								+ '</td>'
								+ '<td><button name="delCook">삭제</button>'
								+ '</tr>';
						var trHtml = $("tr[name=addCon]:last");
						trHtml.after(addCookText);
					});
	$(document).on("click", "button[name=delCook]", function() {
		var trHtml = $(this).parent().parent();
		trHtml.remove();
	});
</script>
<%@ include file="../footer.jsp"%>

</html>
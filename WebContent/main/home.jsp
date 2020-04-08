<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<%@ include file="../header.jsp"%>
<script type="text/javascript">
	var error = "${param.error}"
	if (error == "true")
		alert("로그인후 이용가능합니다.");
</script>
</head>
<body>

	<div class="gong"></div>
	<div class="grid_con">
		<div class="con1" style="background-color: #FFFFFF;">
		
		<div id="recipe_box">
				<p1><link href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Do+Hyeon&display=swap" rel="stylesheet">오늘 뭐먹지?</p1>
				
		</div>
		</div>
		<div class="con2">
		<div id="recipe_box">
				<div id="recipe_list">
			
					<div class="recipe_items">
						<ul>
							<c:forEach var="cook" items="${list }" varStatus="vs">
								<c:if test="${randomValue1 == vs.index}">
										<a href="cookContent.do?c_no=${cook.c_no }&pageNum=${currentPage}"><label>
										<li><img id="1" src="${pageContext.request.contextPath }${cook.c_img}"></li>
										<li><c:choose>
												<c:when test="${fn:length(cook.c_name) gt 10}">
													<c:out value="${fn:substring(cook.c_name, 0, 9)}">...
        											  </c:out>
												</c:when>
												<c:otherwise>
													<c:out value="${cook.c_name}">
													</c:out>
												</c:otherwise>
											</c:choose></li>
									

								</c:if>
							</c:forEach>
						</ul>
					</div>
					<div class="recipe_items">
						<ul>
							<c:forEach var="cook" items="${list }" varStatus="vs">
								<c:if test="${randomValue2 == vs.index}">
									<a href="cookContent.do?c_no=${cook.c_no }&pageNum=${currentPage}"><label>
										<li><img id="1" src="${pageContext.request.contextPath }${cook.c_img}"></li>
										<li><c:choose>
												<c:when test="${fn:length(cook.c_name) gt 10}">
													<c:out value="${fn:substring(cook.c_name, 0, 9)}">...
        											  </c:out>
												</c:when>
												<c:otherwise>
													<c:out value="${cook.c_name}">
													</c:out>
												</c:otherwise>
											</c:choose></li>
								

								</c:if>
							</c:forEach>
						</ul>
					</div>
					<div class="recipe_items">
						<ul>
							<c:forEach var="cook" items="${list }" varStatus="vs">
								<c:if test="${randomValue3 == vs.index}">
									<a href="cookContent.do?c_no=${cook.c_no }&pageNum=${currentPage}"><label>
										<li><img id="1" src="${pageContext.request.contextPath }${cook.c_img}"></li>
										<li><c:choose>
												<c:when test="${fn:length(cook.c_name) gt 10}">
													<c:out value="${fn:substring(cook.c_name, 0, 9)}">...
        											  </c:out>
												</c:when>
												<c:otherwise>
													<c:out value="${cook.c_name}">
													</c:out>
												</c:otherwise>
											</c:choose></li>
								

								</c:if>
							</c:forEach>
						</ul>
					</div>

					<div class="recipe_items">
						<ul>
							<c:forEach var="cook" items="${list }" varStatus="vs">
								<c:if test="${randomValue4 == vs.index}">
									<a href="cookContent.do?c_no=${cook.c_no }&pageNum=${currentPage}"><label>
										<li><img id="1" src="${pageContext.request.contextPath }${cook.c_img}"></li>
										<li><c:choose>
												<c:when test="${fn:length(cook.c_name) gt 10}">
													<c:out value="${fn:substring(cook.c_name, 0, 9)}">...
        											  </c:out>
												</c:when>
												<c:otherwise>
													<c:out value="${cook.c_name}">
													</c:out>
												</c:otherwise>
											</c:choose></li>
								

								</c:if>
							</c:forEach>
						</ul>
					</div>
					<div class="recipe_items">
						<ul>
							<c:forEach var="cook" items="${list }" varStatus="vs">
								<c:if test="${randomValue5 == vs.index}">
									<a href="cookContent.do?c_no=${cook.c_no }&pageNum=${currentPage}"><label>
										<li><img id="1" src="${pageContext.request.contextPath }${cook.c_img}"></li>
										<li><c:choose>
												<c:when test="${fn:length(cook.c_name) gt 10}">
													<c:out value="${fn:substring(cook.c_name, 0, 9)}">...
        											  </c:out>
												</c:when>
												<c:otherwise>
													<c:out value="${cook.c_name}">
													</c:out>
												</c:otherwise>
											</c:choose></li>
								

								</c:if>
							</c:forEach>
						</ul>
					</div>

				</div>
			</div>
		</div>
		<div class="con3">
			<div id="recipe_box">
			<p2><link href="https://fonts.googleapis.com/css?family=Jua&display=swap&subset=korean"  rel="stylesheet">레시피 Best</p2>
			</div>
			 </div>
				<div class="con4">
					<div id="recipe_box">
						<div id="recipe_list">
					<c:forEach var="mbest" items="${mbest }">
						<div class="recipe_items">
							<ul>
								<a
									href="cookContent.do?c_no=${cook.c_no }&pageNum=${currentPage}">
									<label>
										<li><img  id="1"
											src="${pageContext.request.contextPath }${mbest.c_img }"></li>
								</label>
									<li><c:choose>
												<c:when test="${fn:length(mbest.c_name) gt 10}">
													<c:out value="${fn:substring(mbest.c_name, 0, 9)}">...
        											  </c:out>
												</c:when>
												<c:otherwise>
													<c:out value="${mbest.c_name}">
													</c:out>
												</c:otherwise>
											</c:choose></li>
								</a>
							</ul>
						</div>

					</c:forEach>
				</div>
			</div>
		</div>
		<div class="con5">
		<div id="recipe_box">
				<p3><link href="https://fonts.googleapis.com/css?family=Jua&display=swap&subset=korean"  rel="stylesheet">쇼핑몰 Best</p3>
		</div>
		</div>
				<div class="con6">
			<div id="recipe_box">
				<div id="recipe_list">
					<c:forEach var="sbest" items="${sbest }">
						<div class="recipe_items">
							<%-- <ul>
								<a
									href="cookContent.do?s_no=${store.s_no }&pageNum=${currentPage}">
									<label>
										<li><img
											src="${pageContext.request.contextPath }${sbest.s_img }"></li>
								</label>
									<li>${sbest.s_title }</li>
								</a>
							</ul> --%>
							<form action="storeContent2.do" onclick="${sbest.s_url }">
								<ul>
									<a href="${sbest.s_url }"><label>
											<li><input type="hidden" value="${sbest.s_no }"
												name="s_no"></li> <input type="hidden"
											value="${sbest.s_url }" name="s_url">
											<li><img id="1"
												src="${pageContext.request.contextPath }${sbest.s_img }"></li>
											<li>${store.s_readcount }</li> <input type="submit"
											value="${sbest.s_title }">
									</label></a>
								</ul>
							</form>
						</div>

					</c:forEach>
				</div>
			</div>
		</div>
		<div class="con7">
			<div class="footer">

				<form action="boardWritePro.do" method="post">
					<input type="hidden" name="title" value="[고객문의글]"> <input
						type="hidden" name="pageNum" value="1"> <input
						type="hidden" name="type" value="QnA"> <input
						style="resize: none" name="content" class="a"
						placeholder="불편사항이나 제안사항이 있으신가요? 레시피를 부탁해에 전하고 싶은 의견을 남겨주세요.">
					<input class="b" type="submit" value="의견제출">
				</form>
			</div>
		</div>

	</div>



	<%@ include file="../footer.jsp"%>
</body>

</html>
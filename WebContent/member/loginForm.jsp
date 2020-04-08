<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login.css?after">
</head>
<body>
<div class="inner_login">
    <div class="login_tistory">
        <form method="post" action = "loginPro.do">
            <fieldset>
            	<legend class="screen_out">로그인 정보 입력폼</legend>
	            <div class="box_login">
	                <div class="inp_text">
	                	<label for="loginId" class="screen_out">아이디</label>
	                	<input type="text" id="loginId" name="m_id" placeholder="ID" >
	                </div>
	                <div class="inp_text">
	                	<label for="loginPw" class="screen_out">비밀번호</label>
	                	<input type="password" id="loginPw" name="m_pw" placeholder="Password" >
	                </div>
	            </div>
	            <br>
            	<button type="submit" class="btn_login">로그인</button>
            	<button type="submit" class="btn_login">회원가입</button>
            </fieldset>
        </form>
    </div>
</div>

</body>
</html>
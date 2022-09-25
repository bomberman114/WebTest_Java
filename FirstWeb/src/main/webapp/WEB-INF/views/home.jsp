<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).submit(function(e) {
	var useridEl = document.getElementById('userid');
	var userid = useridEl.value
	var userpwEl = document.getElementById('userpw');
	var userpw = userpwEl.value
	var idReg = /^[a-z]+[a-z0-9]$/g;
    if( !idReg.test( userid ) ) {
        alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
        return false;
    }
	if (userid == null || userid == '') {
		alert('아이디를 입력해주세요.');
		useridEl.focus();
		return false;

	} else if (userpw == null || userpw == '') {
		alert('비밀번호를 입력해주세요.');
		userpwEl.focus();
		return false;
	} 
})
</script>
</head>
<body>

	<h2>Home</h2>
	
		<a href="User/UserList">회원목록</a>
		<a href="/User/AccountForm">회원가입</a>
	<!--  <input type= "button" value="로그인"> -->
		
		
		<!-- c:if #{loginUser token == null 아래 쪽 -->
		<!-- %자바로 코드로 위를 구현% -->
		<form action="/Login/Login" id="form1" method="POST">
		 <br> 
		 <span>ID:</span> <input type="text" placeholder="아이디를 입력 해주세요."  id ="userid" maxlength="10" name="userid">
		<br>
		<span>PW:</span> <input type="password" id="userpw" maxlength="10" name="userpw"> <!-- name이 키값이다. -->
		<!--  <input type= "button" value="로그인"> -->
		
		<input type="submit" value="로그인">
	</form>

	<!-- <a href="User/UserList?username=조현길&age=26&gender=남자">회원가입 목록</a>  -->

	
	<%-- JSTL 
<%String name = "조현길"; %>
<%=name %>
 --%>
</body>
</html>
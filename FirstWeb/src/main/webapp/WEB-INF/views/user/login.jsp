<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	
</script>
</head>
<body>
	<h2>로그인</h2>
	<form action="/User/LoginCheck" id="form1" method="POST">
		<c:if test="${msg == false}">
			<p style="color: red;">로그인 실패! 아이디와 비밀번호 확인해주세요.</p>
		</c:if>
		<span>ID</span> <input type="text" maxlength="20" name="userid">
		<br> <span>PW</span> <input type="password" maxlength="20"
			name="userpw"> <br> <input type="submit" value="로그인">
	</form>
	<a href="/User/AccountForm">회원가입</a>
	<a href="/">메인화면</a>


	<!--  <form action="/User/login" id="form1" method="POST">
	<span>ID:</span>
	<input type="text" placeholder="아이디를 입력 해주세요." maxlength="10">
	<br>
	<span>PW:</span>
	<input type="password" placeholder="PW을 입력해주세요." maxlength="10">
	 <input type= "button" value="로그인"> 
	</form>-->
	<!-- <a href="User/UserList?username=조현길&age=26&gender=남자">회원가입 목록</a>  -->
	<%-- JSTL 
<%String name = "조현길"; %>
<%=name %>
 --%>
</body>
</html>
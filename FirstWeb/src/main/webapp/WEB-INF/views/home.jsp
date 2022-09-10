<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
</script>
</head>
<body>
<h2>로그인</h2>
<span>ID:</span>
<input type="text" placeholder="아이디를 입력 해주세요." maxlength="10">
<br><span>PW:</span>
<input type="password" placeholder="PW을 입력해주세요." maxlength="10">
<!--  <input type= "button" value="로그인"> -->
<a href="">로그인</a>
<a href="User/AccountForm">회원가입</a>
<!-- <a href="User/UserList?username=조현길&age=26&gender=남자">회원가입 목록</a>  -->
<a href="User/UserList">회원가입 목록</a>
<%-- JSTL 
<%String name = "조현길"; %>
<%=name %>
 --%>
</body>
</html>
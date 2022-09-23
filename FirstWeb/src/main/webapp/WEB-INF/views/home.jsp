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
	
</script>
</head>
<body>
	<h2>Home</h2>
	<c:if test="${user == null }">
		<a href="User/Login">로그인</a>

	</c:if>
	<c:if test="${user != null}">
		<p>${user.USERNAME}님 반갑습니다.</p>
		<br>
		<a href="User/Logout">로그아웃</a>
		<a href="User/UserList">회원목록</a>
	</c:if>
	<!--  <input type= "button" value="로그인"> -->


	<!-- <a href="User/UserList?username=조현길&age=26&gender=남자">회원가입 목록</a>  -->
	<%-- JSTL 
<%String name = "조현길"; %>
<%=name %>
 --%>
</body>
</html>
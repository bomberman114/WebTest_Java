<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.basic.user.vo.UserVo" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script></script>
</head>
<body>
<% UserVo login = (UserVo) request.getAttribute("loginUser");
String token = login.getAdminToken();
String userid = login.getUserid();
%>
<% if( token != null){%>
<%} %>



<% if(token.equals("1")) {%>
<%=login.getUserid() %>
<div><a href="/User/List">회원목록</a></div>
<%  }
%>


	<h4>로그인성공</h4>

			<div>${loginUser.username}님 안녕하세요</div>
	
	<a href="">게시판 메뉴</a>
	<a href="/">로그아웃</a>
</body>
</html>
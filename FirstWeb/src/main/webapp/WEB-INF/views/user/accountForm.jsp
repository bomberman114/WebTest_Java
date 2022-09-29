<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.basic.user.controller.UserController" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	
		$(document).submit(function(e){
			 var usernameEl = document.getElementById('username');
			    var username = usernameEl.value
			    var useridEl = document.getElementById('userid');
			    var userid = useridEl.value
			    var userpwEl = document.getElementById('userpw');
			    var userpw = userpwEl.value
			    
			    
			    if ( username == null || username == '' ){
			        alert('이름을 입력해주세요.');
			        usernameEl.focus();
			        return false;
			        
			    } else if ( userid == null || userid == '' ){
			        alert('아이디를 입력해주세요.');
			        useridEl.focus();
			        return false;
			        
			    } else if ( userpw == null || userpw == '' ){
			        alert('비밀번호를 입력해주세요.');
			        userpwEl.focus();
			        return false;
			        
			    } else {
			       alert('회원가입 되었습니다.');
			    }
			 })
	

</script>
</head>
<body>
	<h2>회원가입</h2>
	<% String result1 =(String) request.getAttribute("result1"); %>
	<% if (result1.equals("false")){%>
	<div style="color: red;">${msg}</div>
	<%} %>
	<form action="/User/Account" id="form1" method="POST">
		<span>이름:</span> <input type="text" placeholder="이름을 입력 해주세요."  id="username" maxlength="10" name="username">
		 <br> 
		 <span>ID:</span> <input type="text" placeholder="아이디를 입력 해주세요."  id ="userid" maxlength="10" name="userid">
		<br>
		<span>PW:</span> <input type="password" id="userpw" maxlength="10" name="userpwd"> <!-- name이 키값이다. -->
		<!--  <input type= "button" value="로그인"> -->
		
		<input type="submit" value="회원가입">
	</form>
	<a href="/">메인화면</a>
</body>
</html>
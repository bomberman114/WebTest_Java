<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/common.css" />
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
</script>
</head>
<body>
	<h3>게시판 메뉴 수정</h3>
	
	<form action="/Menu/Update" method="Post">
		<span>메뉴 이름</span> <input value="${update.menuname}" placeholder="새로운 이름 입력" maxlength="10" name="newname">
		<br>
		<br>
		<input type="hidden" value="${update.menuname}" name="menuname">
		<input type="submit" value="수정">
	</form>



</body>
</html>
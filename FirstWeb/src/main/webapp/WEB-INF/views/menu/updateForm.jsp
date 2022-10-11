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
	<h2>게시판 메뉴수정</h2>
		<form action="/Menu/Update" method="Post">
		<span>새로운 메뉴이름:</span><input value="${menuname}" name="menuname" maxlength="10">
		<input type="submit" value="메뉴이름수정">
	</form>
	<a href="board/first"></a>



</body>
</html>
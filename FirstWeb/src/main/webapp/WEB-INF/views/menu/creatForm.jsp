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
<h3> 게시판메뉴만들기</h3>
<form action="/Menu/Creat" id='Form' method="POST">
	<span>메뉴이름</span><input type="text" placeholder="만들메뉴이름을 입력하세요!" id='menuname' maxlength="10" name="menuname">
	<input type="hidden" value="${creatForm.username}" name="username">
	<input type="hidden" value="${creatForm.adminToken}" name="adminToken">
	<input type="submit" value="메뉴새로만들기">

</form>
<a href="board/boardFirst">게시판으로가기</a>


</body>
</html>
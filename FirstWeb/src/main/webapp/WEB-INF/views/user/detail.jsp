<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>

	<h2>회원상세목록</h2>
	<table border="1">
	
		<tr>
			<th>유저번호</th>
			<th>Name</th>
			<th>ID</th>
			<th>PW</th>
			<th>가입날짜</th>
			<th>수정날짜</th>
		<tr>
			
			<td>${detail.useridx}</td>
			<td>${detail.username}</td>
			<td>${detail.userid}</td>
			<td>${detail.userpw}</td>
			<td>${detail.userindate}</td>
			<td>${detail.userupdate}</td>

		</tr>

	</table>
	<form action="/User/UpdateForm" id="form1" method="POST">
	<input type="hidden" value="${detail.userid}" name="userid">
	<input type="hidden" value="${detail.userpw}" name="userpw">
	<input type="submit" value="회원수정">
	</form>
	
	<a href="/User/Delete?userid=${detail.userid}">삭제</a>
	<a href="/User/UpdateForm?userid=${detail.userid}">수정</a>

</body>
</html>
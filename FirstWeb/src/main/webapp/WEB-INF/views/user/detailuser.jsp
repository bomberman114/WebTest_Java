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
<script></script>
</head>
<body>
	<h2>회원상세목록</h2>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>ID</th>
			<th>PW</th>
		<tr>
			<!--  <td><a href="Detaile?humanName=${m.username}&userid=${m.userid}&pwd=${m.userpw}" style="color:blue">${m.username}</a></td> -->
			<td>${detailUser.username}</td>
			<td>${detailUser.userid}</td>
			<td>${detailUser.userpw}</td>

		</tr>

	</table>
	<a href="/User/UserUpdateForm?userid=${detailUser.userid}">수정</a>
	<a href="/User/DeleteUser?userid=${detailUser.userid}">삭제</a>

</body>
</html>
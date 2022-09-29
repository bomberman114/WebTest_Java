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

<!--  
유저아이디   유저이름    유저비밀번호  삭제상태
asd           알파         1234          n 

> 삭제
ASD           알파         1234			 Y 




select * from user

select * from user 
where status = n ;

-->

<body>
	<h2>회원목록</h2>
	<table border="1">
		<tr>
			<th>유저번호</th>
			<th>Name</th>
			<th>상세페이지</th>

			<c:forEach items="${List}" var="m">
				<tr>
					<!--  -->
					<td>${m.useridx}</td>
					<td>${m.username}</td>

					<td>
					<form action="/User/Detail" method="Post">
					<input type = "hidden" value= "${m.userid}" name="userid" >
					<input type = "submit" value ="상세페이지">
					</form>
					
					<!--  <a href="DetailUser?userid=${m.userid}">${m.userid}</a></td>-->

	
				</tr>
			</c:forEach>
	</table>
	<a href="/">홈</a>

</body>
</html>
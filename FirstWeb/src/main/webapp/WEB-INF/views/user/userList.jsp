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
			<th>Name</th>
			<th>ID</th>
			<th>PW</th>
			<c:forEach items="${userList}" var="m">
				<tr>
					<!--  --><td><a href="DetailUser?username=${m.username}&userid=${m.userid}&userpw=${m.userpw}" style="color:blue">${m.username}</a></td>
					<td>${m.userid}</td>
					<td>${m.userpw}</td>

				</tr>
			</c:forEach>
	</table>

</body>
</html>
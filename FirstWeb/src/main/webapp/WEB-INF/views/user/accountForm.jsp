<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			
			
			if ( username == null || username == '' ){
				
			alert('이름을 입력해주세요.');
			usernameEl.focus();
			return false;
			
			}else{
				alert('회원가입되었습니다.');
			}
		})
	

</script>
</head>
<body>
	<h2>회원가입</h2>
	<form action="/User/Account" id="form1" method="POST">
		<span>이름:</span> <input type="text" placeholder="이름을 입력 해주세요."  id="username" maxlength="10" name="username">
		 <br> 
		 <span>ID:</span> <input type="text" placeholder="아이디를 입력 해주세요." maxlength="10" name="userid">
		<br>
		<span>PW:</span> <input type="password" maxlength="10" name="userpwd"> <!-- name이 키값이다. -->
		<!--  <input type= "button" value="로그인"> -->
		<input type="submit" value="회원가입">
	</form>
	<a href="/">메인화면</a>
</body>
</html>
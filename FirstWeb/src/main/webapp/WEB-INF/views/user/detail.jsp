<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/common.css" />
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<title>Insert title here</title>
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	
	var userpw = `${detail.userpw}`;
	var pw = "";
	
	for(var i =0; i<userpw.length; i++){
		pw += "*";
	}
	window.onload = function() {
		var userpw = document.getElementById('userpw');
		userpw.innerHTML= pw;
		
	} 
var Count = 0;
function btnGo() {
	Count += 1;
	var userpwEl = document.getElementById('userpw');
	userpwEl.innerHTML = pw;
	if(Count % 2 ==0){
		userpwEl.innerHTML = pw;
	
	}else if (Count % 2 ==1 ){
		userpwEl.innerHTML = userpw;
		
	}
}

	function deleteUser() {
		if (confirm('탈퇴 하시겠습니까?')) {
			alert('탈퇴 되었습니다.');
		} else {
			return false;
		}
	}
	
	function deleteAdmin() {
		if (confirm('추방 하시겠습니까?')) {
			alert('추방 되었습니다.');
		} else {
			return false;
		}
	}
	function password() {
		
	}
	
</script>
</head>

<body>
		<h2>유저 상세정보</h2>
	<table border="1">
		<tr>
		<td><b>번호</b></td>
		<td>${detail.useridx}</td>
		</tr>
		<tr>
		<td><b>이름</b></td>
		<td>${detail.username}</td>
		</tr>
		<tr>
		<td><b>ID</b></td>
		<td>${detail.userid}</td>
		</tr>
		<tr>
		<td><b>PW</b></td>
		<td>
		<span id="userpw">
			초기		
		</span>
		<button onclick="btnGo()">보기</button>
		</td>
		</tr>
		<tr>
		<td><b>생성일자</b></td>
		<td align=center>${detail.userindate}</td>
		</tr>
		<tr>
		<td><b>수정일자</b></td>
		<td align=center>${detail.userupdate}</td>
		</tr>
	</table>
	<br>
		<c:if test="${detail.adminToken eq '0'}">
			<form style="float:left; margin-right:10px;" action="/User/UpdateForm" method="POST">
			   <input type="hidden" value="${detail.userid}" name="userid">
			   <input type="submit" value="수정">
			</form>
			<form action="/User/Delete" method="POST" onsubmit="return deleteUser();">
			   <input type="hidden" value="${detail.userid}" name="userid">
			   <input type="submit" value="탈퇴">
			</form>
		</c:if>
		
		<c:if test="${detail.adminToken eq '1'}">
			<form action="/User/DeleteAdmin" method="POST" onsubmit="return deleteAdmin();">
			   <input type="hidden" value="${detail.userid}" name="userid">
			   <input type="submit" value="추방">
			</form>
		</c:if>
	<br>
	<a href="/Board/First?userid=${detail.userid}">메인화면</a>
</body>
</html>
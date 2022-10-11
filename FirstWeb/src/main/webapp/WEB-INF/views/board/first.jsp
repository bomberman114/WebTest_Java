<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.basic.user.vo.UserVo" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
function logout() {
	if (!confirm('로그아웃 하시겠습니까?')) {
		return false;
	}
}
</script>
</head>
<body>
<% UserVo login = (UserVo) request.getAttribute("loginUser");
String  adminToken  = login.getAdminToken();
String userid = login.getUserid();
String username = login.getUsername();

if (adminToken != null) {
%>
	 <h2><strong style="color:royalblue"><%=username %></strong>님 안녕하세요.</h2>
	 
	 <form style="float:left; margin-right:10px;" action="/Login/Logout" method="POST" onsubmit="return logout();">
	 	<input type="submit" value="로그아웃">
	 </form>
	 
	 <% if (adminToken.equals("0")) { %>
	 <form action="/User/Detail" method="POST">
	 	<input type="hidden" value="<%=userid %>" name="userid">
	 	<input type="submit" value="마이페이지">
	 </form>
	 <% } %>
	 
	 <% if (adminToken.equals("1")) { %>
	 <form action="/User/List" method="POST">
	 	<input type="submit" value="회원목록">
	 </form>
	
	 <% } %>
<% } %>
 <form action="/Menu/CreatForm" method="POST">
	 <input type="submit" value="게시판 메뉴만들기">
	    </form>

<a href="/Menu/List">게시판 메뉴가기</a>

</body>
</html>
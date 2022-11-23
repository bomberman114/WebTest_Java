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

	<h2>검색페이지</h2>
	<a href="/">home</a>
	<form action="/Naver/Search">
		<input type="text" name="keyword">
		
		<input type="submit" value="검색">
	</form>
	<table border="1">
		<tr>
			<!--  	<td colspan ="7" width="100%" ></td> -->
		</tr>
		<c:forEach items="${book}" var="b">
			<tr>
				<td><img width="200" src="${b.image}"></td>
				<td><div style="width: 80px; height: 50px;">
						<b>책이름</b>
					</div></td>
				<td><div style="width: 180px">${b.title}</div></td>
				<td><b>저자</b></td>
				<td>${b.author}</td>
				<td><b>할인가격</b></td>
				<td>${b.discount}</td>
				<td><b>출판사</b></td>
				<td>${b.publisher}</td>
				<td><b>출간일</b></td>
				<td>${b.pubdate}</td>
			</tr>

		</c:forEach>
	</table>
	<br>

		<c:if test="${keyword ne null && keyword ne ''}">
	<!-- 페이징 기능 -->
	<div style="margin-left: 20px;">

		<!-- 처음으로 버튼 -->
		<c:if test="${pa ne 1}">
			<a href="/Naver/Search?page=${pagination.page}&keyword=${keyword}">처음으로</a>
		</c:if>
		
		<c:if test="${pagination.prev}">
			<a href="#">이전</a>
		</c:if>

		<!-- 각 페이지 별 페이징 기능 -->
		<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="page"  >
			<a href="/Naver/SearchPage?page=${pagination.page}&keyword=${keyword}&range=${pagination.range}&clikpage=${page}">${page}</a>
		</c:forEach>

		<!-- 다음 버튼 -->
		<c:if test="${pa ne 100 }"> <!-- 네이버책api 검색에는 1000까지 밖에 지원을 안하니 나는 10개씩 보여줄거여서 100개로 제한한다. -->
		<c:if test="${pagination.next}">
			<a href="/Naver/SearchNext?page=${pagination.page}&keyword=${keyword}&range	=${pagination.range}&next=${pagination.next}">다음</a>
		</c:if>
		</c:if>
		<h2>현재페이지:${pa}</h2>
	</div>
		</c:if>
</body>
</html>
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
<script>
	
	/*
	var listSize =`${listSize}`;
	var page =`${pa}`;
	var range =`${pagnation.range}`;
	var keyword =`${keyword}`;
	
	function listSizesend(listSize){
		
	   var listSize  = document.getElementById("listSize");
		var value = (listSize.options[city.selectedIndex].value);
		alert("value = "+value);
	
		
				
		var selectedindex = city.selectedIndex;
		alert("value = "+value+" , selectedindex = "+selectedindex); 
		
	     };
	*/


</script>
</head>
<body>

	<h2>검색페이지</h2>
	<a href="/">home</a>
	<c:if test="${keyword eq null || keyword eq '' }">
	<form action="/Naver/Search">
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	</c:if>
	<br>
	<!-- 페이지에 보일 리스트 개수 결정 -->
	<c:if test="${keyword ne null && keyword ne '' }">
<form action="/Naver/SearchSize" method="GET">
  	<input type="text" value="${keyword}" name="keyword" >
  	<input type="hidden" value="${pa}" name="page" >
  	<input type="hidden" value="${pagination.range}" name="range">
	<c:if test="${listSize eq 10}">
		<select name="listSize" onchange="this.form.submit()">
	       <option value="10" selected>10개씩 보기</option>
	       <option value="20">20개씩 보기</option>
	       <option value="30">30개씩 보기</option>
	       <option value="40">40개씩 보기</option>
	  	</select>
  	</c:if>
	<c:if test="${listSize eq 20}">
		<select name="listSize" onchange="this.form.submit()">
	       <option value="10">10개씩 보기</option>
	       <option value="20" selected>20개씩 보기</option>
	       <option value="30">30개씩 보기</option>
	       <option value="40">40개씩 보기</option>
	  	</select>
  	</c:if>
	<c:if test="${listSize eq 30}">
		<select name="listSize" onchange="this.form.submit()">
	       <option value="10">10개씩 보기</option>
	       <option value="20">20개씩 보기</option>
	       <option value="30" selected>30개씩 보기</option>
	       <option value="40">40개씩 보기</option>
	  	</select>
  	</c:if>
	<c:if test="${listSize eq 40}">
		<select name="listSize" onchange="this.form.submit()">
	       <option value="10">10개씩 보기</option>
	       <option value="20">20개씩 보기</option>
	       <option value="30">30개씩 보기</option>
	       <option value="40" selected>40개씩 보기</option>
	  	</select>
  	</c:if>
	</form>
<br>
	</c:if>
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
			<a href="/Naver/Search?page=${pagination.page}&keyword=${keyword}
			&listSize=${listSize}">처음으로</a>
		</c:if>
		<!-- 이전 버튼 -->
		<c:if test="${pa ne 1}">
			<a href="/Naver/SearchPrev?page=${pagination.page}&keyword=${keyword}&range=${pagination.range}&next=${pagination.next}
			&listSize=${listSize}">이전</a>
		</c:if>

		<!-- 각 페이지 별 페이징 기능 -->
		<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="page"  >
			<a href="/Naver/SearchPage?page=${pagination.page}&keyword=${keyword}&range=${pagination.range}&clikpage=${page}
			&listSize=${listSize}">${page}</a>
		</c:forEach>

		<!-- 다음 버튼 -->
		<!-- 네이버책api는 1000개까지 검색을 제한한다. -->
		<c:if test="${pagination.next}">
			<a href="/Naver/SearchNext?page=${pagination.page}&keyword=${keyword}&range	=${pagination.range}&next=${pagination.next}
			&listSize=${listSize}">다음</a>
		</c:if>
		<h2>현재페이지:${pa}</h2>
	</div>
		</c:if>
</body>
</html>
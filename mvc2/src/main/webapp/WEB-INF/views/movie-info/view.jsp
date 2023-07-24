<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>영화 상세화면</h3>
<form action="/movie-info/delete" method="POST">
	<input type="hidden" name="miNum" value="${movieInfo.miNum}">
<table border="1">
	<tr>
		<th>번호</th>
		<td>${movieInfo.miNum}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${movieInfo.miTitle}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${movieInfo.miDesc}</td>
	</tr>
	<tr>
		<th>장르</th>
		<td>${movieInfo.miGenre}</td>
	</tr>
		<tr>
		<th>상영일</th>
		<td>${movieInfo.miCredat}</td>
	</tr>
		<tr>
		<th>관객수</th>
		<td>${movieInfo.miCnt}</td>
	</tr>
	<tr>
		<th colspan="2">
			<button onclick="location.href='/movie-info/update?miNum=${movieInfo.miNum}'">수정</button>
			<button>삭제</button>
		</th>
	</tr>
</table>
</form>
</body>
</html>
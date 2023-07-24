<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>영화 수정</h3>
	<form action="/movie-info/update" method="POST">
	<input type="hidden" name="miNum" value="${movieInfo.miNum }">
		<input type="text" name="miTitle" placeholder="제목" value="${movieInfo.miTitle }"> <br> 
		<input type="text" name="miDesc" placeholder="내용" value="${movieInfo.miDesc }"> <br> 
		<input type="text" name="miGenre" placeholder="장르" value="${movieInfo.miGenre }"> <br>
		<input type="text" name="miCredat" placeholder="상영일" value="${movieInfo.miCredat }"> <br>
		<input type="text" name="miCnt" placeholder="관객수" value="${movieInfo.miCnt }"> <br>
		<button>수정</button>
	</form>
</body>
</html>
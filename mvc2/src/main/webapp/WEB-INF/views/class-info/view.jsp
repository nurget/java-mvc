<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>클래스 상세화면</h3>
<table border="1">
	<tr>
		<th>번호</th>
		<td>${classInfo.ciNum}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${classInfo.ciName}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${classInfo.ciDesc}</td>
	</tr>
</table>
</body>
</html>
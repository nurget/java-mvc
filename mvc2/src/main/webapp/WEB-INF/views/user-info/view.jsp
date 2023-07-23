<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>유저 상세화면</h3>
<table border="1">
	<tr>
		<th>번호</th>
		<td>${userInfo.uiNum}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${userInfo.uiName}</td>
	</tr>
	<tr>
		<th>아이디</th>
		<td>${userInfo.uiId}</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>${userInfo.uiPwd}</td>
	</tr>
</table>
</body>
</html>
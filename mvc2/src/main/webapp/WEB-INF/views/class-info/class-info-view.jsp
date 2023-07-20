<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if (request.getAttribute("classInfo") == null) {
	%>
	<script>
		alert('너 삭제!');
		location.href='/class-info/list';
	</script>
	<% 
	return;
}
Map<String, String> classInfo = (Map<String, String>) request.getAttribute("classInfo");
%>
<h3>클래스 상세 화면</h3>
<table border="1">
	<tr>
		<th>번호</th>
		<td><%=classInfo.get("ciNum") %></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><%=classInfo.get("ciName") %></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><%=classInfo.get("ciDesc") %></td>
	</tr>
</table>
</body>
</html>
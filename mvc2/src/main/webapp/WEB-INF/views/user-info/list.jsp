<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>유저 리스트</h3>
<%
List<Map<String,String>> list = (List<Map<String,String>>)request.getAttribute("userInfoList");
%>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>아이디</th>
		<th>비밀번호</th>
	</tr>
<%= %>
</table>
</body>
</html>
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
pageContext.setAttribute("name","pageContext");
request.setAttribute("name","request");
session.setAttribute("name","session");
application.setAttribute("name","application");
%>
${name}<br>
${requestScope.name}<br>
${sessionScope.name}<br>
</body>
</html>
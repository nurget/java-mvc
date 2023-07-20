<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.repository.ClassInfoRepository"%>
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
ClassInfoRepository ciRepo = new ClassInfoRepository();
List<Map<String,String>> classInfoList = ciRepo.selectClassInfoList();
for(Map<String,String> classInfo : classInfoList){
%>
	번호 : <%=classInfo.get("ciNum")%><br>
	강의명 : <%=classInfo.get("ciName")%><br>
	설명 : <%=classInfo.get("ciDesc")%><br>
<%
}
%>
</body>
</html>
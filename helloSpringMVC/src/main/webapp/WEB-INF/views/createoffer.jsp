<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
Date nowDate = new Date();  
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhh"); 
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/main.css?v=<%=simpleDateFormat.toString()%>"
	rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>

	<form method="get" action="${pageContext.request.contextPath}/docreate">
		<table class="formtable">
			<tr>
				<td class="lable">Name:</td>
				<td><input class="control" name="name" type="text" /></td>
			</tr>
			<tr>
				<td class="lable">Email:</td>
				<td><input class="control" name="email" type="text" /></td>
			</tr>
			<tr>
				<td class="lable">text:</td>
				<td><textarea class="control" name="text" rows="10" cols="10"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="control" value="Create offer" type="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
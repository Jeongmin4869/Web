<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
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

	<sf:form method="get" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">
		<table class="formtable">
			<tr>
				<td class="lable">Name:</td>
				<td><sf:input class="control" path="name" type="text" /> <br/>
				<sf:errors cssClass="error" path="name"></sf:errors>
				</td>
			</tr>
			<tr>
				<td class="lable">Email:</td>
				<td><sf:input class="control" path="email" type="text" /><br/>
				<sf:errors cssClass="error" path="email"></sf:errors>
				</td>
			<tr>
				<td class="lable">Your Offer:</td>
				<td><sf:textarea class="control" path="text" rows="10" cols="10" /><br/>
				<sf:errors cssClass="error" path="text"></sf:errors>
				</td>
			<tr>
				<td></td>
				<td><input class="control" value="Create offer" type="submit" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>
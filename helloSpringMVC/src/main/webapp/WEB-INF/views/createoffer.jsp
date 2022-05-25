<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/main.css" 
		rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>

	<form method="get" action="${pageContext.request.contextPath}/docreate">
		<table class="formtable">
			<tr>
				<td class="lable">Name:</td>
				<td><input name="name" type="text" /></td>
			</tr>
			<tr>
				<td class="lable">Email:</td>
				<td><input name="email" type="text" /></td>
			</tr>
			<tr>
				<td>text:</td>
				<td><textarea name="text" rows="10" cols="10"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input value="Create offer" type="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
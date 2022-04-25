<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- JSF Expression Language --%>
	<ul>
		<li>Id : ${customer.id}</li>
		<li>Name : ${customer.name}</li>
		<li>Email : ${customer.email}</li>
	</ul>

	<%-- JSTL --%>
	<table style="border: 1px solid red; padding: 10px;">
		<c:forEach var="customer" items="${customerList}">
			<tr>
				<td>${customer.id}</td>
				<td>${customer.name}</td>
				<td>${customer.email}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
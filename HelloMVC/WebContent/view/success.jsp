<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</body>
</html>
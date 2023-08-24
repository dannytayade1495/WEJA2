<%@ page language="java" 
contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!int num1, num2, sub;%>
	<%
	num1 = Integer.parseInt(request.getParameter("num1"));
	num2 = Integer.parseInt(request.getParameter("num2"));
	sub = num1 - num2;
	%>
	<h1>
		Difference between
		<%=num1%>
		and
		<%=num2%>
		=
		<%=sub%></h1>
</body>
</html>
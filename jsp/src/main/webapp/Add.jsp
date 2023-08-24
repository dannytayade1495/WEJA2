<%@ page language="java" contentType="text/html; 
charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!int num1, num2, sum;%>
	<%
	num1 = Integer.parseInt(request.getParameter("num1"));
	num2 = Integer.parseInt(request.getParameter("num2"));
	sum = num1 + num2;
	%>
	<h1>
		Sum of
		<%=num1%>
		and
		<%=num2%>
		=
		<%=sum%></h1>
</body>
</html>
<jsp:forward page="Sub.jsp"></jsp:forward>
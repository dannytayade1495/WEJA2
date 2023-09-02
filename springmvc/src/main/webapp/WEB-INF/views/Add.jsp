<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}
</style>
</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Add Student Details</legend>
			<form action="" method="post">
				<table>
					<tr>
						<td>Name</td>
						<td><input type="text" name=""></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name=""></td>
					</tr>
					<tr>
						<td>Contact</td>
						<td><input type="text" name=""></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name=""></td>
					</tr>
				</table>
				<input type="submit" value="ADD">
			</form>
		</fieldset>
	</div>
</body>
</html>
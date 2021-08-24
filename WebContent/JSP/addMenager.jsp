<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddMenagerServlet" method="POST">
<table>
	<tr>
		<td>Username</td>
		<td><input type="text" name ="username"/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name ="password"/></td>
	</tr>
	<tr>
		<td>Name</td>
		<td><input type="text" name ="name"/></td>
	</tr>
	<tr>
		<td>Surname</td>
		<td><input type="text" name ="surname"/></td>
	</tr>
	<tr>
		<td>Gender</td>
		<td><input type="text" name ="gender"/></td>
	</tr>
	<tr>
		<td>Birth date</td>
		<td><input type="text" name ="birthdate"/></td>
	</tr>
	<tr>
		<td>Nummber of points</td>
		<td><input type="text" name ="nummberOfPoints"/></td>
	</tr>
	<tr>
		<td>Type of buyer</td>
		<td><input type="text" name ="typeOfBuyerString"/></td>
	</tr>
	<tr><td><input type="submit" value="AddMenager"></td></tr>
</table>
</form>
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("err") != null) { %>
		<p style="color: red"><%=request.getAttribute("err")%>></p>
	<% } %>
</body>
</html>
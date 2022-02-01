<%@page contentType="text/html; charset=UTF-8" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/SeeYourProfileServlet" method="POST">
<table>
	<tr>
		<td>UserName</td>
		<td><input type="text" name ="username" value=" ${user.username}"/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name ="password" value=" ${user.password}"/></td>
	</tr>
	<tr>
		<td>FirstName</td>
		<td><input type="text" name ="firstName" value=" ${user.firstName}"/></td>
	</tr>
	<tr>
		<td>LastName</td>
		<td><input type="text" name ="lastName" value=" ${user.lastName}"/></td>
	</tr>
	<tr>
		<td>Gender</td>
		<td><input type="text" name ="gender" value=" ${user.getGender().toString()}"/></td>
	</tr>
	<tr>
		<td>DateOfBirth</td>
		<td><input type="text" name ="date" value=" ${user.getDateOfBirth().toString()}"/></td>
	</tr>
	<tr><td><input type="submit" value="Edit"></td></tr>
</table>
</form>
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("err") != null) { %>
		<p style="color: red"><%=request.getAttribute("err")%>></p>
	<% } %>
</body>
</html>
<%@page contentType="text/html; charset=UTF-8" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/AddNewUserServlet" method="POST">
<table>
	<tr>
		<td>User type</td>
		<td>
		<select name="role">
			<option>Manager</option>
			<option>DeliveryGuy</option>
		</select>
		</td>
	</tr>
	<tr>
		<td>UserName</td>
		<td><input type="text" name ="username"/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name ="password"/></td>
	</tr>
	<tr>
		<td>FirstName</td>
		<td><input type="text" name ="firstName"/></td>
	</tr>
	<tr>
		<td>LastName</td>
		<td><input type="text" name ="lastName"/></td>
	</tr>
	<tr>
		<td>Gender</td>
		<td><input type="text" name ="gender"/></td>
	</tr>
	<tr>
		<td>DateOfBirth</td>
		<td><input type="text" name ="date"/></td>
	</tr>
	<tr><td><input type="submit" value="Add"></td></tr>
</table>
</form>
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("err") != null) { %>
		<p style="color: red"><%=request.getAttribute("err")%>></p>
	<% } %>
</body>
</html>
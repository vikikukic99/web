<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/AddNewRestaurantServlet" method="POST">
<table>
	<tr>
		<td>Name</td>
		<td><input type="text" name ="name"/></td>
	</tr>
	<tr>
		<td>RestaurantType</td>
		<td>
		<select name="restaurantType">
			<option>Italian</option>
			<option>Greek</option>
			<option>American</option>
			<option>Pizza</option>
			<option>SeaFood</option>
			<option>Chinese</option>
			<option>Barbecue</option>
			<option>FastFood</option>
			<option>Domestic</option>
		</select>
		</td>
	</tr>
	<tr>
		<td>GeographicalLength</td>
		<td><input type="text" name ="geographicalLength"/></td>
	</tr>
	<tr>
		<td>GeographicalWidth</td>
		<td><input type="text" name ="geographicalWidth"/></td>
	</tr>
	<tr>
		<td>Address</td>
		<td><input type="text" name ="address"/></td>
	</tr>
	<tr>
		<td>RestaurantLogo</td>
		<td><input type="text" name ="restaurantLogo"/></td>
	</tr>
	<tr>
		<td>Manager</td>
		<td>
			<select name ="managerId">
				<c:forEach items = "${requestScope.managers}" var="manager">
					<option value="${manager.userID}">${manager.firstName}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr><td><input type="submit" value="Add"></td></tr>
	<tr><td><a href="AddNewUserServlet">Add manager</a></td></tr>
</table>
</form>
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("err") != null) { %>
		<p style="color: red"><%=request.getAttribute("err")%>></p>
	<% } %>
</body>
</html>
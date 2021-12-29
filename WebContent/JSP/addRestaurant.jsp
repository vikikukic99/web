<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddRestaurantServlet" method="POST">
<table>
	<tr>
		<td>Restaurant name</td>
		<td><input type="text" name ="restaurantName"/></td>
	</tr>
	<tr>
		<td>Restaurant Type</td>
		<td><input type="text" name ="restaurantType"/></td>
	</tr>
	<tr>
		<td>Status</td>
		<td>
		<select name ="status">
			<option value="Open">Open</option>
			<option value="Close">Close</option>
		</select>
		</td>
	</tr>
	<tr>
		<td>Logo of Restaurant</td>
		<td><input type="text" name ="logoOfRestaurant"/></td>
	</tr>
	<tr>
		<td>Adress</td>
		<td><input type="text" name ="adress"/></td>
	</tr>
	<tr>
		<td>Geografical Lenght</td>
		<td><input type="text" name ="geograficalLenght"/></td>
	</tr>
	<tr>
		<td>Geografical Width</td>
		<td><input type="text" name ="geograficalWidth"/></td>
	</tr>
	<tr>
		<td>Menager</td>
		<td>
			<select name="menagerId">
				<c:forEach var="menager" items="${requestScope.menagers}">
					<option value="${menager.iD}"/></option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>Location</td>
		<td><input type="text" name ="location"/></td>
	</tr>
	<tr><td><input type="submit" value="Add new restaurant"></td></tr>
</table>
</form>
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("err") != null) { %>
		<p style="color: red"><%=request.getAttribute("err")%>></p>
	<% } %>
</body>
</html>
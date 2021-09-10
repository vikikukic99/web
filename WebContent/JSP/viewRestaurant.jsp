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
<form action="ViewRestaurantServlet" method="POST">
<table>
	<tr>
		<th>Restaurant name</th>
		<th>Restaurant type</th>
		<th>Location</th>
		<th>Status</th>
		<th>Logo of restaurant</th>
	</tr>
	<tr>
		<td>${restaurant.restaurantName}</td>
		<td>${restaurant.restaurantType}</td>
		<td>${restaurant.location}</td>
		<td>${restaurant.status}</td>
		<td>${restaurant.logoOfRestaurant}</td>
	</tr>
</table>

	<c:forEach var="artical" items="${requestScope.artical}">
		<tr>
			<td>${artical.articalName}</td>
			<td>${artical.price}</td>
			<td>${artical.articalType}</td>
			<td>${artical.quantity}</td>
			<td>${artical.description}</td>
			<td>${artical.picture}</td>
			<td><a href="/?id=${artical.id}"></a>View</td>
		</tr>
	</c:forEach>
	<tr><td><input type="submit" value="Add new restaurant"></td></tr>
</form>
</body>
</html>
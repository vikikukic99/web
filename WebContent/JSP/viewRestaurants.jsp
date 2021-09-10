<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of restaurants</title>
</head>
<body>
<form action="ViewRestaurantsServlet" method="POST">

	<form action="/WebShop/ViewRestaurantsServlet" method="get">
		<table>
			<tr>
				<td>Search</td>
				<td><input type="text" name="search"/></td>
				<input type="submit" value="Search">
			</tr>
			<tr>
				<td>Sort</td>
				<td>
					<select name="sort">
						<option value="Restaurant name">Restaurant name</option>
						<option value="Location">Location</option>
						<option value="Grade">Grade</option>
						<option value="Average rating">Average rating</option>
					</select>
				</td>
			</tr>
		</table>
	</form>
	
	<table>
		<c:forEach var="restaurant" items="${requestScope.restaurants}">
			<tr>
				<td>${restaurant.restaurantName}</td>
				<td>${restaurant.restaurantType}</td>
				<td>${restaurant.location.address}</td>
				<td>${restaurant.location.city}</td>
				<td>${restaurant.location.county}</td>
			</tr>
			
		</c:forEach>
	</table>
</body>
</html>
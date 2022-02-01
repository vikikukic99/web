<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/AllRestaurantsServlet" method="POST">
<table>
	<tr>
		<td>Search</td>
		<td><input type="text" name ="search"/></td>
	</tr>
	<tr>
		<td>Sort</td>
		<td>
			<select name="sort">
				<option>First name</option>
				<option>Location</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>Fitlering by restaurant status</td>
		<td>
			<select name="restaurantStatus">
				<option value="">Select</option>
				<option>working</option>
				<option>not_working</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>Filtering by type of restaurant</td>
		<td>
		<select name="typeOfRestaurant">
			<option value="">Select</option>
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
	
	<tr><td><input type="submit" value="Search"></td></tr>
</table>
</form>
	
	<c:forEach items="${requestScope.restaurants}" var="restaurant">
	   	<p><a href="/WebShop/RestaurantViewServlet?restaurantID=${restaurant.restaurantID}">${restaurant.name}</a></p>
   </c:forEach>
	
	
</body>
</html>

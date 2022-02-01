<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/ShowAllDeliverdOrdersFromRestaurantServlet" method="POST">
<table>
	
</table>
</form>
	<c:forEach items = "${requestScope.orders}" var="order">
	<hr>Order:</hr>
		<p>${order.orderDate}</p>
		<p>${order.cost}</p>
		<p>${order.orderStatus}</p>
		<p>${order.deliveryGuy}</p>
		<p>${order.orderItem}</p>
		<a href="/rateRestaurantServlet?id=${order.resaurant.id} }">Rate</a>
	</c:forEach>
</body>
</html>
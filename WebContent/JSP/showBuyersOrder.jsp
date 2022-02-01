<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/ShowBuyersOrderServlet" method="POST">
<table>
	<tr>
		<td>Search</td>
		<td><input type="text" name ="search"/></td>
	</tr>
	<tr>
		<td>Search by date</td>
		<td><input type="text" name ="searchByDateFrom"/></td>
		<td><input type="text" name ="searchByDateTo"/></td>
	</tr>
	<tr>
		<td>Search by price</td>
		<td><input type="text" name ="searchByPriceFrom"/></td>
		<td><input type="text" name ="searchByPriceTo"/></td>
	</tr>
	<tr>
		<td>Sort</td>
		<td>
			<select name="sort">
				<option value="Restaurant" selected>Restaurant</option>
				<option value="Price">Price</option>
				<option value="OrderDate">OrderDate</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>FilteringByRestuarantType</td>
		<td>
			<select name="filteringRestaurantType">
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
		<td>FilteringByOrderStatus</td>
		<td>
			<select name="filteringByOrderStatus">
				<option value=Processing>Processing</option>
				<option value="InPreparation">InPreparation</option>
				<option value="PendingDelivery">PendingDelivery</option>
				<option value="Transport">Transport</option>
				<option value="Deliverd">Deliverd</option>
				<option value="Canceled">Canceled</option>
			</select>
		</td>
	</tr>
		<tr><td><input type="submit" value="Search"></td></tr>
</table>
</form>
	<c:forEach items = "${requestScope.orders}" var="order">
	<hr>Order:</hr>
		<p>${order.orderDate}</p>
		<p>${order.cost}</p>
		<p>${order.orderStatus}</p>
		<p><a href='/WebShop/ShowArticalForOrderServlet?orderId=${order.orderId}'>ShowArticalesInOrder</a></p>
		
		<c:choose>
			 <c:when  test = "${order.orderStatus == 'Processing'}">
				<form action="/WebShop/CancelOrderServlet" method="post">
	   				<input type="hidden" name="orderID" value="${order.orderId}">
	   				<input type="submit" value="Cancel">
	   			</form>				   			
			</c:when>
		</c:choose>
		
		<c:choose>
			   	<c:when  test = "${order.orderStatus == 'Deliverd'}">
		   			<tr><td><a ${ user.getRole().toString()!="Buyer"  ? 'hidden="hidden"' : ''} href='CommentServlet?orderID=${order.getOrderId()}'>Comment</a></td></tr>
				</c:when>
		</c:choose>

   </c:forEach>
</body>
</html>
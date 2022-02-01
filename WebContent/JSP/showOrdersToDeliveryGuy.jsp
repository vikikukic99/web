<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/ShowOrderToDeliveryGuyServlet" method="POST">
<table>
	
</table>
</form>
	<c:forEach items = "${requestScope.orders}" var="order">
		<p>${order.orderDate}</p>
		<p>${order.cost}</p>
		<p>${order.orderStatus}</p>
		<p>${order.costumer}</p>
		<p>${order.orderItem}</p>
	</c:forEach>
</body>
</html>
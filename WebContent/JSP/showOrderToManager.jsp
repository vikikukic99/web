<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/ShowOrderToManagerServlet" method="POST">
<table>
	
</table>
</form>
	<c:forEach items = "${requestScope.orders}" var="order">
	<hr>Artical:</hr>
		<p>${order.orderDate}</p>
		<p>${order.cost}</p>
		<p>${order.orderStatus}</p>
		<p>${order.costumer.firstName}</p>
		<p>${order.deliveryGuy.firstName}</p>		
		
		<c:choose>
	   		<c:when test="${requestScope.user.role=='Manager' && order.orderStatus=='Processing'}">
					<form action="ProcessingToInPreparationStatusServlet" method="post">
						<input type="hidden" name="orderId" value="${order.orderId}">
						<input type = "submit" value = "Prepare">
					</form>	  	
	   		</c:when>
	   	</c:choose>
		
	   	<c:choose>
	   		<c:when test="${requestScope.user.role=='Manager' && order.orderStatus=='InPreparation'}">
					<form action="ChangeDeliveryStatusServlet" method="post">
						<input type="hidden" name="orderId" value="${order.orderId}">
						<input type = "submit" value = "ChangeDeliveryStatus">
					</form>	  	
	   		</c:when>
	   	</c:choose>
	   	
	   	<c:choose>
	   		<c:when test="${requestScope.user.role=='DeliveryGuy' && order.orderStatus=='Transport'}">
				<form action="TransportToDeliverdStatusServlet" method="post">
					<input type="hidden" name="orderId" value="${order.orderId}">
					<input type = "submit" value = "ChangeDeliveryStatus">
				</form>	   		
	   		</c:when>
	   	</c:choose>
	   	
		<c:choose>
	   		<c:when test="${requestScope.user.role=='DeliveryGuy' && order.orderStatus=='PendingDelivery'}">
				<form action="TakeOrderServlet" method="post">
					<input type="hidden" name="orderId" value="${order.orderId}">
					<input type = "submit" value = "TakeOrder">
				</form>	   		
	   		</c:when>
	   	</c:choose>
	   	
	   	<c:choose>
	   		<c:when test="${requestScope.user.role=='Manager' && order.orderStatus=='ManagerRequest'}">
				<form action="AcceptRequestServlet" method="post">
					<input type="hidden" name="orderId" value="${order.orderId}">
					<input type = "submit" value = "AcceptRequest">
				</form>	   		
	   		</c:when>
	   	</c:choose>
	   	
	   	<c:choose>
	   		<c:when test="${requestScope.user.role=='Manager' && order.orderStatus=='ManagerRequest'}">
				<form action="NotAcceptRequestServlet" method="post">
					<input type="hidden" name="orderId" value="${order.orderId}">
					<input type = "submit" value = "NotAcceptRequest">
				</form>	   		
	   		</c:when>
	   	</c:choose>
	   	
		
	</c:forEach>
</body>
</html>
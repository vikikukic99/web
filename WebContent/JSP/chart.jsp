<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/ChartServlet" method="POST">
<table>
	
</table>
</form>

	<c:forEach items = "${requestScope.cartItems}" var="cartItem">
		<p>${cartItem.articalName}</p>
		<p>${cartItem.quantity}</p>
		<p>${cartItem.price}</p>
		<p>${cartItem.articalImage}</p>
		<form action="#" method = "post">
		<input type = "hidden" value = "${cartItem.cartItemID}">
		<input type = "number" value = "${cartItem.quantity}">
		<input type = "submit" value = "update">
		</form>
	</c:forEach>
	
	<p>${requestScope.cart.price}</p>
	
	<form action="" method="post">
	<input type ="number" name = "quantity">
	<input type = "submit" value = "Add">
	</form>
	
	<tr><td><a href='ShowChartServlet?id=${cart.getCartID}'>showChart</a></td></tr>
	<tr><td><a href='DeleteArticalInChartServlet?id=${artical.getArticalID}'>deleteArticalInChart</a></td></tr>
	<tr><td><a href='ChangeArticalQuantityServlet?id=${artical.getArticalID}'>changeArticalQuantity</a></td></tr>
	
	<% if(request.getAttribute("error") != null) { %>
	<p style = "color: red"> <%=request.getAttribute("error") %></p>
	<% } %>
	
</body>
</html>
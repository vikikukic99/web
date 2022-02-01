<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/ShowChartServlet" method="POST">
<table>
	
</table>
</form>

	<c:forEach items = "${requestScope.cartItems}" var="cartItem">
	<hr>CartItem:</hr>
		<p>${cartItem.artical.articalName}</p>
		<p>${cartItem.quantity}</p>
		<p>${cartItem.artical.price}</p>
		<p><img src="${cartItem.artical.articalImage}" height="100"/></p>
		
		<form action="/WebShop/ShowChartServlet" method="post">
	   			<input type="hidden" name="cartItemID" value="${cartItem.cartItemID}">
	   			<input type="number" name="quantity" value="${cartItem.quantity}">
	   			<input type="submit" value="Update">
	   		</form>
	   		<form action="/WebShop/DeleteArticalInChartServlet" method="post">
	   			<input type="hidden" name="articalID" value="${cartItem.artical.articalID}">
	   			<input type="hidden" name="quantity" value="${cartItem.quantity}">
	   			<input type="submit" value="Remove">
	   		</form>
   		</c:forEach>
	    
	    <p>${requestScope.cart.price}</p>
	    
	   <form action="/WebShop/OrderingServlet" method="post">
	    	<input type="submit" value="Order">
	    </form>
	
	<% if(request.getAttribute("error") != null) { %>
	<p style = "color: red"> <%=request.getAttribute("error") %></p>
	<% } %>
	
</body>
</html>
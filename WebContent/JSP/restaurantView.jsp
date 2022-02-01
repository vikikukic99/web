<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/RestaurantViewServlet" method="POST">
<table>
	
</table>
</form>
	<p>${requestScope.restaurant.name}</p>
	    <p>${requestScope.restaurant.restaurantType}</p>
	    <p>${requestScope.restaurant.restaurantStatus}</p>
	    <p>${requestScope.restaurant.location}</p>
	    <p>${requestScope.restaurant.averageGrade}</p>	
	    <p><img src="${requestScope.restaurant.getRestaurantLogo()}" height="100"/></p>
	    <c:forEach items="${requestScope.articals}" var="artical">
	    <hr>Artical:</hr>
	    	<p>${artical.articalName}</p>
	   		<p><img src="${artical.getArticalImage()}" height="100"/></p>
	   		<p>${artical.description}</p>
	   		<p>${artical.price}</p>
	   		
	   		<c:choose>
	   			<c:when test="${requestScope.user.role=='Buyer'}">
			   		<p><a href='/WebShop/ViewArticalServlet?articalID=${artical.articalID}'>ViewArtical</a></p>
			   		<p><a href='/WebShop/ShowChartServlet?cartID=${cart.cartID}'>ShowCart</a></p>
			   	</c:when>
		   	</c:choose>
   		</c:forEach>
   		
	<c:forEach items = "${requestScope.approvedComment}" var="comment">
		<p>${comment.text}</p>
		<p>${comment.grade}</p>
		
	</c:forEach>
	
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("err") != null) { %>
		<p style="color: red"><%=request.getAttribute("err")%>></p>
	<% } %>
</body>
</html>
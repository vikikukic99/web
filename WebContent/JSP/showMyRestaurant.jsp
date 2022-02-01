<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/ShowMyRestaurantServlet" method="POST">
<table>
</table>
</form>

	<p>${requestScope.restaurant.name}</p>
	    <p>${requestScope.restaurant.restaurantType}</p>
	    <p>${requestScope.restaurant.restaurantStatus}</p>
	    <p><img src="${requestScope.restaurant.getRestaurantLogo()}" height="100"/></p>
	    
	    <c:forEach items="${requestScope.articles}" var="artical">
	   	 <hr>Artical:</hr>
	    	<p>${artical.articalName}</p>
	   		<p><img src="${artical.getArticalImage()}" height="100"/></p>
	   		<p>${artical.description}</p>
	   		<p>${artical.price}</p>
	   		<p><a href='/WebShop/ViewArticalServlet?articalID=${artical.articalID}'>ViewArtical</a></p>	
	   		<p><a href='/WebShop/ChangeArticalServlet?articalID=${artical.articalID}'>ChangeArtical</a></p>
	   					
   		</c:forEach>
   		
   		<p><a href='/WebShop/AddNewArticalServlet?restaurantID=${restaurant.restaurantID}'>AddNewArtical</a></p>
   		
   		
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("err") != null) { %>
		<p style="color: red"><%=request.getAttribute("err")%>></p>
	<% } %>
</body>
</html>
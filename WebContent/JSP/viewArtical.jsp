<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/ViewArticalServlet" method="POST">
<table>
	
</table>
</form>
		<p>${requestScope.artical.articalName}</p>
	    <p>${requestScope.artical.quantity}</p>
	    <p>${requestScope.artical.type}</p>
	    <p><img src="${requestScope.artical.getArticalImage()}" height="100"/></p>
	   	<p>${requestScope.artical.description}</p>
	   	<p>${requestScope.artical.price}</p>	
	   	
	   	<c:choose>
	   		<c:when test="${requestScope.user.role=='Buyer'}">
		<form action="CreateOrderServlet" method="post">
			<input type="hidden" name="articalID" value="${artical.articalID}">
			<input type ="number" name = "quantity">
			<input type = "submit" value = "Add">
		</form>	   		
	   		</c:when>
	   	</c:choose>
	    	
	
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("err") != null) { %>
		<p style="color: red"><%=request.getAttribute("err")%>></p>
	<% } %>
</body>
</html>
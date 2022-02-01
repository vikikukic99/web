<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
</head>
<body>
<form action="/WebShop/ShowArticalForOrderServlet" method="POST">
<table >
 		
</table>
</form>	  	
	  	<c:forEach items="${requestScope.orderItems}" var="orderItem">
	  		<p>${orderItem.artical.articalName}</p>
   		</c:forEach>
	    

	   <form action="/WebShop/ShowArticalForOrderServlet" method="post">
	    	<input type="submit" value="Home page">
	    </form>
	    
	    <% if (request.getAttribute("error") != null) { %>
		<p style="color: red"><%=request.getAttribute("error")%>></p>
	<% } %>
</body>
</html>
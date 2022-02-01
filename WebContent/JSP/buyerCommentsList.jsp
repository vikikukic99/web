<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
</head>
<body>
<form action="/WebShop/ShowApprovedCommentsServlet" method="POST">
<table>
 		
</table>
</form>	 
	<hr>Comment:</hr> 	
	  	<c:forEach items="${requestScope.comments}" var="comment">
	  		<p>${comment.text}</p>
	   		<p>${comment.grade}</p>
	   		<p>${comment.user.firstName}</p>
	   		<p>${comment.commentStatus}</p>	
		   	
   		</c:forEach>
	    
	    <% if (request.getAttribute("error") != null) { %>
		<p style="color: red"><%=request.getAttribute("error")%>></p>
	<% } %>
</body>
</html>
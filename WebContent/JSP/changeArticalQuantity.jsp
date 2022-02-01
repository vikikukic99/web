<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/ChangeArticalQuantityServlet" method="POST">
<table>
	
	<tr>
		<td>quantity</td>
		<td><input type="text" name ="quantity"/></td>
	</tr>

	<tr><td><input type="submit" value="Change"></td></tr>
</table>
</form>
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("err") != null) { %>
		<p style="color: red"><%=request.getAttribute("err")%>></p>
	<% } %>
</body>
</html>
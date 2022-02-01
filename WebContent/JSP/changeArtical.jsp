<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/ChangeArticalServlet" method="POST">
<table>
	<tr>
		<td>articalName</td>
		<td><input type="text" name ="articalName" value="${artical.articalName}"/></td>
	</tr>
	<tr>
		<td>price</td>
		<td><input type="text" name ="price" value="${artical.price}" /></td>
	</tr>
		<tr>
		<td>type</td>
		<td>
		<select name="type" value="${artical.type}">
			<option>meal</option>
			<option>drink</option>
     	</select>
		</td>
	</tr>
	<tr>
		<td>articalImage</td>
		<td><input type="text" name ="articalImage" value="${artical.articalImage}"/></td>
	</tr>
	<tr>
		<td>description</td>
		<td><input type="text" name ="description" value="${artical.description}"/></td>
	</tr>
	<tr>
		<td>quantity</td>
		<td><input type="text" name ="quantity" value="${artical.quantity}"/></td>
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
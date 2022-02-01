<%@page contentType="text/html; charset=UTF-8" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/AddNewArticalServlet" method="POST">
	
<table>
	<tr>
		<td><input type="hidden" name="restaurantID" value = "${requestScope.restaurant.restaurantID}"/></td>
	</tr>

	<tr>
		<td>articalName</td>
		<td><input type="text" name ="articalname"/></td>
	</tr>
	<tr>
		<td>price</td>
		<td><input type="text" name ="price"/></td>
	</tr>
		<tr>
		<td>type</td>
		<td>
		<select name="type">
			<option>meal</option>
			<option>drink</option>
     	</select>
		</td>
	</tr>
	<tr>
		<td>articalImage</td>
		<td><input type="text" name ="articalImage"/></td>
	</tr>
	<tr>
		<td>description</td>
		<td><input type="text" name ="description"/></td>
	</tr>
	<tr>
		<td>quantity</td>
		<td><input type="text" name ="quantity"/></td>
	</tr>

	<tr><td><input type="submit" value="Add"></td></tr>
</table>
</form>
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("err") != null) { %>
		<p style="color: red"><%=request.getAttribute("err")%>></p>
	<% } %>
</body>
</html>
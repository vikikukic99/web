<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/DeleteArticalInChartServlet" method="POST">
<table>
	<tr>
		<td>articalName</td>
		<td><input type="text" name ="name"/></td>
	</tr>
	<tr>
		<td>price</td>
		<td><input type="text" name ="price"/></td>
	</tr>
		<tr>
		<td>type</td>
		<td>
		<select name="filter">
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

	<tr><td><input type="submit" value="Delete"></td></tr>
</table>
</form>
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("err") != null) { %>
		<p style="color: red"><%=request.getAttribute("err")%>></p>
	<% } %>
</body>
</html>
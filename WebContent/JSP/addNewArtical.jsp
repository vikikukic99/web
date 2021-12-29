<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<form action="AddNewArticalServlet" method="POST">
</form>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form "/WebShop/ViewArticalServlet" method="POST">
		<table>
			<tr>
				<td>Artical name</td>
				<td><input type="text" name ="articalName"/></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name ="price"/></td>
			</tr>
					
			<tr>
				<td>Artical Type</td>
				<td>
				<select name ="artical type">
					<option value="Fruit">Fruit</option>
					<option value="Vegetables">Vegetables</option>
					<option value="Meat">Meat</option>
					<option value="Fish">Fish</option>
					<option value="Pasta">Pasta</option>
					<option value="Sweets">Sweets</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="text" name ="quantity"/></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name ="description"/></td>
			</tr>
			<tr>
				<td>Picture</td>
				<td><input type="text" name ="picture"/></td>
			</tr>
			<tr>
				<td><input type="hidden" name ="restaurantId" value="${requestScopre.restourantID}"/></td>
			</tr>
			<tr><td><input type="submit" value="Add artical"></td>
			</tr>
			</table>
	</form>
		
</body>
</html>
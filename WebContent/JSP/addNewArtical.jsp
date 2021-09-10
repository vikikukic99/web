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
	<form>
		<table>
			<tr>
				<td>Artical name</td>
				<td><input type="text" name ="articalName"/></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="password" name ="price"/></td>
			</tr>
			<tr>
				<td>Artical type</td>
				<td><input type="text" name ="articalType"/></td>
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
				<td>Restaurant</td>
				<td><input type="text" name ="restaurant"/></td>
			</tr>
			<tr><td><input type="submit" value="ViewArtical"></td>
			</tr>
			</table>
	</form>
		
</body>
</html>
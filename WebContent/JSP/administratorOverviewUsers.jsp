<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/AdministratorOverviewUsersServlet" method="POST">
<table>
	<tr>
		<td>Search</td>
		<td><input type="text" name ="search"/></td>
	</tr>
	<tr><td><input type="submit" value="Search"></td></tr>
	<tr>
		<td>Sort</td>
		<td>
			<select name="sort">
				<option>FirstName</option>
				<option>LastName</option>
				<option>UserName</option>
				<option>PointsCollected</option>	
			</select>
		</td>
	</tr>
	<tr>
	<td>FitleringByRole</td>
		<td>
			<select name="role">
				<option value="">Select</option>
				<option>Administrator</option>
				<option>Manager</option>
				<option>DeliveryGuy</option>
				<option>Buyer</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>FilteringByBuyerType</td>
		<td>
		<select name="typeOfBuyer">
			<option value="">Select</option>
			<option>Golden</option>
			<option>Silver</option>
			<option>Bronze</option>
		</select>
		</td>
	</tr>
	</table>
</form>
	<c:forEach items = "${requestScope.users}" var="user">

		 		
		<hr>User:</hr>
		<p>${user.firstName}</p>
		<p>${user.lastName}</p>
		

	</c:forEach>
</body>
</html>
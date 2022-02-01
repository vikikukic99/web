<%@page contentType="text/html; charset=UTF-8" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/CommentServlet" method="POST">
<input type="hidden" name="restaurantID" value="${requestScope.restaurantID}">
<table>
	<tr>
	<td>Comment</td>
	<td>
		<textarea type="text" name ="comment"></textarea>
	</td>
	</tr>
		<tr>
		<td>Grade</td>
		<td>
		<select name="grade">
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
		</select>
		</td>
	</tr>
	<tr><td><input type="submit" value="Leave comment"></td></tr>
</table>
</form>
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("err") != null) { %>
		<p style="color: red"><%=request.getAttribute("err")%>></p>
	<% } %>
</body>
</html>
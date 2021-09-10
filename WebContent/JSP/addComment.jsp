<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddCommentServlet" method="POST">
<input type="hidden" value="${requestScope.restaurantId}">
<table>
	<tr>
	<td>Comment</td>
	<td>
		<textarea type="text" name= "comment"></textarea>
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
		<tr>	
		<td><input type="submit" value ="Leave comment"></td>
	</tr>
</table>
</form>
	<!-- Prikaži grešku, ako je bilo -->
	<% if (request.getAttribute("err") != null) { %>
		<p style="color: red"><%=request.getAttribute("err")%>></p>
	<% } %>
</body>
</html>
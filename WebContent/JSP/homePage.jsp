<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>WebShop</title>
</head>
<body>
	<form method="get" action="/WebShop/LoginServlet">
    <button type="submit">Login</button>
	</form><br><br>
	<form method="get" action="/WebShop/AddArticleServlet">
	<button type="submit" ${ user.getRole().toString()!="Manager"  ? 'hidden="hidden"' : ''}>Add article</button>
	</form><br><br>
	<form method="get" action="/WebShop/ViewArticalServlet">
	<button type="submit" ${ user.getRole().toString()!="Manager"  ? 'hidden="hidden"' : ''}>Edit article</button>
	</form><br><br>
		<form method="get" action="/WebShop/EditProfileServlet">
    <button type="submit">Edit profile</button>
	</form><br><br>
		<form method="get" action="/WebShop/ViewRestaurantsServlet">
    <button type="submit">View all restaurants</button>
	</form><br><br>
		<form method="get" action="/WebShop/RegistrationServlet">
    <button type="submit">Registration</button>
	</form><br><br>
	<form method="get" action="/WebShop/AddNewArticalServlet">
	<button type="submit" ${ user.getRole().toString()!="Manager"  ? 'hidden="hidden"' : ''}>Add new artical</button>
	</form><br><br>
	<form method="get" action="/WebShop/AddMenagerServlet">
	<button type="submit" ${ user.getRole().toString()!="Administrator"  ? 'hidden="hidden"' : ''}>Add new menager</button>
	</form><br><br>
</body>
</html>
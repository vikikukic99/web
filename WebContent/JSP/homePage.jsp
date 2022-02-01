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
	<form method="get" action="AdministratorOverviewUsersServlet">
	<button type="submit" ${ user.getRole().toString()!="Administrator"  ? 'hidden="hidden"' : ''}>See all users</button>
	</form><br><br>
	<form method="get" action="AddNewUserServlet">
	<button type="submit" ${ user.getRole().toString()!="Administrator"  ? 'hidden="hidden"' : ''}>Add manager or delivery guy</button>
	</form><br><br>
	<form method="get" action="AddNewRestaurantServlet">
	<button type="submit" ${ user.getRole().toString()!="Administrator"  ? 'hidden="hidden"' : ''}>Add restaurant</button>
	</form><br><br>
	<form method="get" action="AllRestaurantsServlet">
	<button type="submit">All restaurants</button>
	</form><br><br>
	<form method="get" action="SeeYourProfileServlet">
	<button type="submit">See your profile</button>
	</form><br><br>
	<form method="get" action="AddNewArticalServlet">
	<button type="submit" ${ user.getRole().toString()!="Manager"  ? 'hidden="hidden"' : ''}>Add article</button>
	</form><br><br>
	<form method="get" action="ShowMyRestaurantServlet">
	<button type="submit" ${ user.getRole().toString()!="Manager"  ? 'hidden="hidden"' : ''}>Show my restaurant</button>
	</form><br><br>
	<form method="get" action="ShowOrderToManagerServlet">
	<button type="submit" ${ user.getRole().toString()!="Manager"  ? 'hidden="hidden"' : ''}>Show orders</button>
	</form><br><br>
	<form method="get" action="ShowOrderToManagerServlet">
	<button type="submit" ${ user.getRole().toString()!="DeliveryGuy"  ? 'hidden="hidden"' : ''}>Show orders</button>
	</form><br><br>
	<form method="get" action="CommentStatusServlet">
	<button type="submit" ${ user.getRole().toString()!="Manager"  ? 'hidden="hidden"' : ''}>See all comments</button>
	</form><br><br>
	<form method="get" action="CommentStatusServlet">
	<button type="submit" ${ user.getRole().toString()!="Administrator"  ? 'hidden="hidden"' : ''}>See all comments</button>
	</form><br><br>
	<form method="get" action="ShowBuyersOrderServlet">
	<button type="submit" ${ user.getRole().toString()!="Buyer"  ? 'hidden="hidden"' : ''}>See all orders</button>
	</form><br><br>
	<form method="get" action="ShowApprovedCommentsServlet">
	<button type="submit" ${ user.getRole().toString()!="Buyer"  ? 'hidden="hidden"' : ''}>Show approved comments</button>
	</form><br><br>
</body>
</html>
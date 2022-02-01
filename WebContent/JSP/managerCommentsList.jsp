<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="/WebShop/CommentStatusServlet" method="POST">
<table>
	
</table>
</form>
	<c:forEach items = "${requestScope.comments}" var="comment">
	<hr>Comment:</hr>
		<p>${comment.text}</p>
		<p>${comment.grade}</p>
		<p>${comment.commentStatus}</p>
		
	   	<c:choose>
	   		<c:when test="${requestScope.user.role=='Manager' && comment.commentStatus=='On_review'}">
		  		
				<form action="/WebShop/CommentIsApprovedServlet" method="post">
					   			<input type="hidden" name="commentID" value="${comment.commentID}">
					   			<input type="submit" value="Approved">
				</form>
				<form action="/WebShop/CommentNotApprovedServlet" method="post">
					   			<input type="hidden" name="commentID" value="${comment.commentID}">
					   			<input type="submit" value="NotApproved">
				 </form>
	   		</c:when>
	   	</c:choose>
	</c:forEach>
</body>
</html>
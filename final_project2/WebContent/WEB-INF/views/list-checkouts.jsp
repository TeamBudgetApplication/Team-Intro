<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Checkout List</h2>
	<table>
	<tr>
	<th> Customer </th>
	<th> Movie </th>
	<th> Checkout Date </th>
	<th> Return Date </th>
	</tr>
	<c:forEach var="eachCheckout" items="${checkouts}">
	
	<tr>
	<td>${eachCheckout.customer.firstName} ${eachCheckout.customer.lastName}</td>
	<td>${eachCheckout.movie.title}</td>
	<td>${eachCheckout.checkoutDate}</td>
	<td>${eachCheckout.returnDate}</td>
	</c:forEach>
	</table>
	<form action="addCheckout" method="post">
	<input type="submit" value="Add Checkout Record"/>
	</form>
	<a href=${pageContext.request.contextPath}>Back to Homepage</a>
</body>
</html>
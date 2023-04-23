<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello ${customer.firstName}!</title>
</head>
<body>
<h2>Hello ${customer.firstName}!</h2>
<table>
	<tr>
		<th>Movie Title</th>
		<th>Checkout Date</th>
		<th>Return Date</th>
	</tr>
	<c:forEach var="eachCheckout" items="${checkouts}">
	<tr>
	<td>${eachCheckout.movie.title}</td>
	<td>${eachCheckout.checkoutDate}</td>
	<td>${eachCheckout.returnDate}</td>
	
	<c:if test="${eachCheckout.returnDate==null}">
		<td><form:form action="returnMovie" method="post">
			<input type="hidden" name="customerID" value="${customer.id}"/>
			<input type="hidden" name="checkoutID" value="${eachCheckout.id}"/>
			<input type="submit" value="Return Movie"/>
		</form:form></td>
	</c:if>
	</tr>
	</c:forEach>
</table>
<div>
		<form action="movieSearch" method="get">
			<input type="hidden" name="customerID" value="${customer.id}"/>
			<input type="submit" value="Browse Movies">
		</form>
	</div>
	<div>
		<form action="titleSearch" method="get">
		<input type="hidden" name="customerID" value="${customer.id}"/>
			<input type="submit" value="Title Search">
		</form>
	</div>
<a href=${pageContext.request.contextPath}>Back to Homepage</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>
	<h2>Customer List</h2>
	<table>
	<tr>
	<th> First Name </th>
	<th> Last Name </th>
	<th> Street </th>
	<th> City </th>
	<th> State </th>
	<th> Zipcode </th>
	</tr>
	<c:forEach var="eachCustomer" items="${customers}">
	
	<tr>
	<td>${eachCustomer.firstName}</td>
	<td>${eachCustomer.lastName}</td>
	<td>${eachCustomer.street}</td>
	<td>${eachCustomer.city}</td>
	<td>${eachCustomer.state}</td>
	<td>${eachCustomer.zip}</td>
	
	<td><form:form action="updateCustomer" method="post">
		<input type="hidden" name="customerID" value="${eachCustomer.id }"/>
		<input type="submit" value="Update Info"/>
	</form:form></td>
	<td><form:form action="checkoutHistory" method="get">
		<input type="hidden" name="customerID" value="${eachCustomer.id }"/>
		<input type="submit" value="Checkout History"/>
	</form:form></td>
	<td><form:form action="deleteCustomer" method="delete">
		<input type="hidden" name="customerID" value="${eachCustomer.id }"/>
		<input type="submit" value="Delete"/>
	</form:form></td>
	</tr>
	</c:forEach>
	</table>
	<form action="addCustomer" method="post">
	<input type="submit" value="Add Customer"/>
	</form>
	<a href=${pageContext.request.contextPath}>Back to Homepage</a>
</body>
</html>
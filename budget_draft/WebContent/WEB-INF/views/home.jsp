<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>"this is the homepage"</title>
</head>
<body>
	<div>
		<form action="customer/list" method="get">
			<input type="submit" value="customers">
		</form>
	</div>
	<div>
		<form action="movie/list" method="get">
			<input type="submit" value="movies">
		</form>
	</div>
	<div>
		<form action="checkout/list" method="get">
			<input type="submit" value="checkouts">
		</form>
	</div>
	
	<c:forEach var="eachCustomer" items="${customers}">
		<form:form action="login/checkoutHistory" method="get">
		<input type="hidden" name="customerID" value="${eachCustomer.id }"/>
		<input type="submit" value="login as ${eachCustomer.firstName }"/>
	</form:form>
	</c:forEach>
	<div>
		<form action="api/customers" method="get">
			<input type="submit" value="API customer list">
		</form>
	</div>
	<div>
		<form action="api/checkouts" method="get">
			<input type="submit" value="API checkout list">
		</form>
	</div>
	<div>
		<form action="api/movies" method="get">
			<input type="submit" value="API movie list">
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="processCheckout" modelAttribute="checkout" method="post">
	<form:hidden path="id"/>
		<table>
			<tr>
				<td>Customer:</td>
				<td><form:input path="customer" /></td>
			</tr>
			<tr>
				<td>Movie:</td>
				<td><form:input path="movie" /></td>
			</tr>
			<tr>
				<td>Length (in minutes):</td>
				<td><form:input path="length" /></td>
			</tr>
			<tr>
				<td>Checkout Date:</td>
				<td><form:input path="checkoutDate"/>
			</tr>
			<tr>
				<td>Return Date:</td>
				<td><form:input path="returnDate" /></td>
			</tr>
			<tr>
			<td></td>
				<td><input type="submit" value="Save"/></td>
			</tr>
		</table>
<a href=${pageContext.request.contextPath}/checkout/list  >Back to list</a>
	</form:form>
</body>
</html>
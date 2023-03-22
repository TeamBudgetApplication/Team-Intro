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
<h3>Movie Result:</h3>
	<table>
		<tr>
			<th>Title</th>
			<th>Year</th>
			<th>Length</th>
			<th>Genre</th>
			<th>Release Date</th>
			<th>Rating</th>
			<th>Description</th>
			<th>Copies</th>
			<th>Copies Available</th>
		</tr>

		<tr>
			<td>${movie.title}</td>
			<td>${movie.year}</td>
			<td>${movie.length}</td>
			<td>${movie.genre}</td>
			<td>${movie.releaseDate}</td>
			<td>${movie.rating}</td>
			<td>${movie.description}</td>
			<td>${movie.copies}</td>
			<td>${movie.available}</td>
			<c:if test="${movie.available>0}">
				<td><form:form action="checkoutMovie" method="post">
				<input type="hidden" name="customerID" value="${customer.id }" />
						<input type="hidden" name="movieID" value="${movie.id }" />
						<input type="submit" value="Checkout" />
					</form:form></td>
			</c:if>
			</tr>
	</table>
</body>
</html>
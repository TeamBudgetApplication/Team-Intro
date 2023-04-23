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
	

	<h3>Movie List</h3>
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
		<c:forEach var="eachMovie" items="${movies}">

			<tr>
				<td>${eachMovie.title}</td>
				<td>${eachMovie.year}</td>
				<td>${eachMovie.length}</td>
				<td>${eachMovie.genre}</td>
				<td>${eachMovie.releaseDate}</td>
				<td>${eachMovie.rating}</td>
				<td>${eachMovie.description}</td>
				<td>${eachMovie.copies}</td>
				<td>${eachMovie.available}</td>
				<c:if test="${eachMovie.available>0}">
					<td><form:form action="checkoutMovie" method="post">
					<input type="hidden" name="customerID" value="${customer.id }" />
							<input type="hidden" name="movieID" value="${eachMovie.id }" />
							<input type="submit" value="Checkout" />
						</form:form></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
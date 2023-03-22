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
	<h2>Movie List</h2>
	<table>
	<tr>
	<th> Title </th>
	<th> Year </th>
	<th> Length </th>
	<th> Genre </th>
	<th> Release Date </th>
	<th> Rating </th>
	<th> Description </th>
	<th> Copies </th>
	<th> Copies Available </th>
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
	
	<td><form:form action="updateMovie" method="post">
		<input type="hidden" name="movieID" value="${eachMovie.id }"/>
		<input type="submit" value="Update Info"/>
	</form:form></td>
	<td><form:form action="checkoutHistory" method="get">
		<input type="hidden" name="movieID" value="${eachMovie.id }"/>
		<input type="submit" value="Checkout History"/>
	</form:form></td>
	<td><form:form action="deleteMovie" method="delete">
		<input type="hidden" name="movieID" value="${eachMovie.id }"/>
		<input type="submit" value="Delete"/>
	</form:form></td>
	</tr>
	</c:forEach>
	</table>
	<form action="addMovie" method="post">
	<input type="submit" value="Add Movie"/>
	</form>
	<a href=${pageContext.request.contextPath}>Back to Homepage</a>
</body>
</html>
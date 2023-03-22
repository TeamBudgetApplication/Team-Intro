<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="processMovie" modelAttribute="movie" method="post">
	<form:hidden path="id"/>
		<table>
			<tr>
				<td>Title:</td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>Year:</td>
				<td><form:input path="year" /></td>
			</tr>
			<tr>
				<td>Length (in minutes):</td>
				<td><form:input path="length" /></td>
			</tr>
			<tr>
			<td>Genre(s):</td>
			<td><form:checkboxes path="genre" items="${genreList}"/>
			</tr>
			<tr>
				<td>Release Date:</td>
				<td><form:input path="releaseDate" /></td>
			</tr>
			<tr>
				<td>Rating:</td>
				<td><form:select path="rating" >
				
				<form:option value="G">G</form:option>
				<form:option value="PG">PG</form:option>
				<form:option value="PG-13">PG-13</form:option>
				<form:option value="R">R</form:option>
				</form:select></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:textarea path="description"/></td>
			</tr>
			<tr>
				<td>Copies:</td>
				<td><form:input path="copies" /></td>
			</tr>
			<tr>
				<td>Copies Available:</td>
				<td><form:input path="available" /></td>
			</tr>
			<tr>
			<td></td>
				<td><input type="submit" value="Save"/></td>
			</tr>
		</table>
<a href=${pageContext.request.contextPath}/movie/list  >Back to list</a>
	</form:form>
</body>
</html>
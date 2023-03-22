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
	<form action = "searchResults" method = "GET">
	Title: <input type = "text" name = "title">
	<input type="hidden" name="customerID" value="${customer.id }" />
	<input type = "submit" value = "Search" />
	</form>
</body>
</html>
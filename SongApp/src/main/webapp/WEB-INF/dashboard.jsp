<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Songs</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <div class="container">
   <p>Hello, ${thisLoggedInUser.userName}</p>
   	<h1>All songs lab</h1>
   	<a href="/logout">Log out</a>
   	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">#ID</th>
				<th scope="col">Title</th>
				<th scope="col">Genre</th>
				<th scope="col"> collaborations</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="song" items="${allDaSongs}">
				<tr>
					<td scope="row"><c:out value="${song.id }" /></td>
					<td><a href="/songs/${song.id }"><c:out
								value="${song.title}" /></a></td>
					<td><c:out value="${song.genre }" /></td>
					<td>${song.collabs.size()}</td>
					
					
				
				</tr>
			</c:forEach>

		</tbody>
	</table>
   	<a href="/songs/new" class="btn btn-outline-primary" >new song</a>
   
   
   
   
   
   
   
   </div>
</body>
</html>


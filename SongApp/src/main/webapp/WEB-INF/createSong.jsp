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
    <title>Create</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <div class="container" class="form-group">
	<h1>New Song</h1>
	<form:form action="/songs" method="post" modelAttribute="song">
		<form:errors style="color: red" path = "*"/>
		<form:hidden path="creator" value="${thisUser.id}"/>
		
		<p>
			<form:label path="title">title:</form:label>
			<form:input path="title" class="form-control"/>
		</p>
		<p>
			<form:label path="genre">Genre:</form:label>
			<form:input path="genre" class="form-control"/>
		</p>
		<p>
			<form:label path="lyrics">lyrics:</form:label>
			<form:textarea path="lyrics" class="form-control" />
		</p>
		<input type="submit" value="Submit" class="btn btn-outline-success"/>
	</form:form>
	</div>
</body>
</html>


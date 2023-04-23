<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">
	<h1>New Book</h1>
	<%-- ${ allLibs} --%>
	<p>user id = ${user_id}</p>
	<form:form action="/books" method="post" modelAttribute="book">
		<form:errors style="color: red" path = "*"/>
		<!-- ****************************** -->
		<!-- this is the hidden input way of doing this same thing easy way-->
		<%-- <form:input type="hidden" path="author" value = "${user_id }"/> --%>
		
		<p>
			<form:label path="title">Title</form:label>
			<%-- <form:errors path="title" /> --%>
			<form:input path="title" />
		</p>
		<%-- <p>
			<form:label path="author">Author</form:label>
			<form:errors path="author" />
			<form:textarea path="author" />
		</p> --%>
		
		<p>
			<form:label path="pages">Pages</form:label>
			<%-- <form:errors path="pages" /> --%>
			<form:input type="number" path="pages" />
		</p>
		<p>
			<form:select path="library">
				<c:forEach items="${allLibs}" var="lib">
					<form:option value="${lib.id }">
			<!-- l is the object that holds id key so this also works -->
					<%-- <form:option value = ${l } --%>
						${lib.getName() }
					</form:option>
				</c:forEach>
			</form:select>
		</p>
		<!-- cool? :<input type="text" name = "cool" /><br /> -->
		<input type="submit" value="Submit" />
	</form:form>
</div>
</body>
</html>

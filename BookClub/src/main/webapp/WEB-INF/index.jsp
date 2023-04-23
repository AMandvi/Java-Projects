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
<title>Books</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<h1>
			Welcome,
			<c:out value="${thisUser.userName}" />
		</h1>
		<p>
		<a href="/logout">logout</a></p>
		<p>
		<a href="/books/new">add a book to my shelf</a>
		</p>
		<p>books from everyone's shelf</p>

		<table class="table">
			<thead>
				<tr>
					<td>id</td>
					<td>title</td>
					<td>author Name</td>
					<td>Posted By</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allDaBooks }" var="book">
					<tr>
						<td>${book.id }</td>
						<td>
						<a href="/books/${book.id }">
							${book.title}
						</a>
						</td>
						
						<td>${book.author }</td>
						<td>${book.user.userName }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>


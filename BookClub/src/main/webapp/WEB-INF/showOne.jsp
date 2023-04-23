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
<title>Show</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<h1>${thisBook.title }</h1>
		<p>
			<a href="/books">back to the shelves</a>
		</p>
		<p>${thisBook.user.userName}read${thisBook.title} by
			${thisBook.author }</p>
		<h3>${thisBook.user.userName} thoughts</h3>
		<p>${thisBook.myThoughts }</p>
		<c:if test="${thisBook.user.id.equals(thisUser.id)}">
			<button>
				<a href="/books/${thisBook.id}/edit">Edit</a>
			</button>
			<form action="/books/${thisBook.id}" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					type="submit" value="Delete">
			</form>
		</c:if>


	</div>
</body>
</html>


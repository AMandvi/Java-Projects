<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>le JAVA</title>
</head>
<body>
	<h1>hello books</h1>
	
	<%-- ${allDaBooks} --%>
	<form action="/books" method="post">
	<input name="title" placeholder = "title"/> <br />
	<input name="description" placeholder = "description"/> <br />
	<input name = "language" placeholder = "language"/> <br />
	<input name = "pages" placeholder = "pages"/> <br />
	<button>submit</button>
	</form>
	
	
	<c:forEach items = "${allDaBooks}" var= "b">
		<li>${b.title}</li>
	</c:forEach>
	
	
</body>
</html>
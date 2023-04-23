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
<title>ShowOne</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<h2>Expense Details:</h2> 
		<a href="/expenses">go back</a>

		<p>
			Expense Name:
			<c:out value="${thisExpense.name}" />
		</p>
		<p>
			Expense Description:
			<c:out value="${thisExpense.description}" />
		</p>
		<p>
			Vendor:
			<c:out value="${thisExpense.vendor}" />
		</p>
		<p>
			Amount Spent:
			<c:out value="${thisExpense.amount}" />
		</p>
		
		
	</div>
</body>
</html>


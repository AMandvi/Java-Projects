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
<title>Expenses</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">
	<h1>Save travels</h1>

	<table class="table">
		<thead >
			<tr>
				<td>Expense</td>
				<td>Vendor</td>
				<td>Amount</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allDaExpenses}" var="expense">
				<tr>
					<td>
					<a href="/expenses/${expense.id }">${expense.name}</a>
					</td>
					
					<td>${expense.vendor }</td>
					<td> $ ${expense.amount }</td>
					<td><a href="expenses/edit/${expense.id}">edit</a>
						<form action="/expenses/${expense.id}" method="post">
							<input type="hidden" name="_method" value="delete"> 
							<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>
</div>
<div class="container">
	<h2>Add an Expense</h2>
	<form:form action="/expenses" method="post" modelAttribute="expense" >
		<form:errors path="*" cssStyle="color:red" />
		<p>
			<form:label path="name">Expense Name:</form:label>
			<form:input path="name" />
		</p>
		<p>
			<form:label path="vendor">Vendor:</form:label>
			<form:input path="vendor" />
		</p>

		<p>
			<form:label path="amount">Amount</form:label>
			<form:input type="number" path="amount" />
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:textarea path="description" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</div>
</body>
</html>


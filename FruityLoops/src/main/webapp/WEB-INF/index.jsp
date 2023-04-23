<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>le JAVA</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<body>
	<h1>Fruit store</h1>
	<table class= "table">
		<tbody>
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
				
					<c:forEach items = "${fruitsArray}" var = "fruit">
						<tr>
							<td><c:out value="${fruit.getName()}"/></td>
							<td><c:out value="${fruit.getPrice()}"/></td>
						</tr>
					</c:forEach>
				
					
					
				
		</tbody>
	</table>
</body>
</html>
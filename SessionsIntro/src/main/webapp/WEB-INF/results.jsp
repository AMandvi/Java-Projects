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
	<h1> Results</h1>
	<hr />
	name: ${name} <br />
	powerLevel: ${powerLevel}
	<hr />
	<c:if test="${powerLevel gt 1000 }">
		<p>you are too powerful</p>
	</c:if>
	
</body>
</html>


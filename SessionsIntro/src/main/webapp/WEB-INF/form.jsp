<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>le JAVA</title>
</head>
<body>
	<h3>Create a Hero!!!</h3>
	<h5>${nameErr}</h5>
	<form action='/processForm' method='POST'>
		<label>name:</label> 
		<input  name='name'> <br />
		
		<label>powerLevel:</label>
		<input  name='powerLevel'> <br />
		<button>Submit</button>
	</form>


</body>
</html>
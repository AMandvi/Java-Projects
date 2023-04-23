<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>le JAVA</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<body>
	<div class="container">
		<h3>Send an Omikuji!</h3>
		<form action='/processForm' method='POST'>
			<label>Pick any number from 5 to 25:</label> <input
				class="form-control" type="number" name="randomNumber" min="5"
				max="25" /> <br /> <label>Enter the name of any city:</label> <input
				class="form-control" name='city'> <br /> <label>Enter
				the name of any real person:</label> <input class="form-control"
				name='person'> <br /> <label>Enter professional
				endeavor or hobby:</label> <input class="form-control" name='hobby'>
				<br /><label>Enter any type of living thing:</label> <input
				class="form-control" name='thing'> <br /> <label>Say
				something nice to someone:</label> <input class="form-control"
				name='niceTalk'> <br />
			<p>Send and show a friend</p>
			<button>Send</button>
		</form>
	</div>
</body>
</html>
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
	<h1>Hello VIEWS!!!</h1>
	<%-- <p>
		<!-- portal to java-land -->

		<c:out value="${test}" />   <!-- this is best practice -->
		${test }
	</p> --%>
	<hr />
	
	<c:forEach items="${arrayNames}" var = "person">
	
		<li><c:out value="${person}" /></li>
		<%-- <li>${person}</li> --%>
	
	</c:forEach>
	
	<hr />
	${arrayNames.size()}
	${arrayNames.get(0)}     <!-- //inside javascript -->
	 
	<br />
	${x.length()}          <!-- //string length -->
	<%-- <p>
		<c:out value="${x}" />
	</p> --%>

</body>
</html>
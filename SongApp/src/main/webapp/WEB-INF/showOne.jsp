<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <div class="container">
   <h1>${ thisSong.title}</h1>
   <h3>${ thisSong.creator.userName}</h3>
   <h4>Genre: ${ thisSong.genre}</h4>
   <p>Lyrics: ${ thisSong.lyrics}</p>
   
   <a href="/songs/${thisSong.id }/edit" class="btn btn-primary" role="button" >edit</a><hr />
   <h3>Collaborators:</h3>
   <ul>
   <c:forEach items="${thisSong.collabs}" var="collab">
   		<li>${collab.userName }</li>
   	</c:forEach>
   
   
   </ul>
   
   
   
   
   
   </div>
</body>
</html>


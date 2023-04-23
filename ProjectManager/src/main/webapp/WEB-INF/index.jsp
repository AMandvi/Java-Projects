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
<h1>${ thisUser.userName }</h1>
 
 All projects
 <table class="table">
			<thead class="table-active">
				<tr>
					<td scope="col">Project</td>
					<td>Team Lead</td>
					<td>Due date</td>
					<td>Actions</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allProjects }" var="project">
				<c:if test="${project.usersThatBelongTo.contains(thisUser) eq false }">
					<tr>
						<td>${project.title }</td>
						<td><a href="/books/${book.id }"> ${book.title} </a></td>
						<%-- <td>${book.title}</td> --%>
						<td>${book.getAuthor().getUserName()}</td>
						<td>${book.pages }</td>
						<td><a href="/library/${book.library.id}">${book.library.name }</a>

						</td>
						<td>
						<c:if test="${project.usersThatBelongTo.contains(thisUser) eq false }">
						<a href="/addToReadList/${book.id }">add to read list</a>
						</c:if>
						<c:if test="${project.usersThatBelongTo.contains(thisUser) }">
						<a href="/removeFromReadList/${book.id }">REMOVE</a>
						</c:if>
						</td>
						<%-- <td>${book.getLibrary().getName()}</td> --%>
						<!-- only show the edit/ delete  -->
						<!-- if the logged in user is the user that created the book -->
						<c:if test="${user_id eq book.author.id }">
							<td><a href="/edit/${book.id}">edit</a> |
								<form action="/books/${book.id}" method="post">
									<input type="hidden" name="_method" value="delete"> <input
										type="submit" value="Delete">
								</form>
							</td>
						</c:if>
						

					</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
		
		 <table class="table">
			<thead class="table-active">
				<tr>
					<td scope="col">Project</td>
					<td>Team Lead</td>
					<td>Due date</td>
					<td>Actions</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allProjects }" var="project">
				<c:if test="${project.usersThatBelongTo.contains(thisUser) }">
					<tr>
						<td>${project.title }</td>
						<td><a href="/books/${book.id }"> ${book.title} </a></td>
						<%-- <td>${book.title}</td> --%>
						<td>${book.getAuthor().getUserName()}</td>
						<td>${book.pages }</td>
						<td><a href="/library/${book.library.id}">${book.library.name }</a>

						</td>
						<td>
						<c:if test="${project.usersThatBelongTo.contains(thisUser) eq false }">
						<a href="/addToReadList/${book.id }">add to read list</a>
						</c:if>
						<c:if test="${project.usersThatBelongTo.contains(thisUser) }">
						<a href="/removeFromReadList/${book.id }">REMOVE</a>
						</c:if>
						</td>
						<%-- <td>${book.getLibrary().getName()}</td> --%>
						<!-- only show the edit/ delete  -->
						<!-- if the logged in user is the user that created the book -->
						<c:if test="${user_id eq book.author.id }">
							<td><a href="/edit/${book.id}">edit</a> |
								<form action="/books/${book.id}" method="post">
									<input type="hidden" name="_method" value="delete"> <input
										type="submit" value="Delete">
								</form>
							</td>
						</c:if>
						

					</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
 
 <table>
 </table>
</body>
</html>


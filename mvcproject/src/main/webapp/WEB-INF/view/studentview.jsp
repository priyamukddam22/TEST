<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<center>
		<h2>Student List</h2>
	</center>
	<span class="alert alert-into">${msg}</span>
	<span class="alert alert-into">${msg1}</span>
	<table class="table table-hover" style="border: ex;">
		<tr style="background-color: olive;">
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Phone</th>
			<th>Gender</th>
			<th>City</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="student" items="${studentlist}">
			<tr>
				<td>${student.id}</td>
				<td>${student.firstname}</td>
				<td>${student.lastname}</td>
				<td>${student.email}</td>
				<td>${student.password}</td>
				<td>${student.phone}</td>
				<td>${student.gender}</td>
				<td>${student.city}</td>
				
				<td><button class="btn btn-danger">
						<a href="edit/${student.id}">Edit</a>
					</button></td>
				<td><button class="btn btn-danger">
						<a href="delete/${student.id}">Delete</a>
					</button></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
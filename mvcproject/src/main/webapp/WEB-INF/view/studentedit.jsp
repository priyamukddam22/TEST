<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<center>
<h3>Update Student Form</h3></center>
<div class="container-fluid">
<div class="row">
	<div class="col col-lg-2">
	</div>
	<div class="col col-lg-8">
	<form:form action="/mvcproject/update" method="post">
		<div class="form-group">
			<label>First Name</label>
			<form:input path="firstname" class="form-control"/>
		</div>
		<div class="form-group">
			<label>last Name</label>
			<form:input path="lastname" class="form-control"/>
		</div>
		<div class="form-group">
			<label>Email</label>
			<form:input path="email" class="form-control"/>
		</div>
		<div class="form-group">
			<label>Password</label>
			<form:input path="password" class="form-control"/>
		</div>
		<div class="form-group">
			<label>Phone</label>
			<form:input path="phone" class="form-control"/>
		</div>
		<div class=form-group">
			<label>Gender</label>
		</div>
		<div class="form-check">
			<form:radiobutton class="form-check-input" value="male" path="gender"/>&nbsp;&nbsp;&nbsp;<label>Male </label><br>
			<form:radiobutton class="form-check-input" value="female" path="gender"/>&nbsp;&nbsp;&nbsp;<label>Female</label>
		</div>
		<div class="form-group">
				<label>Select City</label>
				<form:select path="city" class="form-control">
					<form:option value="Nagpur">Nagpur</form:option>>
					<form:option value="Mumbai">Mumbai</form:option>
					<form:option value="Pune">Pune</form:option>
				</form:select>
			</div>	
		<div class="form-group">
			<button class="btn btn-primary" type="submit">Update</button>
		</div>
	</form:form>
	</div>
	<div class="col col-lg-2">
	</div>
</div>
	
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h3>Welcome to Login Form</h3>
	</center>
	${msg}
	<div class="container-fluid">
		<div class="row">
			<div class="col col-lg-3"></div>
			<div class="col col-lg-6">
				<form action="dologin" method="post">
					<div class="form-group">
						<label>User Name </label> <input type="text" name="username"
							class="form-control">
					</div>
					<div class="form-group">
						<label>Password </label> <input type="password" name="password"
							class="form-control">
					</div>
					<div class="form-group">
						<button class="btn btn-primary" type="submit">Login</button>
					</div>
				</form>

			</div>
			<div class="col col-lg-3"></div>
		</div>

	</div>
</body>
</html>
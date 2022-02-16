<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">


<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.errors {
	color: red;
	position: fixed;
	text-align: left;
}
</style>
</head>
<body>
<div align="center" class="container">

<h1>Login Page</h1>
					<form:form >

						<div class="form-group">
							<label>UserName</label>
							<input type="text" name="username" />
							
						</div>
						<div class="form-group">
							<label>Password</label>
							<input type="password" name="password" />
							
						</div>

						<input type="submit" value="Login" class="btn btn-primary btn-sm">
					</form:form>



	</div>
</body>
</html>
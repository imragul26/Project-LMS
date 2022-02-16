<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<%@include file="menu.jsp"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
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
	<div class="container">
		<h2>ADD Instructor</h2>
		<form:form action="saveData" modelAttribute="InstructorDto"
			method="post" style="width:23%">

			<div class="form-group mb-10">
				<label for="nameInput">Name</label>
				      <form:errors path="name" cssClass="errors" />
				<form:input path="name" type="Text" class="form-control"
					id="nameInput" placeholder="Enter name" /> 
			</div>

			<div class="form-group mb-10">
				<label for="nameInput">Training_Experience</label>
				      <form:errors path="training_exp" cssClass="errors" />				
				<form:input path="training_exp" type="Text" class="form-control"
					id="nameInput" placeholder="Enter experience" />
			</div>



			<div class="form-group mb-10">
				<label for="nameInput">Email</label>
				
				      <form:errors path="email" cssClass="errors" />		
				<form:input path="email" type="Text" class="form-control"
					id="nameInput" placeholder="Enter email" />
			</div>


			<input type="submit" value="Submit" class="btn btn-success">
		</form:form>

	</div>
</body>
</html>
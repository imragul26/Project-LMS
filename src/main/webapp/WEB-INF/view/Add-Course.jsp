<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.errors {
	color: red;
	position: fixed;
	text-align: left;
}</style>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
	
	<%@include file="menu.jsp"%>
</head>
<body>

 <div class="container">
	<h1>ADD Course</h1>

	<form:form action="Save-Course" method="Post" modelAttribute="Course"
		style="width:23%">



		<div class="form-group mb-10">
			<label for="nameInput">Course Name</label>
			<form:errors path="courseName" cssClass="errors" />
			<form:input path="courseName" type="Text" class="form-control"
				id="nameInput" />
		</div>


		<div class="form-group mb-10">
			<label for="nameInput">Course Duration</label>
			<form:errors path="courseDuration" cssClass="errors" />
			<form:input path="courseDuration" type="Text" class="form-control"
				id="nameInput" />
		</div>


		<div class="form-group mb-10">
			<label for="nameInput">Instructor Name</label>
			<form:select path="instructor.id" type="Text"
				id="nameInput" >

				<form:options items="${AllInstructors}" itemLabel="name"
					itemValue="id"  />

			</form:select>

		</div>
		
		<br>

		<input type="submit" value="Add Course" class="btn btn-success">


	</form:form>
</div>
</body>
</html>
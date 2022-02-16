<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<%@include file="menu.jsp" %>
 
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
</head>
<body>

<div class="container">
	<h1>Create Your New Lesson</h1>

	<form:form action="Save-lesson" method="POST" modelAttribute="lesson" style="width:23%">

<form:hidden path="course.id" />

           <div class="form-group mb-10">
			<label for="nameInput">Lesson Name</label>
			<form:errors path="lessonName" cssClass="errors" />
			<form:input path="lessonName" type="Text" class="form-control"
				id="nameInput" placeholder="Enter Lesson Name" />
		</div>


		<div class="form-group mb-10">
			<label for="nameInput">Lesson Text</label>
			<form:errors path="lessonText" cssClass="errors" />
			<form:input path="lessonText" type="Text" class="form-control"
				id="nameInput" placeholder="Enter Text" />
		</div>

		<div class="form-group mb-10">
			<label for="nameInput">Lesson Link</label>
			<form:errors path="link" cssClass="errors" />
			<form:input path="link" type="Text" class="form-control"
				id="nameInput" placeholder="Enter link"/>
		</div>

		<input type="submit" value="Add lesson" class="btn btn-success">


	</form:form>
</div>
</body>
</html>
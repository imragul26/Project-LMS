<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <%@include file="menu.jsp" %>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body >



<h1>Available Instructors</h1>

<div align="center">
<a href="http://localhost:8081/demo/home" class="btn btn-danger">Refresh</a>
</div>
	<div align="center">
		<form:form action="search-id" modelAttribute="SearchDto" method="post">

			<label>Search :</label>
			<form:input path="id" />
			<br>
			<input type="submit" value="Search">
		</form:form>
	</div>

	<table class="table table-striped">

		<thead class="table-primary">
			<tr>
		  <th>Instructor Id</th>
		  <th>Instructor Name</th>
		  <th>Instructor Teaching Exp</th>
		  <th>Instructor Email</th>
		  <th>courses</th>
			</tr>
		</thead>
		
		
	<tbody>
		<c:forEach var="inst" items="${instructor}">
			<tr>
				<td>${inst.id}</td>
				<td>${inst.name}</td>
				<td>${inst.training_exp}</td>
				<td>${inst.email}</td>    <!-- //{inst.courses} -->                                       
				<td>
				
				 <table class="table">
					   <thead class="table-warning">
					     <tr>
					       <td>name</td>
					       <td>duration</td>
					     </tr>
					   </thead>
					   
					    <tbody>
					   
					     <c:forEach var="course" items="${inst.courses}">
					      <tr>
					        <td>${course.courseName}</td>
					        <td>${course.courseDuration}</td>
					        <td><a href="http://localhost:8081/demo/ViewCourse?id=${course.id}" class="btn btn-primary btn-sm">view</a></td>
					      </tr>
					     
					     </c:forEach>
					   
					   </tbody>
					 
					 </table>
				
				
				
				</td>
				<td><a href="http://localhost:8081/demo/delete-instructor?id=${inst.id}" class="btn btn-danger">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
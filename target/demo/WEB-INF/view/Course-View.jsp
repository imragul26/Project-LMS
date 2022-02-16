<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
 <%@include file="menu.jsp" %>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Course Name: ${CoursPage.courseName}
	<a href="http://localhost:8081/demo/add-lesson?courseId=${CoursPage.id}"class="btn btn-warning"> Add Lesson</a>
	</h1> 
	<hr>
	<h1>Topics</h1>
	
	<c:forEach var="lessonss" items="${CoursPage.lessons}"> 
	
<h2>		 <a href="http://localhost:8081/demo/openLesson?id=${lessonss.lessonid}" class="link-primary">${lessonss.lessonName}</a></h2>
		 <br>
	
	</c:forEach>
	


</body>
</html>
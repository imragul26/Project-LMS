<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
</head>
<body>
	<%-- <%
	Lesson l= (Lesson)request.getAttribute("syllabus");
	int nextLessonId = l.getLessonId() + 1;
	pageContext.setAttribute("nextLessonId", nextLessonId);

	int prevLessonId = l.getLessonId() - 1;
	pageContext.setAttribute("prevLessonId", prevLessonId);
	%>

 --%>

	<div class="container">
		<h1>${syllabus.lessonName}</h1>

		<hr>
		<h2>${syllabus.lessonText}</h2>
		<div align="center">
			<h2>${syllabus.link}</h2>
		</div>

		<!-- next-video -->
		<c:if test="${nextLessonId <= lessonDtoCount.lastLessonNumber}">
			<div align="right">
				<a href="http://localhost:8081/demo/openLesson?id=${nextLessonId}">next
					video</a>
			</div>
		</c:if>

		<!-- previous-video -->

		<c:if test="${prevLessonId >= lessonDtoCount.firstLessonNumber}">
			<div align="left">
				<a href="http://localhost:8081/demo/openLesson?id=${prevLessonId}">previous
					video</a>
			</div>
		</c:if>


	</div>



</body>
</html>
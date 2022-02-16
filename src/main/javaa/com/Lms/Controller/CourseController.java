package com.Lms.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Lms.DTO.LessonDtoCount;
import com.Lms.Entity.Course;
import com.Lms.Entity.Instructor;
import com.Lms.Entity.Lesson;
import com.Lms.ServiceLayer.CourseService;
import com.Lms.ServiceLayer.InstructorService;

@SessionAttributes("lessonDtoCount")
@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;

	@Autowired
	private InstructorService instructor;

	@GetMapping("/ViewCourse")
	public String CoursPage(@RequestParam("id") int courseId, Model model) {

		Course fetchCourse = courseService.fetchCourse(courseId);
		model.addAttribute("CoursPage", fetchCourse);

		LessonDtoCount lessonDtoCount = new LessonDtoCount();
		if (!fetchCourse.getLessons().isEmpty()) {

			int firstLessonNumber = fetchCourse.getLessons().get(0).getLessonid();
			int lastLessonNumber = (firstLessonNumber + fetchCourse.getLessons().size()) - 1;

			lessonDtoCount.setFirstLessonNumber(firstLessonNumber);
			lessonDtoCount.setLastLessonNumber(lastLessonNumber);
		}
		model.addAttribute("lessonDtoCount", lessonDtoCount);

		return "Course-View";

	}

	@GetMapping("/add-course")
	public String addCourcePage(Model model) {

		Course course = new Course();
		model.addAttribute("Course", course);

		List<Instructor> fetchAllInstructor = instructor.fetchAllInstructor();
		model.addAttribute("AllInstructors", fetchAllInstructor);

		return "Add-Course";
	}

	@PostMapping("/Save-Course")
	public String saveCourcePage(@Valid @ModelAttribute("Course") Course course, BindingResult result, Model model) {

		if (result.hasErrors()) {

			List<Instructor> fetchAllInstructor = instructor.fetchAllInstructor();
			model.addAttribute("AllInstructors", fetchAllInstructor);
			return "Add-Course";
		}
		System.out.println(course + " inside save");

		int newCourseId = instructor.saveCourse(course);

		return "redirect:/ViewCourse?id=" + newCourseId;
	}

	@GetMapping("/add-lesson")
	public String addLessonPage(@RequestParam("courseId") Integer courseId,
			@RequestParam(value = "lessonId", required = false) Integer lessonId, Model model) {

		Lesson lessonValue = new Lesson();
		if (lessonId == null) {
			Course course = courseService.fetchCourse(courseId);

			lessonValue.setCourse(course);
		} else {

			lessonValue = courseService.findLessonById(lessonId);
		}
		model.addAttribute("lesson", lessonValue);

		return "Add-Lesson";
	}

	@PostMapping("/Save-lesson")
	public String saveLessonPage(@Valid @ModelAttribute("lesson") Lesson lesson, BindingResult result) {

		if (result.hasErrors()) {
			return "Add-Lesson";
		}

		courseService.saveLesson(lesson);

		return "redirect:/ViewCourse?id=" + lesson.getCourse().getId();
	}

	@GetMapping("/openLesson")
	public String CoursPafindLessonByIdge(@RequestParam("id") int lessonId, Model model) {

		Lesson lessons = courseService.findLessonById(lessonId);

		System.out.println(lessons);

		model.addAttribute("syllabus", lessons);

		int nextLessonId = lessons.getLessonid() + 1;
		int prevLessonId = lessons.getLessonid() - 1;

		model.addAttribute("nextLessonId", nextLessonId);
		model.addAttribute("prevLessonId", prevLessonId);

		return "Lesson-View";
	}

}

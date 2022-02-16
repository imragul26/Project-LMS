package com.Lms.ServiceLayer;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lms.DAO.CourseDao;
import com.Lms.Entity.Course;
import com.Lms.Entity.Lesson;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Transactional
	@Override
	public Course fetchCourse(int id) {
		
		Course fetchCourse = courseDao.fetchCourse(id);
		
		Hibernate.initialize(fetchCourse.getLessons());
		return fetchCourse;
	}
	
	@Transactional
	@Override
	public Lesson findLessonById(int id) {

		Lesson lesson = courseDao.findLessonById(id);
		return lesson;
	}
	
	@Transactional
	@Override
	public void saveLesson(Lesson lesson) {
		courseDao.saveLesson(lesson);		
	}
	
	
	

}

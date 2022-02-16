package com.Lms.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Lms.Entity.Course;
import com.Lms.Entity.Lesson;

@Repository
public class CourseDaoImpl implements CourseDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Course fetchCourse(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Course course = session.get(Course.class, id);
		
		return course;
	}

	
	@Override
	public Lesson findLessonById(int id) {

		Session session = sessionFactory.getCurrentSession();

		Lesson lesson = session.get(Lesson.class, id);
		
		return lesson;
	}
	
	@Override
	public void saveLesson(Lesson lesson) {
		Session session = sessionFactory.getCurrentSession();		
	
	     session.save(lesson);
	
	}
}

package com.Lms.DAO;

import com.Lms.Entity.Course;
import com.Lms.Entity.Lesson;

public interface CourseDao {

	
	
	public Course fetchCourse(int id);

	public Lesson findLessonById(int id);

	public void saveLesson(Lesson lesson);	

}

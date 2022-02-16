package com.Lms.DAO;

import java.util.List;

import com.Lms.Entity.Course;
import com.Lms.Entity.Instructor;

public interface InstructorDao {

	
	public List<Instructor> fetchAllInstructor();
	
	public void saveInstructor(Instructor instructor);

	public Instructor searchInstructor(int id);

	public void deleteInstructorById(int id);

	public int saveCourse(Course course);
	
}

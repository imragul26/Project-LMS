package com.Lms.ServiceLayer;

import java.util.List;

import com.Lms.Entity.Course;
import com.Lms.Entity.Instructor;

public interface InstructorService {

	
	List<Instructor> fetchAllInstructor();

	public void saveInstructor(Instructor instructor);

	public Instructor searchInstructor(int id);

	void deleteInstructorById(int id);

	int saveCourse(Course course);
}

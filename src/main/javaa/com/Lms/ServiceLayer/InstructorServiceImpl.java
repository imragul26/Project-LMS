package com.Lms.ServiceLayer;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lms.DAO.InstructorDao;
import com.Lms.Entity.Course;
import com.Lms.Entity.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorDao instructorDao;

	@Transactional
	@Override
	public List<Instructor> fetchAllInstructor() {

		List<Instructor> fetchAllInstructor = instructorDao.fetchAllInstructor();
		
		for(Instructor instructor :fetchAllInstructor) {
			instructor.setName(instructor.getName().toUpperCase());
			Hibernate.initialize(instructor.getCourses());
		}
		return fetchAllInstructor;
	}

	@Transactional
	@Override
	public void saveInstructor(Instructor instructor) {
		
		instructorDao.saveInstructor(instructor);
		
		
	}

	@Transactional
	@Override
	public Instructor searchInstructor(int id) {
		
		Instructor instructor = instructorDao.searchInstructor(id);
		
		Hibernate.initialize(instructor.getCourses());
		return instructor;
	}
	
	@Transactional
	@Override
	public void deleteInstructorById(int id) {

		instructorDao.deleteInstructorById(id);
		
		
	}
	@Transactional
	@Override
	public int saveCourse(Course course) {
		int saveCourse = instructorDao.saveCourse(course);
		return saveCourse;
	}
}

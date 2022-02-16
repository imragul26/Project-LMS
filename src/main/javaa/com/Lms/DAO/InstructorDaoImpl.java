package com.Lms.DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Lms.Entity.Course;
import com.Lms.Entity.Instructor;

@Repository
public class InstructorDaoImpl implements InstructorDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Instructor> fetchAllInstructor() {

		Session session = sessionFactory.getCurrentSession();


		Query<Instructor> query = session.createQuery("from Instructor", Instructor.class);
		List<Instructor> instructorList = query.list();


		return instructorList;
	}

	@Override
	public void saveInstructor(Instructor instructor) {

		Session session = sessionFactory.getCurrentSession();

		Serializable save = session.save(instructor);
		System.out.println("Saved  " + save);
	}
	
	@Override
	public Instructor searchInstructor(int id) {
  
		Session session = sessionFactory.getCurrentSession();
		
		Instructor instructor = session.get(Instructor.class, id);
		
		return instructor;
	}
	
	@Override
	public void deleteInstructorById(int id) {

		Session session = sessionFactory.getCurrentSession();
		  
		Instructor instructor = session.get(Instructor.class, id); 
		
		session.delete(instructor);
		
		
	}

	@Override
	public int saveCourse(Course course) {

		Session session = sessionFactory.getCurrentSession();
		
		Serializable save = session.save(course);
		
		return (Integer)save;
	}

}
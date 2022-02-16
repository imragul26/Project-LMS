 package com.Lms.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instructor_id")
	private int id;

	@NotBlank(message = "    * Enter name")
	@Column(name = "instructor_name")
	private String name;

	
	
	@Column(name = "instructor_training_exp")
	private int training_exp;

	@NotBlank(message = "    * Enter email")
	@Column(name = "instructor_email")
	private String email;

	@OneToMany(mappedBy="instructor",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Course> courses;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTraining_exp() {
		return training_exp;
	}

	public void setTraining_exp(int training_exp) {
		this.training_exp = training_exp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", training_exp=" + training_exp + ", email=" + email
				+ ", courses=" + courses + "]";
	}

	
}

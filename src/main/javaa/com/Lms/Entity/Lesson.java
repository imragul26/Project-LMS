package com.Lms.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "lessons")
public class Lesson {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lesson_id")
	private int lessonid;

	@NotBlank(message = "    * Enter lesson Text")
	@Column(name = "lesson_text")
	private String lessonText;

	@NotBlank(message = "    * Enter lesson Link")
	@Column(name = "link")
	private String link;

	@NotBlank(message = "    * Enter lesson Name")
	@Column(name = "lesson_name")
	private String lessonName;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	public final int getLessonid() {
		return lessonid;
	}

	public final void setLessonid(int lessonid) {
		this.lessonid = lessonid;
	}

	public final String getLessonText() {
		return lessonText;
	}

	public final void setLessonText(String lessonText) {
		this.lessonText = lessonText;
	}

	@Override
	public String toString() {
		return "Lesson [lessonid=" + lessonid + ", lessonText=" + lessonText + ", link=" + link + ", lessonName="
				+ lessonName + ", course=" + course + "]";
	}

	public final String getLink() {
		return link;
	}

	public final void setLink(String link) {
		this.link = link;
	}

	public final String getLessonName() {
		return lessonName;
	}

	public final void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public final Course getCourse() {
		return course;
	}

	public final void setCourse(Course course) {
		this.course = course;
	}

}

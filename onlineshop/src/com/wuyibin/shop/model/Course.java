package com.wuyibin.shop.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private int id;
	private Integer cnumber;
	private String name;
	private Integer lessonhours;
	private Integer lessonpoints;
	private Set<Student> students = new HashSet(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	/** full constructor */
	public Course(Integer cnumber, String name, Integer lessonhours,
			Integer lessonpoints, Set students) {
		this.cnumber = cnumber;
		this.name = name;
		this.lessonhours = lessonhours;
		this.lessonpoints = lessonpoints;
		this.students = students;
	}

	// Property accessors



	public Integer getCnumber() {
		return this.cnumber;
	}

	public void setCnumber(Integer cnumber) {
		this.cnumber = cnumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLessonhours() {
		return this.lessonhours;
	}

	public void setLessonhours(Integer lessonhours) {
		this.lessonhours = lessonhours;
	}

	public Integer getLessonpoints() {
		return this.lessonpoints;
	}

	public void setLessonpoints(Integer lessonpoints) {
		this.lessonpoints = lessonpoints;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "course: name="+this.name;
	}

}
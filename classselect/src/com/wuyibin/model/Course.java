package com.wuyibin.model;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private  int id;
	private int cnumber;
	private String name;
	private int lessonhours;
	private int lessonpoints;
	private Set<Student> students = new HashSet<Student>();
	
	public Course() {
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCnumber() {
		return cnumber;
	}
	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLessonhours() {
		return lessonhours;
	}
	public void setLessonhours(int lessonhours) {
		this.lessonhours = lessonhours;
	}
	public int getLessonpoints() {
		return lessonpoints;
	}
	public void setLessonpoints(int lessonpoints) {
		this.lessonpoints = lessonpoints;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "course="+this.cnumber+","+this.name+","+this.lessonhours+"."+this.lessonpoints;
	}

	
	
}

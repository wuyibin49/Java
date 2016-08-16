package com.wuyibin.shop.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private int id;
	private Integer snumber;
	private String name;
	private String password;
	private Integer age;
	private Timestamp birthday;
	private Set<Course> courses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(Integer snumber, String name, String password, Integer age,
			Timestamp birthday, Set courses) {
		this.snumber = snumber;
		this.name = name;
		this.password = password;
		this.age = age;
		this.birthday = birthday;
		this.courses = courses;
	}

	// Property accessors



	public Integer getSnumber() {
		return this.snumber;
	}

	public void setSnumber(Integer snumber) {
		this.snumber = snumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}



	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "student: name="+this.name+"£¬id="+this.id+"£¬course="+this.courses;
	}

}
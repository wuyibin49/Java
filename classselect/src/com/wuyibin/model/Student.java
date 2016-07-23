package com.wuyibin.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class Student {
	private int id;
	private int snumber;
	private String name;
	private String password;
	private int age;
	private Date birthday;
	private Set<Course> courses = new HashSet<Course>();
	
	public Student() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSnumber() {
		return snumber;
	}
	public void setSnumber(int snumber) {
		this.snumber = snumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "student: name="+this.name+",password="+this.password+"submber="+this.snumber+",age="+this.age+"courses="+this.courses;
	}
	
}

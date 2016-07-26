package com.wuyibin.shop.dao;

import com.wuyibin.shop.model.Course;
import com.wuyibin.shop.model.Student;



public interface StudentDao {
	public Student findstudent(Student student);
	//public void register(Student student);
	public void addcourse(Student student);
	public void deletecourse(Course course);
	//public void listcourse();
	
	
}

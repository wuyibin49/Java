package com.wuyibin.dao;

import com.wuyibin.model.Course;
import com.wuyibin.model.Student;

public interface StudentDao {
	public Object checkstudent(Student student);
	public void register(Student student);
	public void selectcourse(Student student);
	public void deletecourse(Course course);
	public void listcourse();
	
	
}

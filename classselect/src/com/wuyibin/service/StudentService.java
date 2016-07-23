package com.wuyibin.service;

import java.util.List;

import com.wuyibin.model.Student;

public interface StudentService {
	public Object checkstudent(Student student);
	public void register(Student student);
	public void selectcourse(Student student);
	

}

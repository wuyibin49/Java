package com.wuyibin.shop.service;

import java.io.Serializable;
import java.util.List;

import com.wuyibin.shop.model.Admin;
import com.wuyibin.shop.model.Course;
import com.wuyibin.shop.model.Student;



public interface AdminService {
	public Admin login(Admin admin);
	public List findstudents(int index,Class clazz);
	public void deletestudent(Student student);
	public void deletecourse(Course course,Serializable id);
	public List findallstudent(Class clazz);
	public Student findsinglestudent(Student student,Serializable id);
	public void updatestudent(Student student);
	public void addstudent(Student student);
}

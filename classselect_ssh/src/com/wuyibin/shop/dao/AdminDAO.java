package com.wuyibin.shop.dao;

import java.io.Serializable;
import java.util.List;

import com.wuyibin.shop.model.Admin;
import com.wuyibin.shop.model.Student;



public interface AdminDAO {
	public Admin login(Admin admin);
	public List<Student> findstudents(int index,Class clazz);
	public void deletestudent(Student student);
	public List<Student> findallstudent(Class clazz);
	public Student findsinglestudent(Student studnet,Serializable id);
	public void updatestudent(Student student);
	public void addstudent(Student student);
//	public Admin findadmin(Admin admin);
	
	
}

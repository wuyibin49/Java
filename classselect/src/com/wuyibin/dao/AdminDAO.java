package com.wuyibin.dao;

import java.util.List;

import com.wuyibin.model.Admin;
import com.wuyibin.model.Student;

public interface AdminDAO {
	public Admin login(Admin admin);
	public List allstudents(int index,Class clazz);
	public void deletestudent(Student student);
	public List listallstudent(Class clazz);
	
	
}

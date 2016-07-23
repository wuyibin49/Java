package com.wuyibin.service;

import java.util.List;

import com.wuyibin.model.Admin;
import com.wuyibin.model.Student;

public interface AdminService {
	public Admin login(Admin admin);
	public List allstudents(int index,Class clazz);
	public void deletestudent(Student student);
	public List listallstudent(Class clazz);
}

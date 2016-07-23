package com.wuyibin.service.impl;

import com.wuyibin.dao.StudentDao;
import com.wuyibin.dao.impl.StudentDaoimpl;
import com.wuyibin.model.Student;
import com.wuyibin.service.StudentService;

public class StudentServiceimpl implements StudentService {

	@Override
	public Object checkstudent(Student student) {
		Object stu=null;
		try {
			StudentDao daoManager = new StudentDaoimpl();
			stu  =daoManager.checkstudent(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}

	@Override
	public void register(Student student) {
		try {
			StudentDao sd=new StudentDaoimpl();
			sd.register(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void selectcourse(Student student) {
		StudentDao studentDao= new StudentDaoimpl();
		studentDao.selectcourse(student);
		
	}





}

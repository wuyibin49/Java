package com.wuyibin.shop.service.impl;

import com.wuyibin.shop.dao.StudentDao;
import com.wuyibin.shop.model.Student;
import com.wuyibin.shop.service.StudentService;

public class StudentServiceimpl implements StudentService {
	private StudentDao studentdao;
	
	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
	}
	@Override
	public Student findstudent(Student student) {
		Student stu=null;
		try {
			//StudentDao daoManager = new StudentDaoimpl();
			stu  =studentdao.findstudent(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}
	public StudentDao getStudentdao() {
		return studentdao;
	}
	@Override
	public void addcourse(Student student) {
		//StudentDao studentDao= new StudentDaoimpl();
		studentdao.addcourse(student);
		
	}

}

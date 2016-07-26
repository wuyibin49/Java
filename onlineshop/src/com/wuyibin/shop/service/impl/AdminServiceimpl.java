package com.wuyibin.shop.service.impl;

import java.io.Serializable;
import java.util.List;

import com.wuyibin.shop.dao.AdminDAO;
import com.wuyibin.shop.dao.CourseDAO;
import com.wuyibin.shop.model.Admin;
import com.wuyibin.shop.model.Course;
import com.wuyibin.shop.model.Student;
import com.wuyibin.shop.service.AdminService;


public class AdminServiceimpl implements AdminService {
	private AdminDAO admindao;
	private CourseDAO coursedao;
	
	public CourseDAO getCoursedao() {
		return coursedao;
	}

	public void setCoursedao(CourseDAO courserdao) {
		this.coursedao = courserdao;
	}

	public void setAdmindao(AdminDAO admindao) {
		this.admindao = admindao;
	}

	@Override
	public List findstudents(int index,Class clazz) {
		List<Student> students=null;	
		students=admindao.findstudents(index,clazz);
		return students;
	}

	@Override
	public void deletestudent(Student student) {
		//AdminDAO ad = new AdminDAOimpl();
		admindao.deletestudent(student);
		
	}

	@Override
	public List findallstudent(Class clazz) {
		List list=null;
		//AdminDAO ad=new AdminDAOimpl();
		list =admindao.findallstudent(clazz);
		return list;
	}

	@Override
	public Student findsinglestudent(Student student, Serializable id) {
		
		Student stu=admindao.findsinglestudent(student, id);
		return stu;
	}

	@Override
	public Admin login(Admin admin) {
		Admin ad=admindao.login(admin);
		return ad;
	}

	@Override
	public void updatestudent(Student student) {
		admindao.updatestudent(student);
		
	}

	public AdminDAO getAdmindao() {
		return admindao;
	}

	@Override
	public void deletecourse(Course course,Serializable id) {
		Course cou=new Course();
		cou=coursedao.findcourse(cou.getClass(),id);
		coursedao.deletecourse(cou);
	}

	@Override
	public void addstudent(Student student) {
		admindao.addstudent(student);
		
	}

}

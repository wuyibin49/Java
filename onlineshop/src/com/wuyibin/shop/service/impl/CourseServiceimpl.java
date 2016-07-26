package com.wuyibin.shop.service.impl;

import java.io.Serializable;
import java.util.List;

import com.wuyibin.shop.dao.CourseDAO;
import com.wuyibin.shop.model.Course;
import com.wuyibin.shop.service.CourseService;


public class CourseServiceimpl implements CourseService {
	private CourseDAO coursedao;


	public void setCoursedao(CourseDAO coursedao) {
		this.coursedao = coursedao;
	}

	@Override
	public void addcourse(Course course) {
	//CourseDAO courseDAO = new CourseDAOimpl();
		coursedao.addcourse(course);
		
	}

	@Override
	public Course findcourse(Course course, Serializable id) {
		//CourseDAO courseDAO = new CourseDAOimpl();
		 return (Course)coursedao.findcourse(course.getClass(), id);
	}

	@Override
	public void deletecourse(Course course) {
		//CourseDAO cd=new CourseDAOimpl();
		coursedao.deletecourse(course);
		
	}

	@Override
	public void updatecourse(Course course) {
	//	CourseDAO  courseDAO=new CourseDAOimpl();
		coursedao.updatecourse(course);
		
	}

	@Override
	public List<Course> searchcourse(int index,Course course) {
	//	 list =null;
	//	CourseDAO cd=new CourseDAOimpl();
		 List<Course>  list =coursedao.searchcourse(index,course);
		return list;
	}

	@Override
	public List<Course> findallcourse(Course course) {
	//	CourseDAO cd=new CourseDAOimpl();
		List<Course> list = coursedao.findallcourse(course);
		return list;
	}

}

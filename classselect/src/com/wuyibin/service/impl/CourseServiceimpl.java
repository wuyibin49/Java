package com.wuyibin.service.impl;

import java.io.Serializable;
import java.util.List;

import com.wuyibin.dao.CourseDAO;
import com.wuyibin.dao.impl.CourseDAOimpl;
import com.wuyibin.model.Course;
import com.wuyibin.service.CourseService;


public class CourseServiceimpl implements CourseService {

	@Override
	public List<Object> listcourse(int index,Class clazz) {
		List<Object> list = null;
		CourseDAO courseDAO = new CourseDAOimpl();
		list = courseDAO.listcourse(index,clazz);
		return list;
	}

	@Override
	public void addcourse(Course course) {
	CourseDAO courseDAO = new CourseDAOimpl();
	courseDAO.addcourse(course);
		
	}

	@Override
	public Course findcourse(Course course, Serializable id) {
		CourseDAO courseDAO = new CourseDAOimpl();
		 return (Course)courseDAO.findcourse(course.getClass(), id);
	}

	@Override
	public void deletecourse(Course course) {
		CourseDAO cd=new CourseDAOimpl();
		cd.deletecourse(course);
		
	}

	@Override
	public void updatecourse(Course course) {
		CourseDAO  courseDAO=new CourseDAOimpl();
		courseDAO.updatecourse(course);
		
	}

	@Override
	public List searchcourse(int index,Course course) {
		List  list =null;
		CourseDAO cd=new CourseDAOimpl();
		 list =cd.searchcourse(index,course);
		return list;
	}

	@Override
	public List listallcourse(Course course) {
		CourseDAO cd=new CourseDAOimpl();
		List list = cd.listallcourse(course);
		return list;
	}

}

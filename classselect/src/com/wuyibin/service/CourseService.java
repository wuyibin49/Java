package com.wuyibin.service;

import java.io.Serializable;
import java.util.List;

import com.wuyibin.model.Course;

public interface CourseService {
	public List<Object> listcourse(int index,Class clazz);
	public List listallcourse(Course course);
	public void addcourse(Course course);
	public 	Course findcourse(Course course,Serializable id);
	public void deletecourse(Course course);
	public void updatecourse(Course course);
	public List searchcourse(int index,Course course);
}

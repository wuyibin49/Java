package com.wuyibin.dao;

import java.io.Serializable;
import java.util.List;

import com.wuyibin.model.Course;

public interface CourseDAO {
	public List listcourse(int index,Class clazz);
	public void addcourse(Course course);
	public Course findcourse(Class clazz,Serializable id);
	public void deletecourse(Course course);
	public void updatecourse(Course course);
	public List searchcourse(int index,Course course);
	public List listallcourse(Course course);
	
}

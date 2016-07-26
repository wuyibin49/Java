package com.wuyibin.shop.dao;

import java.io.Serializable;
import java.util.List;

import com.wuyibin.shop.model.Course;



public interface CourseDAO {
	public List<Course> findcourse(int index,Class clazz);
	public void addcourse(Course course);
	public Course findcourse(Class clazz,Serializable id);
	public void deletecourse(Course course);
	public void updatecourse(Course course);
	public List<Course> searchcourse(int index,Course course);
	public List<Course> findallcourse(Course course);
	
}

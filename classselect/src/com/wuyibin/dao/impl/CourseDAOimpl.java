package com.wuyibin.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.mapping.Array;

import com.wuyibin.dao.CourseDAO;
import com.wuyibin.model.Course;
import com.wuyibin.util.Hibernateutil;

public class CourseDAOimpl implements CourseDAO {
/*
 * 分页查询所有课程
 * index-页码
 * @see com.wuyibin.dao.CourseDAO#listcourse(int, java.lang.Class)
 */
	@Override
	public List<Object> listcourse(int index,Class clazz) {
		String hql = "from Course";
		List<Object> list =  Hibernateutil.listall(index,clazz, hql);
		return list;
	}
/*
 * 添加课程
 * @see com.wuyibin.dao.CourseDAO#addcourse(com.wuyibin.model.Course)
 */
	@Override
	public void addcourse(Course course) {
		Hibernateutil.add(course);
	}
/*
 * 根据id查找课程
 */
	@Override
	public Course findcourse(Class clazz, Serializable id) {
		Course course=(Course)Hibernateutil.find(clazz, id);
		return course;
	}
/*
 * 删除课程
 * @see com.wuyibin.dao.CourseDAO#deletecourse(com.wuyibin.model.Course)
 */
	@Override
	public void deletecourse(Course course) {
		Hibernateutil.delete(course);
		
	}
/*
 * 更新课程
 * @see com.wuyibin.dao.CourseDAO#updatecourse(com.wuyibin.model.Course)
 */
	@Override
	public void updatecourse(Course course) {
		Hibernateutil.update(course);
		
	}
/*
 * 搜索课程
 * @see com.wuyibin.dao.CourseDAO#searchcourse(int, com.wuyibin.model.Course)
 */
	@Override
	public List searchcourse(int index,Course course) {
		List list = null;
		String s="from Course  c where c.name=? and c.cnumber=? and lessonpoints=? ";
		String hql="from Course c where ";
		if(course!=null){
			if(course.getName()!=null&&!" ".equals(course.getName())){
				hql=hql+"c.name like '%"+course.getName()+"%' ";
			}else{
				hql= hql+"c.name like '%%'";
			}
			if(course.getCnumber()!=0){
				hql=hql+" and c.cnumber like '%"+course.getCnumber()+"%' ";
			}else{
				hql=hql+" and c.cnumber like '%%'";
			}
			if(course.getLessonpoints()!=0){
				hql=hql+"  and c.lessonpoints like '%"+course.getLessonpoints()+"%'";
			}
		}		
		System.out.println("查询条件="+hql);
		list=Hibernateutil.listall(index,course.getClass(), hql);
		return list;
	}
/*
 * 查找所有课程
 * @see com.wuyibin.dao.CourseDAO#listallcourse(com.wuyibin.model.Course)
 */
	@Override
	public List listallcourse(Course course) {
//		String hql="from Course c where ";
//		if(course!=null){
//			if(course.getName()!=null&&!" ".equals(course.getName())){
//				hql=hql+"c.name like '%"+course.getName()+"%' ";
//			}else{
//				hql= hql+"c.name like '%%'";
//			}
//			if(course.getCnumber()!=0){
//				hql=hql+" and c.cnumber like '%"+course.getCnumber()+"%' ";
//			}else{
//				hql=hql+" and c.cnumber like '%%'";
//			}
//			if(course.getLessonpoints()!=0){
//				hql=hql+"  and c.lessonpoints like '%"+course.getLessonpoints()+"%'";
//			}
//		}		
		String hql="from Course";
		List list=Hibernateutil.listallobject(course.getClass(), hql);
		return list;
	}

}

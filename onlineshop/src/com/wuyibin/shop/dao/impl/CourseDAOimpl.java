package com.wuyibin.shop.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wuyibin.shop.dao.CourseDAO;
import com.wuyibin.shop.model.Course;


public class CourseDAOimpl extends HibernateDaoSupport implements CourseDAO {
	
	private static final int ONEPAGEITEM=5;
/*
 * 分页查询所有课程
 * index-页码
 * @see com.wuyibin.dao.CourseDAO#listcourse(int, java.lang.Class)
 */
	@Override
	public List<Course> findcourse(int index,Class clazz) {
		String hql = "from "+clazz;
		List<Course> list =  getSession().createQuery(hql).setFirstResult((index-1)*ONEPAGEITEM).setMaxResults(ONEPAGEITEM).list();
		return list;
	}
/*
 * 添加课程
 * @see com.wuyibin.dao.CourseDAO#addcourse(com.wuyibin.model.Course)
 */
	@Override
	public void addcourse(Course course) {
		getSession().save(course);
	}
/*
 * 根据id查找课程
 */
	@Override
	public Course findcourse(Class clazz, Serializable id) {
		System.out.println("查找一门课程");
		Course course=(Course)getSession().load(clazz, id);
		return course;
	}
/*
 * 删除课程
 * @see com.wuyibin.dao.CourseDAO#deletecourse(com.wuyibin.model.Course)
 */
	@Override
	public void deletecourse(Course course) {
		System.out.println("删除");
		getSession().delete(course);
		
	}
/*
 * 更新课程
 * @see com.wuyibin.dao.CourseDAO#updatecourse(com.wuyibin.model.Course)
 */
	@Override
	public void updatecourse(Course course) {
		System.out.println("更新");
		getSession().update(course);
		
	}
/*
 * 搜索课程
 * @see com.wuyibin.dao.CourseDAO#searchcourse(int, com.wuyibin.model.Course)
 */
	@Override
	public List searchcourse(int index,Course course) {
		System.out.println("搜索课程");
		List list = null;
		String s="from Course  c where c.name=? and c.cnumber=? and lessonpoints=? ";
	//	String hql="from "+course.getClass()+" c where 1=1 ";
		String hql="from Course c where 1=1 ";
		if(course!=null){
			if(course.getName()!=null&&!" ".equals(course.getName())){
				hql=hql+" and c.name like '%"+course.getName()+"%' ";
			}else{
				//hql= hql+"c.name like '%%'";
			}
			if(course.getCnumber()!=null){
				hql=hql+" and c.cnumber like '%"+course.getCnumber()+"%' ";
			}else{
				//hql=hql+" and c.cnumber like '%%'";
			}
			if(course.getLessonpoints()!=null){
				hql=hql+"  and c.lessonpoints like '%"+course.getLessonpoints()+"%'";
			}
		}		
		System.out.println("查询条件="+hql);
		list=getSession().createQuery(hql).setFirstResult((index-1)*ONEPAGEITEM).setMaxResults(ONEPAGEITEM).list();
		return list;
	}
/*
 * 查找所有课程
 * @see com.wuyibin.dao.CourseDAO#listallcourse(com.wuyibin.model.Course)
 */
	@Override
	public List<Course> findallcourse(Course course){
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
		List<Course> list=getSession().createQuery(hql).list();
		return list;
	}

}

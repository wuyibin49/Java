package com.wuyibin.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.mapping.Array;

import com.wuyibin.dao.CourseDAO;
import com.wuyibin.model.Course;
import com.wuyibin.util.Hibernateutil;

public class CourseDAOimpl implements CourseDAO {
/*
 * ��ҳ��ѯ���пγ�
 * index-ҳ��
 * @see com.wuyibin.dao.CourseDAO#listcourse(int, java.lang.Class)
 */
	@Override
	public List<Object> listcourse(int index,Class clazz) {
		String hql = "from Course";
		List<Object> list =  Hibernateutil.listall(index,clazz, hql);
		return list;
	}
/*
 * ��ӿγ�
 * @see com.wuyibin.dao.CourseDAO#addcourse(com.wuyibin.model.Course)
 */
	@Override
	public void addcourse(Course course) {
		Hibernateutil.add(course);
	}
/*
 * ����id���ҿγ�
 */
	@Override
	public Course findcourse(Class clazz, Serializable id) {
		Course course=(Course)Hibernateutil.find(clazz, id);
		return course;
	}
/*
 * ɾ���γ�
 * @see com.wuyibin.dao.CourseDAO#deletecourse(com.wuyibin.model.Course)
 */
	@Override
	public void deletecourse(Course course) {
		Hibernateutil.delete(course);
		
	}
/*
 * ���¿γ�
 * @see com.wuyibin.dao.CourseDAO#updatecourse(com.wuyibin.model.Course)
 */
	@Override
	public void updatecourse(Course course) {
		Hibernateutil.update(course);
		
	}
/*
 * �����γ�
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
		System.out.println("��ѯ����="+hql);
		list=Hibernateutil.listall(index,course.getClass(), hql);
		return list;
	}
/*
 * �������пγ�
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

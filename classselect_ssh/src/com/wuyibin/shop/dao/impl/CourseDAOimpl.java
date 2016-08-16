package com.wuyibin.shop.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wuyibin.shop.dao.CourseDAO;
import com.wuyibin.shop.model.Course;


public class CourseDAOimpl extends HibernateDaoSupport implements CourseDAO {
	
	private static final int ONEPAGEITEM=5;
/*
 * ��ҳ��ѯ���пγ�
 * index-ҳ��
 * @see com.wuyibin.dao.CourseDAO#listcourse(int, java.lang.Class)
 */
	@Override
	public List<Course> findcourse(int index,Class clazz) {
		String hql = "from "+clazz;
		List<Course> list =  getSession().createQuery(hql).setFirstResult((index-1)*ONEPAGEITEM).setMaxResults(ONEPAGEITEM).list();
		return list;
	}
/*
 * ��ӿγ�
 * @see com.wuyibin.dao.CourseDAO#addcourse(com.wuyibin.model.Course)
 */
	@Override
	public void addcourse(Course course) {
		getSession().save(course);
	}
/*
 * ����id���ҿγ�
 */
	@Override
	public Course findcourse(Class clazz, Serializable id) {
		System.out.println("����һ�ſγ�");
		Course course=(Course)getSession().load(clazz, id);
		return course;
	}
/*
 * ɾ���γ�
 * @see com.wuyibin.dao.CourseDAO#deletecourse(com.wuyibin.model.Course)
 */
	@Override
	public void deletecourse(Course course) {
		System.out.println("ɾ��");
		getSession().delete(course);
		
	}
/*
 * ���¿γ�
 * @see com.wuyibin.dao.CourseDAO#updatecourse(com.wuyibin.model.Course)
 */
	@Override
	public void updatecourse(Course course) {
		System.out.println("����");
		getSession().update(course);
		
	}
/*
 * �����γ�
 * @see com.wuyibin.dao.CourseDAO#searchcourse(int, com.wuyibin.model.Course)
 */
	@Override
	public List searchcourse(int index,Course course) {
		System.out.println("�����γ�");
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
		System.out.println("��ѯ����="+hql);
		list=getSession().createQuery(hql).setFirstResult((index-1)*ONEPAGEITEM).setMaxResults(ONEPAGEITEM).list();
		return list;
	}
/*
 * �������пγ�
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

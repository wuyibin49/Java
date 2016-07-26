package com.wuyibin.shop.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wuyibin.shop.dao.AdminDAO;
import com.wuyibin.shop.model.Admin;
import com.wuyibin.shop.model.Student;
public class AdminDAOimpl extends HibernateDaoSupport implements AdminDAO {
	private SessionFactory sessionfactory;
	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	private static final int ONEPAGEITEM=5;
	@Override
	public Admin login(Admin admin) {
		Admin ad=null;		
		String hql="from Admin a where a.name=? and a.password=?";
		System.out.println(hql);
		System.out.println("传过来的"+admin);		
		try {
			Query query=getSession().createQuery(hql);
			ad=(Admin)query.setString(0, admin.getName()).setString(1, admin.getPassword()).uniqueResult();
			System.out.println("查询出来的admin"+ad);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ad;		
	}
	@Override
	public void deletestudent(Student student) {
	getSession().delete(student);
		
	}
	@Override
	public List<Student> findstudents(int index, Class clazz) {
		String hql="from Student";
		List<Student> list=getSession().createQuery(hql).setMaxResults(ONEPAGEITEM).setFirstResult((index-1)*ONEPAGEITEM).list();
		return list;
	}
	@Override
	public List<Student> findallstudent(Class clazz) {
		String hql="from Student";
		List<Student> list=getSession().createQuery(hql).list();
		return list;
	}
	@Override
	public Student findsinglestudent(Student student, Serializable id) {
		Student stu=(Student)getSession().load(student.getClass(), id);
		return stu;
	}
	@Override
	public void updatestudent(Student student) {
		getSession().update(student);
		
	}
	@Override
	public void addstudent(Student student) {
		getSession().save(student);
		
	}



	

	

}

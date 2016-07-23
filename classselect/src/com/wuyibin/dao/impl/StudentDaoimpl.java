package com.wuyibin.dao.impl;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.wuyibin.dao.StudentDao;
import com.wuyibin.model.Course;
import com.wuyibin.model.Student;
import com.wuyibin.util.Hibernateutil;

public class StudentDaoimpl implements StudentDao {
	
	@Override
	public void selectcourse(Student student) {
		Hibernateutil.update(student);
		
		
	}
	@Override
	public Object checkstudent(Student student) {

		Session ss= Hibernateutil.opensession();
	String hql="from Student s where s.name=? and s.password=?";
	System.out.println("11111111131111111111111111");
	System.out.println("11111111"+student);
	try {
		Object obj = (Object)ss.createQuery(hql).setString(0, student.getName()).setString(1, student.getPassword()).uniqueResult();
		List list = ss.createQuery(hql).setString(0, student.getName()).setString(1, student.getPassword()).list();
		System.out.println("11111111111111111111111111");
		System.out.println(obj+"+"+list);
		return obj;
	} catch (HibernateException e) {
		
		System.out.println("chucuola=======================");
		e.printStackTrace();
		return null;
	}
	
	}
	@Override
	public void register(Student student) {
		Hibernateutil.add(student);
		
	}
	@Override
	public void deletecourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listcourse() {
		// TODO Auto-generated method stub
		
	}
//	Session session = Hibernateutil.opensession();
//	@Override
//	public void addstudent(Student student) {
//		
//		
//		Transaction tx= session.beginTransaction();
//	
//		try {
//			session.save(student);
//		} catch (HibernateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		tx.commit();
//		Hibernateutil.closesession(session);
//	}
//
//	@Override
//	public void updatestudent() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void deletestudent() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public List findstudent(Student student) {
//		List list = new ArrayList();
//		String hql="from Student s where s.name=? and s.password=?";
//		try {
//			Query query=session.createQuery(hql).setString(0,student.getName()).setString(1,student.getPassword());
//			
//			list= query.list();
//		} catch (HibernateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}


	

}

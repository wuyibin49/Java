package com.wuyibin.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hibernateutil {
	private static SessionFactory sessionfactory;
	
	public static SessionFactory getSessionfactory() {
		return sessionfactory;
	}
	public static void setSessionfactory(SessionFactory sessionfactory) {
		Hibernateutil.sessionfactory = sessionfactory;
	}
	static{
		try {
			sessionfactory=new  Configuration().configure().buildSessionFactory();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	//==============开启session===========
	public static Session opensession(){
		Session session = sessionfactory.openSession();
		return session;
	}	
	//===============关闭session================
	public static void closesession(Session session){
		if(session!=null)
			session.close();
	}	
	//=================查询==========================
	public static Object find(Class clazz ,Serializable id){
		Object obj=null;
		Session session= null;
		Transaction tx=null;
		try {
			session= Hibernateutil.opensession();
			tx=session.beginTransaction();
			obj=session.get(clazz, id);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			// TODO: handle exception
		}finally{
			Hibernateutil.closesession(session);
		}
		return obj;
	}
	//=================添加=========================
	public static void add(Object obj){
		System.out.println(obj);
		Session s= null;
		Transaction tx= null;
		try {
			s=Hibernateutil.opensession();
			tx= s.beginTransaction();
			s.save(obj);
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
		}finally{
			Hibernateutil.closesession(s);
		}
	}
	//============================删除=====================
public static void delete(Object obj){
	Session s = null;
	Transaction tx= null;
	try {
		s=Hibernateutil.opensession();
		tx=s.beginTransaction();
		s.delete(obj);
		tx.commit();
	} catch (Exception e) {
		// TODO: handle exception
		tx.rollback();
	}
	Hibernateutil.closesession(s);
}
//==============更新==================
	public static void update(Object clazz){
		Session s= null;
		Transaction tx= null;
		try {
			s=Hibernateutil.opensession();
			tx= s.beginTransaction();
			s.update(clazz);
			tx.commit();
		
		} catch (Exception e) {
			tx.rollback();
		}finally{
			Hibernateutil.closesession(s);
		}
	}	
	//====================查询所有========================
	public static List<Object> listallobject(Class clazz ,String hql){
		
		System.out.println("执行listall");
		System.out.println(hql);
		Session s = null;
		//Transaction tx= null;
		List<Object> list = null;		
		try {
			s=Hibernateutil.opensession();
			System.out.println("s:"+s);
			//tx=s.beginTransaction();			
			Query query=s.createQuery(hql);
			//System.out.println(list.size());			
			list = query.list();			
		//	tx.commit();			
			System.out.println("查询出来的：list"+list);
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			s.clear();			
			Hibernateutil.closesession(s);
		}
		System.out.println(list);
		return list;
	}
	//====================分页查询=======================
	public static List<Object> listall(int index,Class clazz ,String hql){
		final int ONEPAGEITEM=5;
		System.out.println("执行listall");
		System.out.println(hql);
		Session s = null;
		//Transaction tx= null;
		List<Object> list = null;		
		try {
			s=Hibernateutil.opensession();
			System.out.println("s:"+s);
			//tx=s.beginTransaction();			
			Query query=s.createQuery(hql).setFirstResult((index-1)*ONEPAGEITEM).setMaxResults(ONEPAGEITEM);
			//System.out.println(list.size());			
			list = query.list();			
		//	tx.commit();			
			System.out.println("查询出来的：list"+list);
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			s.clear();			
			Hibernateutil.closesession(s);
		}
		System.out.println(list);
		return list;
	}
		
}
	


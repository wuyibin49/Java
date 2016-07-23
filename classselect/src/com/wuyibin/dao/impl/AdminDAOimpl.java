package com.wuyibin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.wuyibin.dao.AdminDAO;
import com.wuyibin.model.Admin;
import com.wuyibin.model.Student;
import com.wuyibin.util.Hibernateutil;

public class AdminDAOimpl implements AdminDAO {

	@Override
	public Admin login(Admin admin) {
		Admin ad=null;
		Session s=null;
		
		String hql="from Admin a where a.name=? and a.password=?";
		System.out.println(hql);
		System.out.println("传过来的"+admin);
		try {
			s= Hibernateutil.opensession();
			
			Query query=s.createQuery(hql);
			ad=(Admin)query.setString(0, admin.getName()).setString(1, admin.getPassword()).uniqueResult();
			System.out.println("查询出来的admin"+ad);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ad;
		

	}

	@Override
	public List allstudents(int index,Class clazz) {
		List<Object> students=null;
		String hql="from Student";
		students=Hibernateutil.listall(index,clazz, hql);
		
		return students;
		
	}

	@Override
	public void deletestudent(Student student) {
	Hibernateutil.delete(student);
		
	}

	@Override
	public List listallstudent(Class clazz) {
		List list =null;
		String hql="from Student";
		list=Hibernateutil.listallobject(clazz, hql);
		return list;
	}

}

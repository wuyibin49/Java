package com.wuyibin.service.impl;

import java.util.List;

import com.wuyibin.dao.AdminDAO;
import com.wuyibin.dao.impl.AdminDAOimpl;
import com.wuyibin.model.Admin;
import com.wuyibin.model.Student;
import com.wuyibin.service.AdminService;

public class AdminServiceimpl implements AdminService {

	@Override
	public Admin login(Admin admin) {
		Admin ad=null;
		AdminDAO adminDAO=new AdminDAOimpl();
		 ad=adminDAO.login(admin);
		 return ad;
	}

	@Override
	public List allstudents(int index,Class clazz) {
		List<Object> students=null;
		AdminDAO ad=new AdminDAOimpl();
		students=ad.allstudents(index,clazz);
		return students;
	}

	@Override
	public void deletestudent(Student student) {
		AdminDAO ad = new AdminDAOimpl();
		ad.deletestudent(student);
		
	}

	@Override
	public List listallstudent(Class clazz) {
		List list=null;
		AdminDAO ad=new AdminDAOimpl();
		list =ad.listallstudent(clazz);
		return list;
	}

}

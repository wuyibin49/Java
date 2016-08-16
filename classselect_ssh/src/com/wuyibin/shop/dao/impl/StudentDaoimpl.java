package com.wuyibin.shop.dao.impl;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wuyibin.shop.dao.StudentDao;
import com.wuyibin.shop.model.Course;
import com.wuyibin.shop.model.Student;


public class StudentDaoimpl extends HibernateDaoSupport implements StudentDao {
	
	@Override
	public void addcourse(Student student) {
		System.out.println("更新学生信息");
		getSession().update(student);		
	}
	@Override
	public Student findstudent(Student student) {		
	String hql="from Student s where s.name=? and s.password=?";
	System.out.println("11111111131111111111111111");
	System.out.println("11111111"+student);
	Student stu = (Student)getSession().createQuery(hql).setString(0, student.getName()).setString(1, student.getPassword()).uniqueResult();
	return stu;	
	}

	@Override
	public void deletecourse(Course course) {
		getSession().delete(course);		
	}	
}

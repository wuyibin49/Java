package com.wuyibin.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.HttpContext;
import com.wuyibin.model.Student;
import com.wuyibin.service.StudentService;
import com.wuyibin.service.impl.StudentServiceimpl;

public class RegisterAction extends ActionSupport {
	private int id;
	private int snumber;
	private String name;
	private String password;
	private int age;
	private Date birthday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSnumber() {
		return snumber;
	}
	public void setSnumber(int snumber) {
		this.snumber = snumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String addstudent() throws Exception {
		System.out.println("新增学生");
		Student student=null;
		try {
			student = new Student();
			student.setSnumber(snumber);
			student.setName(name);
			student.setPassword(password);
			student.setAge(age);
			System.out.println(student);
			StudentService studentService = new StudentServiceimpl();
			studentService.register(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("student",student);
		return SUCCESS;
	
	}
	
	
}

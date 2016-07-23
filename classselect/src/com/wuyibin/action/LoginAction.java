package com.wuyibin.action;



import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wuyibin.model.Admin;
import com.wuyibin.model.Student;
import com.wuyibin.service.AdminService;
import com.wuyibin.service.StudentService;
import com.wuyibin.service.impl.AdminServiceimpl;
import com.wuyibin.service.impl.StudentServiceimpl;


public class LoginAction extends ActionSupport {
	private Student stu;
	private String type;
private String name;
private String password;
private final String normal="普通用户";
private final String adminer="管理员";

	public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
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

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("type="+type);
		System.out.println(type.equals(normal));
		if(type.equals(normal)){
			System.out.println("normal user login");
			Student stu = new Student();
			stu.setName(name);
			stu.setPassword(password);			
			StudentService studentService = new StudentServiceimpl();
			Student student = (Student)studentService.checkstudent(stu);
			System.out.println(stu.getName());
			System.out.println(stu.getPassword());
			System.out.println(student);		
			if(student!=null&&student.getName().equals(name)&&student.getPassword().equals(password)){
				ActionContext ac= ActionContext.getContext();
				ac.getSession().put("user", student);				
				return "studentlogin";
			}else{
				return INPUT;
			}
			
		}else if(type.equals(adminer)){
			System.out.println("admin login");
			Admin ad=new Admin();
			ad.setName(name);
			ad.setPassword(password);
			AdminService adminService=new AdminServiceimpl();
			Admin admin=adminService.login(ad);			
			if(admin!=null&&admin.getName().equals(name)&&admin.getPassword().equals(password)){
				ActionContext ac= ActionContext.getContext();
				ac.getSession().put("user", admin);
				return "adminlogin";
			}				
			else{				
				return INPUT;
			}			
		}else
			return "error";
	
	}

}

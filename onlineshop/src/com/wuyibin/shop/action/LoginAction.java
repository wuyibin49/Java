package com.wuyibin.shop.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wuyibin.shop.model.Admin;
import com.wuyibin.shop.model.Student;
import com.wuyibin.shop.service.AdminService;
import com.wuyibin.shop.service.StudentService;

public class LoginAction extends ActionSupport {

	private String name;
	private String password;
	private Student stu;
	private String type;
	private final String normal="普通用户";
	private final String adminer="管理员";
	private StudentService studentservice;
	private AdminService adminservice;

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
	
	public StudentService getStudentservice() {
		return studentservice;
	}

	public void setStudentservice(StudentService studentservice) {
		this.studentservice = studentservice;
	}

	public AdminService getAdminservice() {
		return adminservice;
	}

	public void setAdminservice(AdminService adminservice) {
		this.adminservice = adminservice;
	}

	public String getNormal() {
		return normal;
	}

	public String getAdminer() {
		return adminer;
	}

	public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}



	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}


	public String login() throws Exception{
		System.out.println("执行登录");
//		System.out.println("loginactino !!");
//		if(name!=null&&name!=""&&"admin".equals(name)&&password.equals("123")){
//			
//			return SUCCESS;
//		}
//		
//		return INPUT;
		
		System.out.println("type="+type);
		System.out.println(type.equals(normal));
		if(type.equals(normal)){
			System.out.println("normal user login");
			Student stu = new Student();
			stu.setName(name);
			stu.setPassword(password);			
		//	StudentService studentService = new StudentServiceimpl();
			Student student = (Student)studentservice.findstudent(stu);
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
		//	AdminService adminService=new AdminServiceimpl();
			Admin admin=adminservice.login(ad);			
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

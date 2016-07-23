package com.wuyibin.action;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wuyibin.model.Admin;
import com.wuyibin.model.Course;
import com.wuyibin.model.Student;
import com.wuyibin.service.AdminService;
import com.wuyibin.service.CourseService;
import com.wuyibin.service.impl.AdminServiceimpl;
import com.wuyibin.service.impl.CourseServiceimpl;
import com.wuyibin.util.Hibernateutil;

public class AdminAction extends ActionSupport {
	private Student student;
	private Admin admin;
	private Course course;
	private int index;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}	
	//==============删除学生==================
	public String deletestudent(){
		System.out.println("删除学生操作");
		Student stu= new Student();;
		try {
			System.out.println(student.getId());
			stu = (Student)Hibernateutil.find(stu.getClass(),student.getId());
			System.out.println("查询出来的学生"+stu);
			AdminService as= new AdminServiceimpl();
			as.deletestudent(stu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deletestu";
	}
	//==============查看所有学生===============
	public String allstudents(){
		List students=null;
		int count=0;
		int currentpage=0;
		try {
			System.out.println("查看所有学生");
			Student stu= new Student();
			System.out.println("类型="+stu.getClass());
			AdminService as=new AdminServiceimpl();
			
			students=index!=0?as.allstudents(index,stu.getClass()):as.allstudents(1, stu.getClass());
			count =(as.listallstudent(stu.getClass()).size()-1)/5+1;
			currentpage=index!=0?index:1;
			System.out.println(count);
			//System.out.println(students);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("students",students);
		request.setAttribute("count", count);
		request.setAttribute("currentpage", currentpage);
		
		return "allstudents";
	}
	//==============修改课程==================
	public String updatecourse(){
		System.out.println("修改课程");
		Course cou=new Course();
		CourseService courseService=new CourseServiceimpl();
		cou=courseService.findcourse(cou, course.getId());
		cou.setCnumber(course.getCnumber());
		cou.setName(course.getName());
		cou.setLessonhours(course.getLessonhours());
		cou.setLessonpoints(course.getLessonpoints());
		System.out.println("要修改的"+course);
		courseService.updatecourse(cou);
		
		return "update";
	}
	//================删除课程=================

	public String delete(){
		//Course cou=(Course)Hibernateutil.find(course.getClass(), course.getId());
		try {
			Course cou=new Course();
			System.out.println(course.getId());
			CourseService cs= new CourseServiceimpl();
			cou=(Course)cs.findcourse(cou, course.getId());
			System.out.println("查询出来的课程"+cou);
			cs.deletecourse(cou);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deletedone";
		
	}
	//================查看所有课程=====================
	public String listcourse(){
		Course cou=new Course();
		try {
			List alllist=null;
			CourseService cs= new CourseServiceimpl();
			System.out.println(cou.getClass());
			alllist=cs.listcourse(index,cou.getClass());
			HttpServletRequest request= ServletActionContext.getRequest();
			request.setAttribute("alllist",alllist);
			int count=(cs.listallcourse(cou).size()-1)/5+1;
			request.setAttribute("count",count);
			request.setAttribute("currentpage",index!=0?index:1);
			System.out.println("count"+count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "listall";
	}
	//=============搜索课程===================
	public String searchcourse(){
		Course cou=new Course();
		cou.setName(course.getName());
		cou.setCnumber(course.getCnumber());
		cou.setLessonpoints(course.getLessonpoints());
		CourseService cs= new CourseServiceimpl();
		List list=cs.searchcourse(index,cou);
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("alllist", list);
		return "searchdone";
	}
	
	
	
	//================退出登录=================
	public String logout(){
		ActionContext ac=  ActionContext.getContext();
		
		ac.getSession().remove("user");
		return "logout";
	}
	//================管理员登录=======================
//	public String login(){
//		System.out.println(admin);
//		Admin ad=null;
//		AdminService adminService=new AdminServiceimpl();
//		ad=adminService.login(admin);
//		System.out.println(ad);
//		if(ad==null)
//			return INPUT;
//		else{
//			HttpServletRequest request = ServletActionContext.getRequest();
//			request.setAttribute("admin",ad);
//			return SUCCESS;
//		}
//			
//	}
}

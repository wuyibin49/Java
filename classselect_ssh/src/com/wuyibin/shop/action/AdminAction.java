package com.wuyibin.shop.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wuyibin.shop.model.Admin;
import com.wuyibin.shop.model.Course;
import com.wuyibin.shop.model.Student;
import com.wuyibin.shop.service.AdminService;
import com.wuyibin.shop.service.CourseService;
import com.wuyibin.shop.service.StudentService;
import com.wuyibin.shop.service.impl.AdminServiceimpl;

public class AdminAction extends ActionSupport {
	private Student student;
	private Admin admin;
	private Course course;
	private int index;
	private AdminService adminservice;
	private CourseService courseservice;
	private StudentService studentservice;
	
	public AdminService getAdminservice() {
		return adminservice;
	}
	public void setAdminservice(AdminService adminservice) {
		this.adminservice = adminservice;
	}
	public CourseService getCourseservice() {
		return courseservice;
	}
	public void setCourseservice(CourseService courseservice) {
		this.courseservice = courseservice;
	}
	public StudentService getStudentservice() {
		return studentservice;
	}
	public void setStudentservice(StudentService studentservice) {
		this.studentservice = studentservice;
	}
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
	//==================���ѧ��=================
	public String addstudent(){
		if(student!=null)
			adminservice.addstudent(student);		
		return "addsuccess";
	}
	//==============ɾ��ѧ��==================
	public String deletestudent(){
		System.out.println("ɾ��ѧ������");
		Student stu= new Student();;
		try {
			
			stu = (Student)adminservice.findsinglestudent(stu,student.getId());
			
		//	AdminService as= new AdminServiceimpl();
			adminservice.deletestudent(stu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deletestu";
	}
	//==============�鿴����ѧ��===============
	public String allstudents(){
		List students=null;
		int count=0;
		int currentpage=0;
		try {
			System.out.println("�鿴����ѧ��");
			Student stu= new Student();
		//	System.out.println("����="+stu.getClass());
			//AdminService as=new AdminServiceimpl();
			
			students=index!=0?adminservice.findstudents(index,stu.getClass()):adminservice.findstudents(1, stu.getClass());
			System.out.println(students.isEmpty());
			count =(adminservice.findallstudent(stu.getClass()).size()-1)/5+1;
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
	//==============�޸Ŀγ�==================
	public String updatecourse(){
		System.out.println("�޸Ŀγ�");
		Course cou=new Course();
		//CourseService courseService=new CourseServiceimpl();
		cou=courseservice.findcourse(cou, course.getId());
		cou.setCnumber(course.getCnumber());
		cou.setName(course.getName());
		cou.setLessonhours(course.getLessonhours());
		cou.setLessonpoints(course.getLessonpoints());
		System.out.println("Ҫ�޸ĵ�"+course);
		courseservice.updatecourse(cou);
		
		return "update";
	}
	//================ɾ���γ�=================

	public String delete(){
		//Course cou=(Course)Hibernateutil.find(course.getClass(), course.getId());
		try {
			Course cou=new Course();
			System.out.println(course.getId());
			adminservice.deletecourse(cou,course.getId());
		//	CourseService cs= new CourseServiceimpl();
//			cou=(Course)courseservice.findcourse(cou, course.getId());
//			System.out.println("��ѯ�����Ŀγ�"+cou);
//			courseservice.deletecourse(cou);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deletedone";
		
	}
	//================�鿴���пγ�=====================
	public String listcourse(){
		Course cou=new Course();
		try {
			List alllist=null;
		//	CourseService cs= new CourseServiceimpl();
			System.out.println(cou.getClass());
			alllist=courseservice.searchcourse(index,cou);
			HttpServletRequest request= ServletActionContext.getRequest();
			request.setAttribute("alllist",alllist);
			int count=(courseservice.findallcourse(cou).size()-1)/5+1;
			request.setAttribute("count",count);
			request.setAttribute("currentpage",index!=0?index:1);
			System.out.println("count"+count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "listall";
	}
	//=============�����γ�===================
	public String searchcourse(){
		Course cou=new Course();
		if(course!=null){	
		if(course.getName()!=null)
			cou.setName(course.getName());
		if(course.getCnumber()!=null)
			cou.setCnumber(course.getCnumber());
		if(course.getLessonpoints()!=null)
			cou.setLessonpoints(course.getLessonpoints());
		}
	//	CourseService cs= new CourseServiceimpl();
		List list=index!=0?courseservice.searchcourse(index,cou):courseservice.searchcourse(1,cou);
		System.out.println("��ѯ������course"+list);
		HttpServletRequest request = ServletActionContext.getRequest();
		int count=(courseservice.findallcourse(cou).size()-1)/5+1;
		request.setAttribute("count",count);
		request.setAttribute("currentpage",index!=0?index:1);
		
		request.setAttribute("alllist", list);
		return "searchdone";
	}
	
	
	
	//================�˳���¼=================
	public String logout(){
		ActionContext ac=  ActionContext.getContext();		
		
		ac.getSession().remove("user");
		return "logout";
	}
	//================����Ա��¼=======================
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

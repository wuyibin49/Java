package com.wuyibin.shop.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wuyibin.shop.model.Course;
import com.wuyibin.shop.model.Student;
import com.wuyibin.shop.service.AdminService;
import com.wuyibin.shop.service.CourseService;
import com.wuyibin.shop.service.StudentService;

public class StudentAction extends ActionSupport {
	private Course course;
	private Student student;
	private StudentService studentservice;
	private CourseService courseservice;
	private AdminService adminservice;
	
	public AdminService getAdminservice() {
		return adminservice;
	}

	public void setAdminservice(AdminService adminservice) {
		this.adminservice = adminservice;
	}

	public StudentService getStudentservice() {
		return studentservice;
	}

	public void setStudentservice(StudentService studentservice) {
		this.studentservice = studentservice;
	}

	public CourseService getCourseservice() {
		return courseservice;
	}

	public void setCourseservice(CourseService courseservice) {
		this.courseservice = courseservice;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	//===========�˳���¼=================
	public String logout(){
		ActionContext ac=  ActionContext.getContext();
		ac.getSession().remove("user");
		return SUCCESS;
	}
	//===============��¼=================
	
	//==============��ѡ==================
	public String deletecourse(){
		Student stu= (Student)ActionContext.getContext().getSession().get("user");
		stu=(Student)adminservice.findsinglestudent(stu,stu.getId());
		Set<Course> set = stu.getCourses();
		System.out.println("ɾ��ǰ"+set);
		for(Iterator<Course>it=set.iterator();it.hasNext();){
			Course cou=it.next();
			if(cou.getId()==course.getId())
				it.remove();
			}
		System.out.println("ɾ����"+set);
		stu.setCourses(set);
		adminservice.updatestudent(stu);
		return "delcourse";
	}
	//==============��ʾ��ѡ�γ�==================
	public String selectedcou(){
		Student stu = null;
		Set<Course> set= new HashSet<Course>();
		stu= (Student)ActionContext.getContext().getSession().get("user");
		stu=(Student)adminservice.findsinglestudent(stu,stu.getId());
		set=stu.getCourses();
		ActionContext ac= ActionContext.getContext();
		ac.getSession().put("set", set);
		return "selectedcou";
	}
	//==============ѡ��==================
	public String  selectcourse() throws Exception{		
		Student stu = null;
		Course cou = new Course();
		String st=null;
		boolean flag=false;
		stu= (Student)ActionContext.getContext().getSession().get("user");
		stu=(Student)adminservice.findsinglestudent(stu,stu.getId());
		System.out.println("��ѯ������"+stu);
		Set<Course> set= stu.getCourses();
		System.out.println("setΪ��"+set.isEmpty());
		System.out.println(set);
		//System.out.println("====================");
		//CourseService courseService=new CourseServiceimpl();
		//System.out.println("id="+course.getId());
		if(course!=null)
			cou=courseservice.findcourse(cou, course.getId());
		for(Iterator<Course>it=set.iterator();it.hasNext();){
			Course c=it.next();
			if(course!=null&&course.getId()==c.getId()){
				flag=true;				
			}			
		}	
		if(flag==false){
		set.add(cou);	
		System.out.println("��ӿγ�"+set);
		//System.out.println("00000000000000000000"+set);
		stu.setCourses(set);
		System.out.println("ѡ�κ��"+stu);
		//StudentService service = new StudentServiceimpl();
		studentservice.addcourse(stu);
		
		return "selectsuccess";
		}else
			return "courseexist";
		
	} 
			
	
}

package com.wuyibin.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wuyibin.model.Course;
import com.wuyibin.model.Student;
import com.wuyibin.service.CourseService;
import com.wuyibin.service.StudentService;
import com.wuyibin.service.impl.CourseServiceimpl;
import com.wuyibin.service.impl.StudentServiceimpl;
import com.wuyibin.util.Hibernateutil;

public class StudentAction extends ActionSupport {
	private Course course;
	private Student student;
	
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
		stu=(Student)Hibernateutil.find(stu.getClass(),stu.getId());
		Set<Course> set = stu.getCourses();
		System.out.println("ɾ��ǰ"+set);
		for(Iterator<Course>it=set.iterator();it.hasNext();){
			Course cou=it.next();
			if(cou.getId()==course.getId())
				it.remove();
			}
		System.out.println("ɾ����"+set);
		stu.setCourses(set);
		Hibernateutil.update(stu);
		return SUCCESS;
	}
	//==============��ʾ��ѡ�γ�==================
	public String selectedcou(){
		Student stu = null;
		Set<Course> set= new HashSet<Course>();
		stu= (Student)ActionContext.getContext().getSession().get("user");
		stu=(Student)Hibernateutil.find(stu.getClass(),stu.getId());
		set=stu.getCourses();
		ActionContext ac= ActionContext.getContext();
		ac.getSession().put("set", set);
		return SUCCESS;
	}
	//==============ѡ��==================
	public String  selectcourse(){		
		Student stu = null;
		Course cou = new Course();
		String st=null;
		boolean flag=false;
		stu= (Student)ActionContext.getContext().getSession().get("user");
		stu=(Student)Hibernateutil.find(stu.getClass(),stu.getId());
		System.out.println("��ѯ������"+stu);
		Set<Course> set= stu.getCourses();
		//System.out.println("====================");
		CourseService courseService=new CourseServiceimpl();
		//System.out.println("id="+course.getId());
		cou=courseService.findcourse(cou, course.getId());
		for(Iterator<Course>it=set.iterator();it.hasNext();){
			Course c=it.next();
			if(course.getId()==c.getId()){
				flag=true;				
			}			
		}	
		if(flag==false){
		set.add(cou);	
		System.out.println("��ӿγ�"+set);
		//System.out.println("00000000000000000000"+set);
		stu.setCourses(set);
		System.out.println("ѡ�κ��"+stu);
		StudentService service = new StudentServiceimpl();
		service.selectcourse(stu);
		st=SUCCESS;
		return st;
		}else
			return "courseexist";
		
	} 
			
	
}

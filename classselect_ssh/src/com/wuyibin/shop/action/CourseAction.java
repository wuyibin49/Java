package com.wuyibin.shop.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wuyibin.shop.model.Course;
import com.wuyibin.shop.service.CourseService;


public class CourseAction extends ActionSupport {
	private Course course;
	private int cnumber;
	private  String name;
	private int  lessonhours;
	private int lessonpoints;
	private int index;
	private CourseService courseservice;
	
	public CourseService getCourseservice() {
		return courseservice;
	}
	public void setCourseservice(CourseService courseservice) {
		this.courseservice = courseservice;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getCnumber() {
		return cnumber;
	}
	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLessonhours() {
		return lessonhours;
	}
	public void setLessonhours(int lessonhours) {
		this.lessonhours = lessonhours;
	}
	public int getLessonpoints() {
		return lessonpoints;
	}
	public void setLessonpoints(int lessonpoints) {
		this.lessonpoints = lessonpoints;
	}
	//================查看所有课程====================

	public String findallcourse() throws Exception {
		List list = null;
		int count=0;
		Course course = new Course();
	//	CourseService  courseservice = new CourseServiceimpl();
		list = index!=0?courseservice.searchcourse(index,course):courseservice.searchcourse(1, course);
		count=courseservice.findallcourse(course).size();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list",list);
		request.setAttribute("count",count);
		System.out.println("count"+count);
		System.out.println(list);
		return "allcourses";
	}
	//=====================获取单个课程============
	public String getsinglecourse(){
		Course cou =new Course();
		//CourseService cs = new CourseServiceimpl();
		cou=courseservice.findcourse(cou, course.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("single",cou);
		System.out.println("单个"+cou);
		return "single";
	}
	//=====================添加课程==============
public String addcourse() throws Exception{
	System.out.println("新增课程");
	Course course1 = new Course();
//	SessionFactory sessionFactory= Hibernateutil.getSessionfactory();
	course1.setCnumber(cnumber);
	course1.setName(name);
	course1.setLessonhours(lessonhours);
	course1.setLessonpoints(lessonpoints);
	System.out.println(course1);
	//sessionFactory.evict(course1.getClass());
//	CourseService courseService = new CourseServiceimpl();
	courseservice.addcourse(course1);
	
	return SUCCESS;
}
	
}

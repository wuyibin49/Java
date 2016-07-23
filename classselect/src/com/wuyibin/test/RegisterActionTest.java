package com.wuyibin.test;

import junit.framework.TestCase;

import org.junit.Test;

import com.wuyibin.model.Student;

public class RegisterActionTest extends TestCase{

	@Test
	public void test() {
	
		Student student = new Student();
		student.setName("123");
		student.setPassword("password");
		student.setAge(12);
		RegisterActionTest  ra= new RegisterActionTest();
		System.out.println(student);
	}

}

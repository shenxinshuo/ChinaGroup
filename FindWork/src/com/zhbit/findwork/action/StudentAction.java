package com.zhbit.findwork.action;


import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Student;
import com.zhbit.findwork.servicce.StudentService;

public class StudentAction extends ActionSupport{
	
	private StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public String addStudent() {
		System.out.println("add..action...");
		Student student = new Student();
		student.setUsername("john");
		student.setPassword("520");
		studentService.addStudent(student);
		return NONE;
	}
	
}

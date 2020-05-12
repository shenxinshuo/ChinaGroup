package com.zhbit.findwork.servicce;

import com.zhbit.findwork.dao.StudentDao;
import com.zhbit.findwork.entity.Student;

public class StudentService {

	private StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	//add
	public void addStudent(Student student) {
		System.out.println("add..service...");
		studentDao.addStudent(student);
	}
	
}

package com.zhbit.findwork.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.zhbit.findwork.entity.Student;
@Transactional
public class StudentDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//add
	public void addStudent(Student student) {
//		ApplicationContext context  = new ClassPathXmlApplicationContext("spring.xml");
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//		//---------------------------
//		session.save(student);
//		//--------------------------
//		transaction.commit();
//		session.close();
//		sessionFactory.close();
		sessionFactory.getCurrentSession().save(student);
	}
}

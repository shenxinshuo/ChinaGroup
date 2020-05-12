package com.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.zhbit.findwork.entity.Student;


/**
 * 亲测可用
 * @author SX
 *
 */
//@Transactional
public class TestMysql {
	
	public void testConnection() {
		Configuration config = new Configuration();
		config.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//---------------------------
		
		//--------------------------
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void testAdd() {
		Configuration config = new Configuration();
		config.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//---------------------------
		Student student = new Student();
		student.setPassword("123456");
		student.setUsername("沈鑫烁");
		session.save(student);
		//--------------------------
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void testUpdate() {
		Configuration config = new Configuration();
		config.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//---------------------------
		Student student = (Student) session.get(Student.class, 1);
		student.setPassword("857857");
		student.setUsername("hello");
		session.update(student);
		//--------------------------
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void testgetAll() {
		Configuration config = new Configuration();
		config.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//---------------------------
		String hql = "from Student";
		Query query = session.createQuery(hql);
		List<Student> students = query.list();
		for (int i=0; i<students.size(); i++) {
			System.out.println(students.get(i));
		}
		//--------------------------
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void testGetByName() {
		Configuration config = new Configuration();
		config.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//---------------------------
		String hql = "from Student where username = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", "沈鑫烁");
		List<Student> students = query.list();
		for (int i=0; i<students.size(); i++) {
			System.out.println(students.get(i));
		}
		//--------------------------
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void testDelete() {
		Configuration config = new Configuration();
		config.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//---------------------------
		Student student = new Student();
		student.setId(1);
		session.delete(student);
		//--------------------------
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void testSping_Hibernate() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("spring.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//---------------------------
		String hql = "from Student";
		Query query = session.createQuery(hql);
		List<Student> students = query.list();
		for (int i=0; i<students.size(); i++) {
			System.out.println(students.get(i));
		}
		//--------------------------
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		
	}
	
	//此方法暂时搞不动
	@SuppressWarnings("resource")
	public void testSpingTransaction() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("spring.xml");
		HibernateTemplate hibernateTemplate = (HibernateTemplate) context.getBean("hibernateTemplate");
		Student student = new Student();
		student.setUsername("hhh");
		student.setPassword("66666");
		hibernateTemplate.save(student);
	}
	
	public static void main(String[] args) {
		TestMysql test = new TestMysql();
		//test.testAdd();
		//test.testUpdate();
		//test.testgetAll();
		//test.testGetByName();
		//test.testDelete();
		//test.testSping_Hibernate();
		test.testSpingTransaction();
	}
}

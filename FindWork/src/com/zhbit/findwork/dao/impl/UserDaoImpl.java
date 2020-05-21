package com.zhbit.findwork.dao.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import com.zhbit.findwork.dao.UserDao;
import com.zhbit.findwork.entity.User;

/**
 * 
 * @author 王德略
 * @description 用户dao的实现类
 * @date 2020年5月16日
 */
public class UserDaoImpl implements UserDao {
	
	//注入hibernate的session工程，配置文件在application.xml中
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean isExistbyName(String name) {
		// TODO Auto-generated method stub
		String hql = "from User where name = :userName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("userName", name);
		List<User> users = query.list();
		if (users == null || users.size() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isExistbyId(String id) {
		// TODO Auto-generated method stub
		String hql = "from User where id = :userid";
		User user = (User)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("userid", id)
				.uniqueResult();
		if (user== null) {
			return false;
		}
		return true;
	}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		user.setCreate_at(new Date());
		user.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		user.setUpdate_at(new Date());
		System.out.println("dao============================");
		sessionFactory.getCurrentSession().merge(user);
	}

	@Override
	public User getUserByID(int id) {
		// TODO Auto-generated method stub
		User user=(User)sessionFactory.getCurrentSession().get(User.class, id);
		if(user!=null)
			if(user.getDelete_flag()==1)//删除标志为1，已删除，不能被查询
				return null;
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		//0没有被删除
		String hql="from User u where name=? and delete_flag = 0 ";
		User user=(User)sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, name)
				.uniqueResult();
		return user;
	}
	

	@Override
	public void deleteUserByID(int id) {
		// TODO Auto-generated method stub
		//设置删除标志 1 即 表示删除
		User user=(User)sessionFactory.getCurrentSession().get(User.class, id);
		user.setDelete_flag(1);
		user.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().update(user);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserByPage(int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		String hql="from User where delete_flag = 0 order by id";
		List<User> list=(List<User>)sessionFactory.getCurrentSession().createQuery(hql)
						.setFirstResult(firstResult)
						.setMaxResults(maxResults)
						.list();
		return list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from User where delete_flag = 0";
		long count=(Long)sessionFactory.getCurrentSession()
				.createQuery(hql).uniqueResult();
		return (int)count;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		String hql="from User u where delete_flag = 0";//删除标志
		List<User> users=(List<User>)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.list();
		return users;
	}

	@Override
	public User getUserByNameAndPassword(String name,String password) {
		// TODO Auto-generated method stub
		String hql = "from User where name = :userName and password=:password";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("userName", name);
		query.setParameter("password", password);
		return (User)query.uniqueResult();
	}






}

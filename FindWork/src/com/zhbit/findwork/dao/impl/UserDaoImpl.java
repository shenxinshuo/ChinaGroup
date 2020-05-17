package com.zhbit.findwork.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import com.zhbit.findwork.dao.UserDao;
import com.zhbit.findwork.entity.Business;
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
	public boolean isExist(String name) {
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
		sessionFactory.getCurrentSession().merge(user);
	}

	@Override
	public User getUserByID(int id) {
		// TODO Auto-generated method stub
		User user=(User)sessionFactory.getCurrentSession().get(User.class, id);
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserListByName(String name) {
		// TODO Auto-generated method stub
		String hql="from User u where name=?";
		List<User> list=(List<User>)sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, name)
				.list();
		return list;
	}

	@Override
	public void deleteUserByID(int id) {
		// TODO Auto-generated method stub
		User user=(User)sessionFactory.getCurrentSession().get(User.class, id);
		user.setDelete_flag(1);
		user.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().update(user);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserByPage(int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		String hql="from User order by id";
		List<User> list=(List<User>)sessionFactory.getCurrentSession().createQuery(hql)
						.setFirstResult(firstResult)
						.setMaxResults(maxResults)
						.list();
		return list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from User";
		long count=(Long)sessionFactory.getCurrentSession()
				.createQuery(hql).uniqueResult();
		return (int)count;
	}


}

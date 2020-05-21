package com.zhbit.findwork.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.zhbit.findwork.dao.AdministratorDao;
import com.zhbit.findwork.entity.Administrator;
import com.zhbit.findwork.entity.Post;
import com.zhbit.findwork.entity.User;

public class AdministratorDaoImpl implements AdministratorDao {

	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.AdministratorDao#addAdmin(com.zhbit.findwork.entity.Administrator)
	 */
	@Override
	public void addAdmin(Administrator admin){
		admin.setCreate_at(new Date());
		admin.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().save(admin);
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.AdministratorDao#deleteAdmin(int)
	 */
	@Override
	public void deleteAdmin(int id) {
		Administrator admin = (Administrator) sessionFactory.getCurrentSession().get(Administrator.class, id);
		admin.setDelete_flag(1);//将删除标识改为1，标识该记录已删除
		admin.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().update(admin);
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.AdministratorDao#updateAdmin(com.zhbit.findwork.entity.Administrator)
	 */
	@Override
	public void updateAdmin(Administrator admin) {
		admin.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().merge(admin);
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.AdministratorDao#isExist(java.lang.String)
	 */
	@Override
	public boolean isExist(String adminName) {
		String hql="from Administrator where account = :adminName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("adminName", adminName);
		List<Administrator> admins = query.list();
		if (admins == null || admins.size() == 0) {
			return false;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.AdministratorDao#getAdminByName(java.lang.String)
	 */
	@Override
	public List<Administrator> getAdminByName(String name) {
		String hql = "from Administrator where account = :Name and delete_flag = 0";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("Name", name);
		List<Administrator> admins = query.list();
		return admins;
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.AdministratorDao#getAdminByID(int)
	 */
	@Override
	public Administrator getAdminByID(int id) {
		Administrator admin = (Administrator) sessionFactory.getCurrentSession().get(Administrator.class, id);
		if (admin != null) {
			if (admin.getDelete_flag() == 1) {
				//说明该记录已被删除
				return null;
			}
		}
		return admin;
	}
	
	@Override
	public Administrator getAdminByNameAndPassword(String name,String password) {
		// TODO Auto-generated method stub
		String hql = "from Administrator where account = :name and password=:password";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("name", name);
		query.setParameter("password", password);
		return (Administrator)query.uniqueResult();
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.AdministratorDao#getSessionFactory()
	 */
	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.AdministratorDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	};
	
}

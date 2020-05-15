package com.zhbit.findwork.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.zhbit.findwork.dao.RoleDao;
import com.zhbit.findwork.entity.Role;

/**
 * RoleDao实现类
 * @author SX
 *
 */
public class RoleDaoImpl implements RoleDao{

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 添加角色
	 */
	@Override
	public void addRole(Role role) {
		role.setCreate_at(new Date());
		role.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().save(role);
	}
	@Override
	public boolean isExist(String roleName) {
		String hql="from Role where name = :roleName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("roleName", roleName);
		List<Role> roles = query.list();
		if (roles == null || roles.size() == 0) {
			return false;
		}
		return true;
	}
	@Override
	public void updateRole(Role role) {
		role.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().update(role);
	}
	@Override
	public void deleteRole(int id) {
//		Role role = new Role();
//		role.setId(id);
		Role role = (Role) sessionFactory.getCurrentSession().get(Role.class, id);
		role.setDelete_flag(1);//将删除标识改为1，标识该记录已删除
		role.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().update(role);
	}
	@Override
	public Role getRoleByID(int id) {
		Role role = (Role) sessionFactory.getCurrentSession().get(Role.class, id);
		return role;
	}
	@Override
	public List<Role> getRolesByPage(int firstResult, int maxResults) {
		String hql="from Role order By id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(firstResult)
			.setMaxResults(maxResults);
		List<Role> roles = query.list();
		return roles.size() == 0 ? null : roles;
	}
	@Override
	public int getCount() {
		String hql = "select count(R.id) from Role R";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long sum = (Long)query.uniqueResult(); //获得的整数只能为Long型，需要自己再转换为int
		String temp = String.valueOf(sum);  //强制转换会报错Cannot cast from Long to int
		int count = Integer.parseInt(temp);    //故先转String，再转int
		return count;
	}
	
}

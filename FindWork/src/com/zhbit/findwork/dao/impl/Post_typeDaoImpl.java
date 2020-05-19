package com.zhbit.findwork.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.zhbit.findwork.dao.Post_typeDao;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.entity.Role;

public class Post_typeDaoImpl implements Post_typeDao {

	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.Post_typeDao#addPost_type(com.zhbit.findwork.entity.Post_type)
	 */
	@Override
	public void addPost_type(Post_type pt){
		pt.setCreate_at(new Date());
		pt.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().save(pt);
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.Post_typeDao#deletePost_type(int)
	 */
	@Override
	public void deletePost_type(int id) {
		Post_type pt = (Post_type) sessionFactory.getCurrentSession().get(Post_type.class, id);
		pt.setDelete_flag(1);//将删除标识改为1，标识该记录已删除
		pt.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().update(pt);
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.Post_typeDao#updatePost_type(com.zhbit.findwork.entity.Post_type)
	 */
	@Override
	public void updatePost_type(Post_type pt) {
		pt.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().merge(pt);
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.Post_typeDao#getPost_typeByID(int)
	 */
	@Override
	public Post_type getPost_typeByID(int id) {
		Post_type pt = (Post_type) sessionFactory.getCurrentSession().get(Post_type.class, id);
		if (pt != null) {
			if (pt.getDelete_flag() == 1) {
				//说明该记录已被删除
				return null;
			}
		}
		return pt;
	}
	
	@Override
	public List<Post_type> getPost_typeByName(String name) {
		String hql = "from Post_type where PTname = :Name and delete_flag = 0";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("Name", name);
		List<Post_type> pts = query.list();
		return pts;
	}
	
	@Override
	public List<Post_type> getAllPost_type() {
		String hql = "from Post_type";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Post_type> pts = query.list();
		return pts;
	}
	
	@Override
	public boolean isExist(String post_typeName) {
		String hql="from Role where name = :post_typeName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("post_typeName", post_typeName);
		List<Post_type> pts = query.list();
		if (pts == null || pts.size() == 0) {
			return false;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.Post_typeDao#getSessionFactory()
	 */
	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.Post_typeDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}

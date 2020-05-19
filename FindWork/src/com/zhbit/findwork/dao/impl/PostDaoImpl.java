package com.zhbit.findwork.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.zhbit.findwork.dao.PostDao;
import com.zhbit.findwork.entity.Post;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.entity.Role;

public class PostDaoImpl implements PostDao {

	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.PostDao#addPost(com.zhbit.findwork.entity.Post)
	 */
	@Override
	public void addPost(Post p){
		p.setCreate_at(new Date());
		p.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().save(p);
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.PostDao#deletePost(int)
	 */
	@Override
	public void deletePost(int id) {
		Post p = (Post) sessionFactory.getCurrentSession().get(Post.class, id);
		p.setDelete_flag(1);//将删除标识改为1，标识该记录已删除
		p.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().update(p);
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.PostDao#updatePost(com.zhbit.findwork.entity.Post)
	 */
	@Override
	public void updatePost(Post p) {
		p.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().merge(p);
	}
	
	@Override
	public boolean isExist(String postName) {
		String hql="from Role where name = :postName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("postName", postName);
		List<Post> ps = query.list();
		if (ps == null || ps.size() == 0) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<Post> getPostByName(String name) {
		String hql = "from Post where name = :Name and delete_flag = 0";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("Name", name);
		List<Post> ps = query.list();
		return ps;
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.PostDao#getPostByID(int)
	 */
	@Override
	public Post getPostByID(int id) {
		Post p = (Post) sessionFactory.getCurrentSession().get(Post.class, id);
		if (p != null) {
			if (p.getDelete_flag() == 1) {
				//说明该记录已被删除
				return null;
			}
		}
		return p;
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.PostDao#getSessionFactory()
	 */
	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.PostDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}

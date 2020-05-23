package com.zhbit.findwork.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import com.zhbit.findwork.dao.Collection_BusinessDao;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Collection_Business;
import com.zhbit.findwork.entity.User;
/**
 * 
 * @author 王德略
 * @description 企业收藏中心dao的实现类
 * @date 2020年5月16日
 */
public class Collection_BusinessDaoImpl implements Collection_BusinessDao {
	// 注入hibernate的session工程，配置文件在application.xml中
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Collection_Business c_b) {
		// TODO Auto-generated method stub
		c_b.setCreate_at(new Date());
		c_b.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().save(c_b);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Business> getBusinessesByUserId(int userid) {
		// TODO Auto-generated method stub
		//从表中根据用户id查找出收藏的对象,删除标志为0
		String hql="from Collection_Business as cb where Uid =? and delete_flag = 0 ";
		List<Collection_Business> c_bs=(List<Collection_Business>)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter(0, userid)
				.list();
		//建立一个企业链表
		List<Business> businesses= new ArrayList<Business>();
		for(int i=0;i<c_bs.size();i++){
			//通过收藏的对象查找出企业，然后加入链表中
			businesses.add(c_bs.get(i).getBusiness());
		}
		return businesses;
	}

	@Override
	public void delete(int userid, int businessid) {
		// TODO Auto-generated method stub
		String hql="from Collection_Business as cb where Uid =? and Bid = ? and delete_flag = 0";
		Collection_Business c_b=(Collection_Business)sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, userid)
				.setParameter(1, businessid)
				.uniqueResult();
		c_b.setDelete_flag(1);//设置删除标志为1即删除
		sessionFactory.getCurrentSession().merge(c_b);//更新
		System.out.println("删除成功");
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isExist(Collection_Business c_b) {
		// TODO Auto-generated method stub
		String hql="from Collection_Business as cb where Uid =? and Bid = ? and delete_flag = 0 ";
		List<Collection_Business> cb=(List<Collection_Business>)sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0,c_b.getUser().getId() )
				.setParameter(1, c_b.getBusiness().getId())
				.list();
		if(cb.size()==0){				
			return false;
		}
		else
			return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Business> getBusinessesByPage(int userid, int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		String hql="from Collection_Business as cb where Uid =? and delete_flag = 0 order by id";
		List<Collection_Business> c_bs=(List<Collection_Business>)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter(0, userid)
				.setFirstResult(firstResult)
				.setMaxResults(maxResults)
				.list();
		//建立一个企业链表
		List<Business> businesses= new ArrayList<Business>();
		for(int i=0;i<c_bs.size();i++){
			//通过收藏的对象查找出企业，然后加入链表中
			businesses.add(c_bs.get(i).getBusiness());
		}
		return businesses;
	}



}

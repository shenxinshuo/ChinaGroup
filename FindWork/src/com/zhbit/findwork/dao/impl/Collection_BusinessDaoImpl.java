package com.zhbit.findwork.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import com.zhbit.findwork.dao.Collection_BusinessDao;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Collection_Business;
import com.zhbit.findwork.entity.User;

public class Collection_BusinessDaoImpl implements Collection_BusinessDao {
	// ע��hibernate��session���̣������ļ���application.xml��
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
		//�ӱ��и����û�id���ҳ��ղصĶ���,ɾ����־Ϊ0
		String hql="from Collection_Business as cb where Uid =? and delete_flag = 0";
		List<Collection_Business> c_bs=(List<Collection_Business>)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter(0, userid)
				.list();
		//����һ����ҵ����
		List<Business> businesses= new ArrayList<Business>();
		for(int i=0;i<c_bs.size();i++){
			//ͨ���ղصĶ�����ҳ���ҵ��Ȼ�����������
			businesses.add(c_bs.get(i).getBusiness());
		}
		return businesses;
	}

	@Override
	public void delete(int userid, int businessid) {
		// TODO Auto-generated method stub
		String hql="from Collection_Business as cb where Uid =? and Bid = ?";
		Collection_Business c_b=(Collection_Business)sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, userid)
				.setParameter(1, businessid)
				.uniqueResult();
		c_b.setDelete_flag(1);//����ɾ����־Ϊ1��ɾ��
		sessionFactory.getCurrentSession().merge(c_b);//����
	}

	@Override
	public boolean isExist(Collection_Business c_b) {
		// TODO Auto-generated method stub
		String hql="from Collection_Business as cb where Uid =? and Bid = ? and delete_flag = 0 ";
		Collection_Business cb=(Collection_Business)sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0,c_b.getUser().getId() )
				.setParameter(1, c_b.getBusiness().getId())
				.uniqueResult();
		if(cb!=null){
			if(cb.getDelete_flag()==0){
				System.out.println(cb);
				return false;			
			}
		
			return true;
		}
		else
			return true;
	}



}
package com.zhbit.findwork.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.zhbit.findwork.dao.AdvertiseDao;
import com.zhbit.findwork.entity.Advertise;

public class AdvertiseDaoImpl implements AdvertiseDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addAdvertise(Advertise advertise) {
		advertise.setCreateAt(new Date());
		advertise.setUpdateAt(new Date() );
		sessionFactory.getCurrentSession().save(advertise);
	}

	@Override
	public void updateAdvertise(Advertise advertise) {
		advertise.setUpdateAt(new Date() );
		sessionFactory.getCurrentSession().merge(advertise);
	}

	@Override
	public void deleteAdvertiseByID(int id) {
		Advertise advertise = (Advertise) sessionFactory.getCurrentSession().get(Advertise.class, id);
		advertise.setUpdateAt(new Date());
		advertise.setDeleteFlag(1);
		sessionFactory.getCurrentSession().update(advertise);
	}

	@Override
	public Advertise getAdvertiseByID(int id) {
		Advertise advertise = (Advertise) sessionFactory.getCurrentSession().get(Advertise.class, id);
		return advertise;
	}

	@Override
	public List<Advertise> getAdvertiseByExample(Advertise advertise) {
		Example   example  = Example.create(advertise).excludeProperty("lowWages").excludeProperty("largeWages");
		//example.ex
		List<Advertise> results = sessionFactory.getCurrentSession().createCriteria(Advertise.class).add(example).list();
		return results;
	}

	@Override
	public List<Advertise> getUnFinAdvertise() {
		String hql = "from Advertise where  check = 0 and deleteFlag = 0 order by id";
		List<Advertise>  list = sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
	}

	@Override
	public List<Advertise> getAdvertiseByPageWithCheck(int firstResult,
			int maxResults, int check) {
		String hql = "from Advertise where delete_flag = 0 and check= :check order by id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(firstResult)
			.setMaxResults(maxResults)
			.setParameter("check", check);
		List<Advertise> advertises = query.list();
		return advertises;
	}

	@Override
	public List<Advertise> getAdvertiseByBid(int bid,int check) {
		String hql = "from Advertise where delete_flag = 0 and business.id= :bid and check = :check order by id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("bid", bid);
		query.setParameter("check", check);
		List<Advertise> advertises = query.list();
		return advertises;
	}

	@Override
	public int getAdvertiseCountByBid1(int bid) {
		String hql = "select count(*) from Advertise where delete_flag = 0 and business.id= :bid";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("bid", bid);
		Object  o =  query.iterate().next();
		String so = o.toString();
		return Integer.valueOf(so);
	}

	@Override
	public int getAdvertiseCountByBid(int bid, int check) {
		String hql = "select count(*)  from Advertise where delete_flag = 0 and business.id= :bid and check = :check order by id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("bid", bid);
		query.setParameter("check", check);
		Object  o =  query.iterate().next();
		String so = o.toString();
		return Integer.valueOf(so);
	}

	@Override
	public int getUnFinAdvertiseCount() {
		String hql = "select count(*) from Advertise where  check = 0 and deleteFlag = 0 order by id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Object  o =  query.iterate().next();
		String so = o.toString();
		return Integer.valueOf(so);
	}

	@Override
	public List<Advertise> getAdvertiseByBid(int bid,int firstResult,int maxResults) {
		String hql = "from Advertise where delete_flag = 0 and business.id= :bid  order by id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(firstResult)
		.setMaxResults(maxResults).setParameter("bid", bid);
		List<Advertise> advertises = query.list();
		return advertises;
	}

}

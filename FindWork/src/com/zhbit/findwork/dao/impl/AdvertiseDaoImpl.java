package com.zhbit.findwork.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.zhbit.findwork.dao.AdvertiseDao;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Cv;

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
		//Example   example  = Example.create(advertise).excludeProperty("lowWages").excludeProperty("largeWages");
		//example.ex
		String hql = "from Advertise where  check = :check and deleteFlag = :deleteFlag and bid=:bid order by id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("check", advertise.getCheck());
		query.setParameter("deleteFlag", advertise.getDeleteFlag());
		query.setParameter("bid", advertise.getBid());
		//List<Advertise> results = sessionFactory.getCurrentSession().createCriteria(Advertise.class).add(example).list();
		return query.list();
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
	
	@Override
	public List<Advertise> getAdvertisesByPostSearch(String postName, int firstResult, int maxResults) {
		String searchPost = "%"+postName+"%";
		String hql = "from Advertise where delete_flag = 0 and postName like :searchPost";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("searchPost", searchPost)
			.setFirstResult(firstResult)
			.setMaxResults(maxResults);
		List<Advertise> advertises = query.list();
		return advertises;
	}
	
	@Override
	public int getCountByPostSearch(String postName) {
		String searchPost = "%"+postName+"%";
		String hql = "select count(id) from Advertise where delete_flag = 0 and postName like :searchPost";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("searchPost", searchPost);
		Long sum = (Long)query.uniqueResult(); //获得的整数只能为Long型，需要自己再转换为int
		String temp = String.valueOf(sum);  //强制转换会报错Cannot cast from Long to int
		int count = Integer.parseInt(temp);    //故先转String，再转int
		return count;
	}
	
	@Override
	public List<Cv> getCVOfAdvertise(int aID, int firstResult, int maxResults) {
		Advertise advertise = (Advertise) sessionFactory.getCurrentSession().get(Advertise.class, aID);
		Set<Cv> temp = advertise.getCvs();
		List<Cv> cvs = new ArrayList<Cv>();
		Iterator<Cv> it = temp.iterator();
		while (it.hasNext()) {
			cvs.add(it.next());
		}
		int toIndex = firstResult+maxResults;
		return cvs.subList(firstResult > cvs.size() ? cvs.size() : firstResult, toIndex > cvs.size() ? cvs.size() : toIndex);
		
	}

	@Override
	public int getCVCountOfAdvertise(int aID) {
		Advertise advertise = (Advertise) sessionFactory.getCurrentSession().get(Advertise.class, aID);
		Set<Cv> temp = advertise.getCvs();
		List<Cv> cvs = new ArrayList<Cv>();
		Iterator<Cv> it = temp.iterator();
		while (it.hasNext()) {
			cvs.add(it.next());
		}
		return cvs.size();
	}
}

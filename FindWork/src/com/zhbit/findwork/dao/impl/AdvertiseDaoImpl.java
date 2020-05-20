package com.zhbit.findwork.dao.impl;

import java.util.Date;
import java.util.List;

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

}

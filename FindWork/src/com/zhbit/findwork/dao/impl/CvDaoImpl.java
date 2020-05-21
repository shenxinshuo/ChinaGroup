package com.zhbit.findwork.dao.impl;
import java.util.Date;
/**
 * 
 * @author 段世平
 * @description简历dao的实现类
 *@date 2020年5月16日
 */
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.zhbit.findwork.dao.CvDao;
import com.zhbit.findwork.entity.Cv;
import com.zhbit.findwork.entity.User;

public class CvDaoImpl implements CvDao {
	//注入hibernate的session工程，配置文件在application.xml中
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addCv(Cv cv) {
		cv.setCreate_at(new Date());
		cv.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().save(cv);

	}

	@Override
	public void updateCv(Cv cv) {
		cv.setUpdate_at(new Date());
		System.out.println("cv:"+cv.getCreate_at());
		sessionFactory.getCurrentSession().merge(cv);

	}

	@Override
	public void deleteCvByID(int id) {
		Cv cv = (Cv)sessionFactory.getCurrentSession().get(Cv.class, id);
		cv.setDelete_flag(1);//将删除标识改为1，标识该记录已删除
		cv.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().update(cv);

	}

	@Override
	public Cv getCvByID(int id) {
		Cv cv = (Cv)sessionFactory.getCurrentSession().get(Cv.class, id);
		return cv;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Cv getCvByName(String name) {
		String hql = "from Cv where name=? and delete_flag = 0 ";
		Cv cv = (Cv)sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, name)
				.uniqueResult();
		return cv;
	}
	
	@Override
	public List<Cv> getAllCvList(){
		List<Cv> list = sessionFactory.getCurrentSession().createQuery("from t_cv").list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cv> getCvListByUserId(int userid) {
		// TODO Auto-generated method stub
		String hql = "from Cv where Uid=? and delete_flag = 0 ";
		List<Cv> cvs = (List<Cv>)sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, userid)
				.list();
		return cvs;
	}

}

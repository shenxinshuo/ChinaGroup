package com.zhbit.findwork.service.impl;

import java.util.Date;
import java.util.List;

import com.zhbit.findwork.dao.AdvertisementDao;
import com.zhbit.findwork.entity.Advertisement;
import com.zhbit.findwork.service.AdvertisementService;

public class AdvertisementServiceImpl implements AdvertisementService {
	private AdvertisementDao advertisementDao;
	
	public AdvertisementDao getAdvertisementDao() {
		return advertisementDao;
	}

	public void setAdvertisementDao(AdvertisementDao advertisementDao) {
		this.advertisementDao = advertisementDao;
	}

	@Override
	public boolean addAD(Advertisement ad) {
		// TODO Auto-generated method stub
		ad.setCreate_at(new Date());
		ad.setUpdate_at(new Date());
		advertisementDao.add(ad);
		return true;
	}

	@Override
	public Advertisement getAdvertisementById(int adId) {
		// TODO Auto-generated method stub
		return advertisementDao.getAdvertisementById(adId);
	}

	@Override
	public boolean changeAD(Advertisement ad) {
		// TODO Auto-generated method stub
		ad.setUpdate_at(new Date());
		advertisementDao.change(ad);
		return true;
	}

	@Override
	public boolean deleteAD(int adId) {
		// TODO Auto-generated method stub
		advertisementDao.delete(adId);
		return true;
	}

	@Override
	public List<Advertisement> getAllAdvertisements() {
		// TODO Auto-generated method stub
		return advertisementDao.getAllAdvertisements();
	}

}

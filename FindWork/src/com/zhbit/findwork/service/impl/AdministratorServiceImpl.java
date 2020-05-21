package com.zhbit.findwork.service.impl;

import java.util.List;

import com.zhbit.findwork.dao.AdministratorDao;
import com.zhbit.findwork.entity.Administrator;
import com.zhbit.findwork.entity.Post;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.AdministratorService;

public class AdministratorServiceImpl implements AdministratorService {

	private AdministratorDao adminDao;

	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.AdministratorService#addAdmin(com.zhbit.findwork.entity.Administrator)
	 */
	@Override
	public int addAdmin(Administrator admin) {
		boolean exist = adminDao.isExist(admin.getAccount());
		if (exist ==  true) {
			return 0;
		} else  {
			adminDao.addAdmin(admin);
			return 1;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.AdministratorService#updateAdmin(com.zhbit.findwork.entity.Administrator)
	 */
	@Override
	public int updateAdmin(Administrator admin) {
		List<Administrator> admins = (List<Administrator>) adminDao.getAdminByName(admin.getAccount());
		if (admins.size() == 0) {
			//说明数据库中这个名字没人用，也证明修改了角色名 执行修改
			adminDao.updateAdmin(admin);
			return 0;
		} else {
			if (admin.getADid() == admins.get(0).getADid()) {
				//说明要修改信息的企业没有修改名字，修改了别的字段 执行修改
				adminDao.updateAdmin(admin);
				return 0;
			} else {
				return 1;
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.AdministratorService#deleteAdmin(int)
	 */
	@Override
	public void deleteAdmin(int id) {
		adminDao.deleteAdmin(id);
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.AdministratorService#getAdminByID(int)
	 */
	@Override
	public Administrator getAdminByID(int id) {
		Administrator admin = adminDao.getAdminByID(id);
		return admin;
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.AdministratorService#getAdminByName(java.lang.String)
	 */
	@Override
	public List<Administrator> getAdminByName(String name) {
		List<Administrator> admins = adminDao.getAdminByName(name);
		return admins;
	}
	
	@Override
	public Administrator getAdminByNameAndPassword(String name,String password) {
		// TODO Auto-generated method stub
		return adminDao.getAdminByNameAndPassword(name, password);
		
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.AdministratorService#getAdminDao()
	 */
	@Override
	public AdministratorDao getAdminDao() {
		return adminDao;
	}

	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.AdministratorService#setAdminDao(com.zhbit.findwork.dao.AdministratorDao)
	 */
	@Override
	public void setAdminDao(AdministratorDao adminDao) {
		this.adminDao = adminDao;
	}
	
}

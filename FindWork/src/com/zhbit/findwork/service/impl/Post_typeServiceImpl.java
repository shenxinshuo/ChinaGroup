package com.zhbit.findwork.service.impl;

import java.util.List;

import org.hibernate.Query;

import com.zhbit.findwork.dao.Post_typeDao;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.service.Post_typeService;

public class Post_typeServiceImpl implements Post_typeService {

	private Post_typeDao post_typeDao;

	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.Post_typeService#addPost_type(com.zhbit.findwork.entity.Post_type)
	 */
	@Override
	public int addPost_type(Post_type pt) {
		boolean exist = post_typeDao.isExist(pt.getPTname());
		if (exist ==  true) {
			return 0;
		} else  {
			post_typeDao.addPost_type(pt);;
			return 1;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.Post_typeService#updatePost_type(com.zhbit.findwork.entity.Post_type)
	 */
	@Override
	public int updatePost_type(Post_type pt) {
		List<Post_type> pts = (List<Post_type>) post_typeDao.getPost_typeByName(pt.getPTname());
		if (pts.size() == 0) {
			//说明数据库中这个名字没人用，也证明修改了角色名 执行修改
			post_typeDao.updatePost_type(pt);
			return 0;
		} else {
			if (pt.getPTid() == pts.get(0).getPTid()) {
				//说明要修改信息的企业没有修改名字，修改了别的字段 执行修改
				post_typeDao.updatePost_type(pt);
				return 0;
			} else {
				return 1;
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.Post_typeService#deletePost_type(int)
	 */
	@Override
	public void deletePost_type(int id) {
		post_typeDao.deletePost_type(id);
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.Post_typeService#getPost_typeByID(int)
	 */
	@Override
	public Post_type getPost_typeByID(int id) {
		Post_type pt = post_typeDao.getPost_typeByID(id);
		return pt;
	}

	@Override
	public List<Post_type> getAllPost_type() {
		return post_typeDao.getAllPost_type();
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.Post_typeService#getPost_typeByName(java.lang.String)
	 */
	@Override
	public List<Post_type> getPost_typeByName(String name) {
		List<Post_type> pts = post_typeDao.getPost_typeByName(name);
		return pts;
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.Post_typeService#getPost_typeDao()
	 */
	@Override
	public Post_typeDao getPost_typeDao() {
		return post_typeDao;
	}

	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.Post_typeService#setPost_typeDao(com.zhbit.findwork.dao.Post_typeDao)
	 */
	@Override
	public void setPost_typeDao(Post_typeDao post_typeDao) {
		this.post_typeDao = post_typeDao;
	}
	
}

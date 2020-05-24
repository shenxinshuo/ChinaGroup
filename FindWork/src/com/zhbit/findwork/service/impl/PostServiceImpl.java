package com.zhbit.findwork.service.impl;

import java.util.List;

import com.zhbit.findwork.dao.PostDao;
import com.zhbit.findwork.entity.Post;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.service.PostService;

public class PostServiceImpl implements PostService {

	private PostDao postDao;

	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.PostService#addPost(com.zhbit.findwork.entity.Post)
	 */
	@Override
	public int addPost(Post p) {
		boolean exist = postDao.isExist(p.getPname());
		if (exist ==  true) {
			return 0;
		} else  {
			postDao.addPost(p);
			return 1;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.PostService#updatePost(com.zhbit.findwork.entity.Post)
	 */
	@Override
	public int updatePost(Post p) {
		List<Post> pts = (List<Post>) postDao.getPostByName(p.getPname());
		if (pts.size() == 0) {
			//说明数据库中这个名字没人用，也证明修改了角色名 执行修改
			postDao.updatePost(p);
			return 0;
		} else {
			if (p.getPid() == pts.get(0).getPid()) {
				//说明要修改信息的企业没有修改名字，修改了别的字段 执行修改
				postDao.updatePost(p);
				return 0;
			} else {
				return 1;
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.PostService#deletePost(int)
	 */
	@Override
	public void deletePost(int id) {
		postDao.deletePost(id);
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.PostService#getPostByID(int)
	 */
	@Override
	public Post getPostByID(int id) {
		Post p = postDao.getPostByID(id);
		return p;
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.PostService#getPostByName(java.lang.String)
	 */
	@Override
	public List<Post> getPostByName(String name) {
		List<Post> ps = postDao.getPostByName(name);
		return ps;
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.PostService#getPostDao()
	 */
	@Override
	public PostDao getPostDao() {
		return postDao;
	}

	/* (non-Javadoc)
	 * @see com.zhbit.findwork.service.impl.PostService#setPostDao(com.zhbit.findwork.dao.PostDao)
	 */
	@Override
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	@Override
	public List<Post> getAllPost() {
		
		return postDao.getAllPost();
	}

	
}

package com.zhbit.findwork.dao;

import java.util.List;

import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Collection_Advertise;
/**
 * 
 * @author 王德略
 *
 */
public interface Collection_AdvertiseDao {
	/**
	 * 添加一个收藏的招聘
	 * 新增一个招聘收藏对象，然后保存
	 * @param c_b
	 * @return
	 */
	public void add(Collection_Advertise c_a);
	/**
	 * 
	 * 判断该用户是否已经收藏该招聘
	 * @param c_b
	 * @return
	 */
	public boolean isExist(Collection_Advertise c_a);
	/**
	 * 查询用户收藏的所有招聘
	 * userid
	 * @return
	 */
	public List<Advertise> getAdvertisesByUserId(int userid);
	/**
	 * 删除用户收藏的招聘
	 * @param userid businessid
	 * @return
	 */
	public void delete(int userid,int advertiseid);
	/**
	 * 根据分页返回某一页的用户收藏的招聘列表
	 *  @param userid  当前用户
	 * @param firstResult 要查询的第一条记录
	 * @param maxResults  页面大小
	 * @return
	 */
	public List<Advertise> getAdvertiseByPage(int userid,int firstResult, int maxResults);
}

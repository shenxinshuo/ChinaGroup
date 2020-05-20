package com.zhbit.findwork.dao;

import java.util.List;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Collection_Business;
/**
 * 
 * @author 王德略
 *
 */
public interface Collection_BusinessDao {
	/**
	 * 添加一个收藏的企业
	 * 新增一个企业收藏对象，然后保存
	 * @param c_b
	 * @return
	 */
	public void add(Collection_Business c_b);
	/**
	 * 
	 * 判断该用户是否已经收藏该企业
	 * @param c_b
	 * @return
	 */
	public boolean isExist(Collection_Business c_b);
	/**
	 * 查询用户收藏的所有企业
	 * userid
	 * @return
	 */
	public List<Business> getBusinessesByUserId(int userid);
	/**
	 * 删除用户收藏的企业
	 * @param userid businessid
	 * @return
	 */
	public void delete(int userid,int businessid);
	/**
	 * 根据分页返回某一页的用户收藏的企业列表
	 *  @param userid  当前用户
	 * @param firstResult 要查询的第一条记录
	 * @param maxResults  页面大小
	 * @return
	 */
	public List<Business> getBusinessesByPage(int userid,int firstResult, int maxResults);
}

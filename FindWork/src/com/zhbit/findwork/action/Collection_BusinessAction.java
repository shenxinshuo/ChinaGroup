package com.zhbit.findwork.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Page;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.UserService;

/**
 * 用户收藏类
 * 
 * @author 王德略
 *
 */
public class Collection_BusinessAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserService userService;
	private List<Business> Businesses; // 用来存储查询的企业
	private Page page; // 页操控类

	
	public void checkPage(int total) {
		page.setMaxSize(3);// 设置当前页面最大的数量
		int pageCount = total / page.getMaxSize();// 总的页数=总的数量/最大页数（整除情况）
		if (total % page.getMaxSize() != 0)
			pageCount++;// （不整除情况）
		page.setTotal(pageCount);// 设置总的页数
		if (page.getCurrent() > pageCount - 1)// 如果当前页数>总页数-1
			page.setHasnex(false);// 没有下一页					
		else
			page.setHasnex(true);// 还有下一页
		if (page.getCurrent() < 2)// 同理，没有上一页
			page.setHaspre(false);
		else
			page.setHaspre(true);
	}

	public String showBusiness() {
		if (page == null) {// 如果为空，则创建一个页操作类
			page = new Page();
			page.setCurrent(1); // 设置当前页数为1
		}
		// 获取用户收藏的企业的总数
		//获取当前用户
	//	user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
		user=userService.getUserByID(1);
		int total = userService.getBusinessesByUserId(user.getId()).size();
		checkPage(total);// 设置页面
		int start = (page.getCurrent() - 1) * page.getMaxSize();// 设置当前页面开始
		Businesses = userService.getBusinessesByPage(user.getId(), start, page.getMaxSize());
		return "showPage";
	}

	public List<Business> getBusinesses() {
		return Businesses;
	}

	public void setBusinesses(List<Business> businesses) {
		Businesses = businesses;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}

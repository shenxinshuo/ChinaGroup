package com.zhbit.findwork.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Collection_Business;
import com.zhbit.findwork.entity.Page;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.BusinessService;
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
	private Business business;
	private BusinessService businessService;
	private String message;				//用于返回信息给页面，提示用户
	private String errorMessage;		//显示异常信息
	
	public String deleteBusiness(){
		//设置目前登录用户的id是1
		System.out.println("删除收藏企业");
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
		boolean t=userService.deleteCollection_Business(user.getId(),business.getId());
		System.out.println(t);
		int p=page.getCurrent();
		System.out.println(p);
		page.setCurrent(p);//保存当前访问的页面
		System.out.println(page.getCurrent());
		System.out.println("dffffffffffffff");
		return "deleteBusiness";
	}
	//添加收藏企业
	public String addBusiness(){
		//user=userService.getUserByID(1);//获取当前登录的用户
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
		business=businessService.getBusinessByID(business.getId());
		Collection_Business c_b = new Collection_Business();
		c_b.setUser(user);
		c_b.setBusiness(business);
		System.out.println(user);
		System.out.println(business);
		System.out.println(c_b);
		boolean t =userService.addCollection_Business(c_b);
		if(t){
			message="收藏成功";
			return "addBusiness";
		}else{
			errorMessage="您已经收藏过,不用再收藏了";
			return "addBusiness";
		}
		
	}
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
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
	//	user=userService.getUserByID(1);
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
	
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	public BusinessService getBusinessService() {
		return businessService;
	}
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}

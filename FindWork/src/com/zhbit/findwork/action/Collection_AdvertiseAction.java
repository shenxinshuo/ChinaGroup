package com.zhbit.findwork.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Collection_Advertise;
import com.zhbit.findwork.entity.Collection_Business;
import com.zhbit.findwork.entity.Page;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.AdvertiseService;
import com.zhbit.findwork.service.UserService;

/**
 * 用户收藏类
 * 
 * @author 王德略
 *
 */
public class Collection_AdvertiseAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	private UserService userService;
	private List<Advertise> advertises; // 用来存储查询的招聘
	private Page page; // 页操控类
	private Advertise advertise;
	private AdvertiseService advertiseService;
	private String message;				//用于返回信息给页面，提示用户
	private String errorMessage;		//显示异常信息
	private Advertise as;
	public Advertise getAs() {
		return as;
	}
	public void setAs(Advertise as) {
		this.as = as;
	}
	public String addadvertise(){
		//user=userService.getUserByID(1);//获取当前登录的用户
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
		advertise=advertiseService.getAdvertiseByID(advertise.getId());
		as=advertise;
		int isUser=0;
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("isUser", isUser);
		Collection_Advertise ca = new Collection_Advertise();
		ca.setUser(user);
		ca.setAdvertise(advertise);
		boolean t =userService.addCollection_Advertise(ca);
		if(t){
			message="收藏成功";
			return "addAdvertise";
		}else{
			errorMessage="您已经收藏过,不用再收藏了";
			return "addAdvertise";
		}
		
	}
	//删除收藏的招聘信息
	public String deleteAdvertise(){
		System.out.println("删除收藏招聘");
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
		boolean t=userService.deleteCollection_Advertise(user.getId(), advertise.getId());
		System.out.println(t);
		int p=page.getCurrent();
		System.out.println(p);
		page.setCurrent(p);//保存当前访问的页面
		System.out.println(page.getCurrent());
		System.out.println("dffffffffffffff");
		return "deleteAdvertise";
	}
	//分页查询收藏的招聘
	public String showAdvertise() {
		if (page == null) {// 如果为空，则创建一个页操作类
			page = new Page();
			page.setCurrent(1); // 设置当前页数为1
		}	
		//获取当前用户
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
	//	user=userService.getUserByID(1);
		int total = userService.getAdvertisesByUserId(user.getId()).size();
		checkPage(total);// 设置页面
		int start = (page.getCurrent() - 1) * page.getMaxSize();// 设置当前页面开始
		advertises = userService.getAdvertisesByPage(user.getId(), start, page.getMaxSize());
		return "showPage";
	}

	
	//检查页面
	public void checkPage(int total) {
		page.setMaxSize(4);// 设置当前页面最大的数量
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
	public List<Advertise> getAdvertises() {
		return advertises;
	}
	public void setAdvertises(List<Advertise> advertises) {
		this.advertises = advertises;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Advertise getAdvertise() {
		return advertise;
	}
	public void setAdvertise(Advertise advertise) {
		this.advertise = advertise;
	}
	public AdvertiseService getAdvertiseService() {
		return advertiseService;
	}
	public void setAdvertiseService(AdvertiseService advertiseService) {
		this.advertiseService = advertiseService;
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
